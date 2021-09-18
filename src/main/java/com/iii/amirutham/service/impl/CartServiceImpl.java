/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.iii.amirutham.model.shoppingcart.TaxInformation;
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

	@Transactional
	@Override
	public CartDto addORUpdateMyLocalCart(CartRequest cartRequest) {
		
		UserDetailsImpl user = userService.getUserDetails();
		ShoppingCart pendingcart = cartRepository.findByCustomerIdAndShoppingCartStatus(user.getId(),"Pending");
		
		if(null==pendingcart) {
			ShoppingCart myCart = new ShoppingCart();
			SequnceDto sequence = seqservice.findMySeQuence("CART");
			myCart.setShoppingCartCode(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
			seqservice.updateMySeQuence(sequence);
			// myCart.setMerchantStore(seller.get());
			myCart.setCustomerId(user.getId());
			BigDecimal finalPrice = new BigDecimal(0);
			Set<ShoppingCartItem> cartItems = new HashSet<ShoppingCartItem>();
		
			for (CategoryRequestItems mycartItem : cartRequest.getCartItems()) {
				Optional<AmiruthamProducts> product = productRepository.findById(mycartItem.getProductId());
				if (product.isPresent()) {
					ProductVarient varient = product.get().getProdVarient().stream()
							.filter(v -> v.getId() == mycartItem.getVarientId()).findAny().orElse(null);

					List<ProductMediaGallary> media = product.get().getProdMedias();

					ShoppingCartItem item = new ShoppingCartItem();
					item.setProduct(product.get());
					item.setItemImgURL((null != media && media.size()>0) ? media.get(0).getProdImgUrl() : "");
					item.setItemName(product.get().getProductNm());
					item.setProductCode(product.get().getProductCode());
					item.setProductId(product.get().getId());
					item.setCartCode(myCart.getShoppingCartCode());
					item.setVarientId(varient.getId());
					item.setQuantity(mycartItem.getQuantity());
					item.setItemPrice(new BigDecimal(varient.getSellingPrice()));
					BigDecimal st = item.getItemPrice().multiply(new BigDecimal(item.getQuantity()));
					item.setSubTotal(st);
					finalPrice = finalPrice.add(item.getSubTotal());
					item.setAttributes(new ShoppingCartAttributeItem(varient.getMaximumRetailPrice(),
							varient.getSellingPrice(), varient.getSavedPrice(), varient.getDiscount(), varient.getUnit(),
							varient.getUnitType(), varient.getProdCode(), varient.getManufactureDate(),
							varient.getBestBeforeDate(), item));
			//		 item.setMyCart(myCart);
					
					
					BigDecimal sgst=item.getSubTotal().multiply(new BigDecimal(varient.getSgst()/100));
					BigDecimal cgst=item.getSubTotal().multiply(new BigDecimal(varient.getCgst()/100));
					
					BigDecimal Taxpayable =sgst.add(cgst);
//					TaxInformation(BigDecimal finalTaxAmount, Double totalTaxPresentage, BigDecimal sgstPresentage,
//							BigDecimal sgst, BigDecimal cgstPresentage, BigDecimal cgst, String description) {
					item.setTaxinfo(new TaxInformation(Taxpayable,(varient.getSgst()+varient.getCgst()),
							varient.getSgst(),sgst,
							varient.getCgst(),cgst,"Tax Deducted"));
					cartItems.add(item);
					
				}

			}

			
			myCart.setLineItems(cartItems);
			myCart.setCharges(new AddOnCharges());
			myCart.setFinalpriceWithoutTax(finalPrice.setScale(2,BigDecimal.ROUND_HALF_DOWN));
			myCart.setFinalpriceWithTax(finalPrice.add(myCart.getCharges().getChargeAmount()).setScale(2,BigDecimal.ROUND_HALF_DOWN));
		//	myCart= calculateCartTotal(myCart);
					
			ShoppingCart savedCart= cartRepository.save(myCart);
			return null != savedCart ? ((CartDto) AmirthumUtills.convertToDto(savedCart, CartDto.class, modelMapper))
					: null;
		}else {
			
			
			Set<Integer> ids = pendingcart.getLineItems().stream()
					.map(ShoppingCartItem::getId).collect(Collectors.toSet());
			if(null == cartRequest.getCartItems() || cartRequest.getCartItems().isEmpty()) {
				deleteCartItemByIds(ids);
				cartRepository.delete(pendingcart);
			} else {
				for (CategoryRequestItems mycartItem : cartRequest.getCartItems()) {
					ShoppingCartItem item=	cartItemRepository.findByProductIdAndVarientIdAndCartCode(mycartItem.getProductId(),
							mycartItem.getVarientId(),pendingcart.getShoppingCartCode());
					if(null == item) {
						additemtoCart1(mycartItem,pendingcart);
					} else {
						updateitemtoCart1(item,pendingcart,mycartItem.getQuantity());
						ids.remove(item.getId());
					}
				}
				deleteCartItemByIds(ids);
			}	
			
	
			Optional<ShoppingCart> updatedcart = cartRepository.findById(pendingcart.getId());
			
			if(updatedcart.isPresent()) {
				ShoppingCart mycart = updatedcart.get();
				Set<ShoppingCartItem> ShoppingCartItem=mycart.getLineItems().stream().filter(uc->"N".equalsIgnoreCase(uc.getIsDeleted())).collect(Collectors.toSet());
				mycart.setLineItems(ShoppingCartItem);
				return ((CartDto) AmirthumUtills.convertToDto(ShoppingCartItem, CartDto.class, modelMapper));
			}
			
			
		}
		return null;
		

	}

	@Override
	public List<ShoppingCart> getAllCart() {

		List<ShoppingCart> mycartlist = cartRepository.findAll();
//		ShoppingCart mycart = mycartlist.stream().filter(v -> "Pending".equals(v.getShoppingCartStatus())).findAny()
//				.orElse(null);
		return mycartlist;

		// return cartDto;
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
	public CartDto updateMyLocalCart(CartRequest cartRequest) throws UserNotFoundException {
		// TODO Auto-generated method stub

		Optional<ShoppingCart> cart = cartRepository.findById(cartRequest.getCartid());

		if (cart.isPresent()) {
			for (CategoryRequestItems mycartItem : cartRequest.getCartItems()) {
				System.out.println(mycartItem.getItemUpdateStatus());
				deleteitemfromCart(mycartItem, cart.get());
				if ("A".equalsIgnoreCase(mycartItem.getItemUpdateStatus()))
					additemtoCart(mycartItem, cart.get());
				if ("U".equalsIgnoreCase(mycartItem.getItemUpdateStatus()))
					updateitemtoCart(mycartItem, cart.get());
				if ("D".equalsIgnoreCase(mycartItem.getItemUpdateStatus()))
					deleteitemfromCart(mycartItem, cart.get());

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

			List<ProductMediaGallary> media = product.get().getProdMedias();

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
			updateCart.getFinalpriceWithTax().add(st);
		}
		updateCart = calculateCartTotal(updateCart);
		updateCart = cartRepository.save(updateCart);
		return updateCart;
	}
	
	public ShoppingCart additemtoCart1(CategoryRequestItems mycartItem, ShoppingCart pendingCart) {

		Optional<AmiruthamProducts> product = productRepository.findById(mycartItem.getProductId());
		if (product.isPresent()) {
			ProductVarient varient = product.get().getProdVarient().stream()
					.filter(v -> v.getId() == mycartItem.getVarientId()).findAny().orElse(null);

			List<ProductMediaGallary> media = product.get().getProdMedias();

			ShoppingCartItem item = new ShoppingCartItem();
			item.setProduct(product.get());
			item.setItemImgURL(null != media ? media.get(0).getProdImgUrl() : null);
			item.setItemName(product.get().getProductNm());
			item.setProductCode(product.get().getProductCode());
			item.setVarientId(varient.getId());
			item.setProductId(product.get().getId());
			item.setCartCode(pendingCart.getShoppingCartCode());
			item.setQuantity(mycartItem.getQuantity());
			item.setItemPrice(new BigDecimal(varient.getSellingPrice()));
			BigDecimal st = item.getItemPrice().multiply(new BigDecimal(item.getQuantity()));
			item.setSubTotal(st);
			item.setAttributes(new ShoppingCartAttributeItem(varient.getMaximumRetailPrice(), varient.getSellingPrice(),
					varient.getSavedPrice(), varient.getDiscount(), varient.getUnit(), varient.getUnitType(),
					varient.getProdCode(), varient.getManufactureDate(), varient.getBestBeforeDate(), item));
			
			BigDecimal sgst=item.getSubTotal().multiply(new BigDecimal(varient.getSgst()/100));
			BigDecimal cgst=item.getSubTotal().multiply(new BigDecimal(varient.getCgst()/100));
			
			BigDecimal Taxpayable =sgst.add(cgst);

			item.setTaxinfo(new TaxInformation(Taxpayable,(varient.getSgst()+varient.getCgst()),
					varient.getSgst(),sgst,
					varient.getCgst(),cgst,"Tax Deducted"));
			
			// item.set
			pendingCart.getLineItems().add(item);
			pendingCart.getFinalpriceWithTax().add(st);
			
			
		}
		pendingCart = calculateCartTotal(pendingCart);
		pendingCart = cartRepository.save(pendingCart);
		return pendingCart;
	}

	public ShoppingCart calculateCartTotal(ShoppingCart cartDao) {

		BigDecimal finalPrcWthoutCharge = new BigDecimal(0);
		BigDecimal TotalTaxforcart = new BigDecimal(0);

		finalPrcWthoutCharge = cartDao.getLineItems().stream().filter(v -> "N".equals(v.getIsDeleted()))
				.map(ci -> ci.getSubTotal()) // map
				.reduce(BigDecimal.ZERO, BigDecimal::add); // reduce
		
		TotalTaxforcart = cartDao.getLineItems().stream().filter(v -> "N".equals(v.getIsDeleted()))
				.map(ci -> ci.getTaxinfo().getFinalTaxAmount()) // map
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		cartDao.setFinalpriceWithoutTax(finalPrcWthoutCharge.setScale(2,BigDecimal.ROUND_HALF_DOWN));
		cartDao.setFinalpriceWithTax(
				cartDao.getFinalpriceWithoutTax().add(TotalTaxforcart).setScale(2,BigDecimal.ROUND_HALF_DOWN));
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
			updateCart.setFinalpriceWithoutTax(updateCart.getFinalpriceWithoutTax().add(st).setScale(2,BigDecimal.ROUND_HALF_DOWN));
			updateCart.setFinalpriceWithTax(
					updateCart.getFinalpriceWithoutTax().add(updateCart.getCharges().getChargeAmount()).setScale(2,BigDecimal.ROUND_HALF_DOWN));
			updateCart = calculateCartTotal(updateCart);
			cartRepository.save(updateCart);
		} else {
			throw new UserNotFoundException(messages.getMessage("cart.item.message.NotExists", null, null));
		}

	}
	
	public void updateitemtoCart1(ShoppingCartItem lineitem, ShoppingCart updateCart,Integer quantity) {


			ShoppingCartAttributeItem varient = lineitem.getAttributes();
			TaxInformation taxinfo = lineitem.getTaxinfo();
			lineitem.setQuantity(quantity);
			lineitem.setItemPrice(new BigDecimal(varient.getSellingPrice()));
			BigDecimal st = lineitem.getItemPrice().multiply(new BigDecimal(quantity));
			lineitem.setSubTotal(st);
			
			BigDecimal sgst=lineitem.getSubTotal().multiply(new BigDecimal(taxinfo.getSgstPresentage()/100));
			BigDecimal cgst=lineitem.getSubTotal().multiply(new BigDecimal(taxinfo.getCgstPresentage()/100));
			BigDecimal updatedTaxpayable =sgst.add(cgst);
			taxinfo.setFinalTaxAmount(updatedTaxpayable);
			taxinfo.setCgst(cgst);
			taxinfo.setCgst(cgst);
			lineitem.setTaxinfo(taxinfo);
			
			updateCart.getLineItems().add(lineitem);
			// cartItemRepository.save(lineitem);
			updateCart.setFinalpriceWithoutTax(updateCart.getFinalpriceWithoutTax().add(st).setScale(2,BigDecimal.ROUND_HALF_DOWN));
			updateCart.setFinalpriceWithTax(
					updateCart.getFinalpriceWithoutTax().add(updateCart.getCharges().getChargeAmount()).setScale(2,BigDecimal.ROUND_HALF_DOWN));
			updateCart = calculateCartTotal(updateCart);
			cartRepository.save(updateCart);
		

	}

	public ShoppingCart deleteitemfromCart(CategoryRequestItems mycartItem, ShoppingCart updateCart) {
		ShoppingCartItem lineitem = updateCart.getLineItems().stream().filter(v -> v.getId() == mycartItem.getItemId())
				.findAny().orElse(null);
		lineitem.setIsDeleted("Y");
		cartItemRepository.updateIsDeletedStatus(mycartItem.getItemId(), "Y");
		return updateCart;

	}
	public void deleteitemfromCart(ShoppingCartItem lineitem) {

		lineitem.setIsDeleted("Y");
		cartItemRepository.updateIsDeletedStatus(lineitem.getId(), "Y");
	

	}
	
	private void deleteCartItemByIds(Set<Integer> ids) {
		if(null != ids) {
			ids.forEach(id -> cartItemRepository.updateIsDeletedStatus(id, "Y"));
		}
	}
}
