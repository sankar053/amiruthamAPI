/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.dto.model.CartItemDto;
import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.ProductVarient;
import com.iii.amirutham.model.shoppingcart.AddOnCharges;
import com.iii.amirutham.model.shoppingcart.ShoppingCart;
import com.iii.amirutham.model.shoppingcart.ShoppingCartAttributeItem;
import com.iii.amirutham.model.shoppingcart.ShoppingCartItem;
import com.iii.amirutham.repo.CartRepository;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.service.CartService;
import com.iii.amirutham.service.SequenceService;
import com.iii.amirutham.service.UserService;

/**
 * @author sanka
 *
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private UserService userService;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SequenceService seqservice;

	/*
	 * @Autowired private SellerRepository sellerRepository;
	 */

	@Override
	public ShoppingCart addMyLocalCart(CartRequest cartRequest) {
		UserDetailsImpl user = userService.getUserDetails();
	//	Optional<MerchantStore> seller = sellerRepository.findById(1);
		// TODO Auto-generated method stub
		Set<ShoppingCartItem> cartItems = new HashSet<ShoppingCartItem>();
		for (CartItemDto mycartItem : cartRequest.getCartItems()) {
			Optional<AmiruthamProducts> product = productRepository.findById(mycartItem.getProductId());
			if (product.isPresent()) {
				ProductVarient varient = product.get().getProdVarient().stream().filter(v -> v.getId()==mycartItem.getVarientId()).findAny()
						.orElse(null);
				
				ShoppingCartItem item = new ShoppingCartItem();
				item.setProduct(product.get());
				item.setProductCode(product.get().getProductCode());
				item.setProductId(product.get().getId());
				item.setQuantity(mycartItem.getQuantity());
				item.setItemPrice(new BigDecimal(varient.getSellingPrice()));
				BigDecimal st = item.getItemPrice().multiply(new BigDecimal(item.getQuantity()));
				item.setSubTotal(st);
				item.setAttributes(new ShoppingCartAttributeItem(varient.getMaximumRetailPrice(),varient.getSellingPrice()
						,varient.getSavedPrice(),varient.getDiscount(),varient.getUnit(),varient.getUnitType(),varient.getProdCode()
						,varient.getManufactureDate(),varient.getBestBeforeDate(),item));
				// item.set
				cartItems.add(item);
			}

		}

		ShoppingCart myCart = new ShoppingCart();
		SequnceDto sequence = seqservice.findMySeQuence("CART");
		myCart.setShoppingCartCode(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
		seqservice.updateMySeQuence(sequence);
	//	myCart.setMerchantStore(seller.get());
		myCart.setCustomerId(user.getId());
		myCart.setLineItems(cartItems);
		myCart.setCharges(new AddOnCharges());
		//myCart.setShoppingCartStatus("Temp");
		return cartRepository.save(myCart);
	}
	
	@Override
	public ShoppingCart getMyCart(Integer ConsumerId) {
		
		
		List<ShoppingCart> mycartlist = cartRepository.findByCustomerId(ConsumerId);
		ShoppingCart mycart =mycartlist.stream().filter(v -> "Pending".equals(v.getShoppingCartStatus())).findAny()
				.orElse(null);
		return mycart;
	}

}
