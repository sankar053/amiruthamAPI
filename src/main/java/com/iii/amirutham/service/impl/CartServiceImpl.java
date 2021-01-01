/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.dto.model.CartDto;
import com.iii.amirutham.dto.model.CategoryRequestItems;
import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.ProductMediaGallary;
import com.iii.amirutham.model.product.ProductVarient;
import com.iii.amirutham.model.shoppingcart.AddOnCharges;
import com.iii.amirutham.model.shoppingcart.ShoppingCart;
import com.iii.amirutham.model.shoppingcart.ShoppingCartAttributeItem;
import com.iii.amirutham.model.shoppingcart.ShoppingCartItem;
import com.iii.amirutham.repo.CartItemRepository;
import com.iii.amirutham.repo.CartRepository;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.service.CartService;
import com.iii.amirutham.service.SequenceService;
import com.iii.amirutham.service.UserService;
import com.iii.amirutham.utills.AmirthumUtills;

/**
 * @author sanka
 *
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messages;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SequenceService seqservice;

	/*
	 * @Autowired private SellerRepository sellerRepository;
	 */

	@Override
	public CartDto addMyLocalCart(CartRequest cartRequest) {
		UserDetailsImpl user = userService.getUserDetails();
		// Optional<MerchantStore> seller = sellerRepository.findById(1);
		// TODO Auto-generated method stub
		BigDecimal finalPrice = new BigDecimal(0);
		Set<ShoppingCartItem> cartItems = new HashSet<ShoppingCartItem>();
		for (CategoryRequestItems mycartItem : cartRequest.getCartItems()) {
			Optional<AmiruthamProducts> product = productRepository.findById(mycartItem.getProductId());
			if (product.isPresent()) {
				ProductVarient varient = product.get().getProdVarient().stream()
						.filter(v -> v.getId() == mycartItem.getVarientId()).findAny().orElse(null);

				List<ProductMediaGallary> media = product.get().getProdImgs();

				ShoppingCartItem item = new ShoppingCartItem();
				item.setProduct(product.get());
				item.setItemImgURL(null != media ? media.get(0).getProdImgUrl() : null);
				item.setItemName(product.get().getProductNm());
				item.setProductCode(product.get().getProductCode());
				item.setProductId(product.get().getId());
				item.setQuantity(mycartItem.getQuantity());
				item.setItemPrice(new BigDecimal(varient.getSellingPrice()));
				BigDecimal st = item.getItemPrice().multiply(new BigDecimal(item.getQuantity()));
				item.setSubTotal(st);
				finalPrice = finalPrice.add(item.getSubTotal());
				item.setAttributes(new ShoppingCartAttributeItem(varient.getMaximumRetailPrice(),
						varient.getSellingPrice(), varient.getSavedPrice(), varient.getDiscount(), varient.getUnit(),
						varient.getUnitType(), varient.getProdCode(), varient.getManufactureDate(),
						varient.getBestBeforeDate(), item));
				// item.set
				cartItems.add(item);
			}

		}

		ShoppingCart myCart = new ShoppingCart();
		SequnceDto sequence = seqservice.findMySeQuence("CART");
		myCart.setShoppingCartCode(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
		seqservice.updateMySeQuence(sequence);
		// myCart.setMerchantStore(seller.get());
		myCart.setCustomerId(user.getId());
		myCart.setLineItems(cartItems);
		myCart.setCharges(new AddOnCharges());
		myCart.setFinalpriceWithoutCharges(finalPrice);
		myCart.setFinalpriceWithCharges(finalPrice.add(myCart.getCharges().getChargeAmount()));
		myCart= calculateCartTotal(myCart);
				
		ShoppingCart savedCart= cartRepository.save(myCart);
		return null != savedCart ? ((CartDto) AmirthumUtills.convertToDto(savedCart, CartDto.class, modelMapper))
				: null;

	}

	@Override
	public CartDto getMyCart(Integer ConsumerId) {

		List<ShoppingCart> mycartlist = cartRepository.findByCustomerId(ConsumerId);
		ShoppingCart mycart = mycartlist.stream().filter(v -> "Pending".equals(v.getShoppingCartStatus())).findAny()
				.orElse(null);
		return null != mycart ? ((CartDto) AmirthumUtills.convertToDto(mycart, CartDto.class, modelMapper)) : null;

		// return cartDto;
	}

	@Override
	public CartDto updateMyLocalCart(CartRequest cartRequest) throws UserNotFoundException{
		// TODO Auto-generated method stub

		Optional<ShoppingCart> cart = cartRepository.findById(cartRequest.getCartid());

		if (cart.isPresent()) {
			for (CategoryRequestItems mycartItem : cartRequest.getCartItems()) {
				if ("A".equalsIgnoreCase(mycartItem.getItemUpdateStatus()))
					additemtoCart(mycartItem, cart.get());
				if ("U".equalsIgnoreCase(mycartItem.getItemUpdateStatus()))
					updateitemtoCart(mycartItem, cart.get());
				if ("D".equalsIgnoreCase(mycartItem.getItemUpdateStatus()))
					ShoppingCart updateCart = deleteitemfromCart(mycartItem, cart.get());

			}
		} else {
         throw new UserNotFoundException(messages.getMessage("cart.message.NotExists", null, null));
		}
		Optional<ShoppingCart> updatedcart = cartRepository.findById(cartRequest.getCartid());
		return updatedcart.isPresent()
				? ((CartDto) AmirthumUtills.convertToDto(updatedcart.get(), CartDto.class, modelMapper))
				: null;

	}

	public ShoppingCart additemtoCart(CategoryRequestItems mycartItem, ShoppingCart updateCart) {

		Optional<AmiruthamProducts> product = productRepository.findById(mycartItem.getProductId());
		if (product.isPresent()) {
			ProductVarient varient = product.get().getProdVarient().stream()
					.filter(v -> v.getId() == mycartItem.getVarientId()).findAny().orElse(null);

			List<ProductMediaGallary> media = product.get().getProdImgs();

			ShoppingCartItem item = new ShoppingCartItem();
			item.setProduct(product.get());
			item.setItemImgURL(null != media ? media.get(0).getProdImgUrl() : null);
			item.setItemName(product.get().getProductNm());
			item.setProductCode(product.get().getProductCode());
			item.setProductId(product.get().getId());
			item.setQuantity(mycartItem.getQuantity());
			item.setItemPrice(new BigDecimal(varient.getSellingPrice()));
			BigDecimal st = item.getItemPrice().multiply(new BigDecimal(item.getQuantity()));
			item.setSubTotal(st);
			item.setAttributes(new ShoppingCartAttributeItem(varient.getMaximumRetailPrice(), varient.getSellingPrice(),
					varient.getSavedPrice(), varient.getDiscount(), varient.getUnit(), varient.getUnitType(),
					varient.getProdCode(), varient.getManufactureDate(), varient.getBestBeforeDate(), item));
			// item.set
			updateCart.getLineItems().add(item);
			updateCart.getFinalpriceWithCharges().add(st);
		}
		updateCart= calculateCartTotal(updateCart);
		updateCart = cartRepository.save(updateCart);
		return updateCart;
	}

	public ShoppingCart calculateCartTotal(ShoppingCart cartDao) {

		BigDecimal finalPrcWthoutCharge = new BigDecimal(0);

		finalPrcWthoutCharge = cartDao.getLineItems().stream().filter(v -> "N".equals(v.getIsDeleted())).map(ci -> ci.getSubTotal()) // map
				.reduce(BigDecimal.ZERO, BigDecimal::add); // reduce

		cartDao.setFinalpriceWithoutCharges(finalPrcWthoutCharge);
		cartDao.setFinalpriceWithCharges(
				cartDao.getFinalpriceWithoutCharges().add(cartDao.getCharges().getChargeAmount()));
		return cartRepository.save(cartDao);
		
	}

	public void updateitemtoCart(CategoryRequestItems mycartItem, ShoppingCart updateCart) {

		ShoppingCartItem lineitem = updateCart.getLineItems().stream().filter(v -> v.getId() == mycartItem.getItemId())
				.findAny().orElse(null);
		if (null != lineitem) {
			ShoppingCartAttributeItem varient = lineitem.getAttributes();

			lineitem.setQuantity(mycartItem.getQuantity());
			lineitem.setItemPrice(new BigDecimal(varient.getSellingPrice()));
			BigDecimal st = lineitem.getItemPrice().multiply(new BigDecimal(lineitem.getQuantity()));
			lineitem.setSubTotal(st);
			updateCart.getLineItems().add(lineitem);
			// cartItemRepository.save(lineitem);
			updateCart.setFinalpriceWithoutCharges(updateCart.getFinalpriceWithoutCharges().add(st));
			updateCart.setFinalpriceWithCharges(
					updateCart.getFinalpriceWithoutCharges().add(updateCart.getCharges().getChargeAmount()));
			updateCart= calculateCartTotal(updateCart);
			cartRepository.save(updateCart);
		}else {
			 throw new UserNotFoundException(messages.getMessage("cart.item.message.NotExists", null, null));
		}

	}

	public ShoppingCart deleteitemfromCart(CategoryRequestItems mycartItem, ShoppingCart updateCart) {
		ShoppingCartItem lineitem = updateCart.getLineItems().stream().filter(v -> v.getId() == mycartItem.getItemId())
				.findAny().orElse(null);
		lineitem.setIsDeleted("Y");
		cartItemRepository.updateIsDeletedStatus(mycartItem.getItemId(),"Y");
		return updateCart;
	
	}
}
