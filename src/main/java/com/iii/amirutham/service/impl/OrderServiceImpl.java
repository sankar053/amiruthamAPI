/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.common.EmailService;
import com.iii.amirutham.common.mail.dto.OrderDataMail;
import com.iii.amirutham.common.mail.dto.OrderDeliveryDetails;
import com.iii.amirutham.common.mail.dto.OrderItemsMail;
import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.model.AddressDto;
import com.iii.amirutham.dto.model.OrderDto;
import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.Address;
import com.iii.amirutham.model.order.OrderAttribute;
import com.iii.amirutham.model.order.OrderProduct;
import com.iii.amirutham.model.order.OrderStatus;
import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.shoppingcart.ShoppingCart;
import com.iii.amirutham.model.shoppingcart.ShoppingCartItem;
import com.iii.amirutham.model.user.User;
import com.iii.amirutham.repo.AddressRepository;
import com.iii.amirutham.repo.CartRepository;
import com.iii.amirutham.repo.OrderRepository;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.repo.UserRepository;
import com.iii.amirutham.service.OrderService;
import com.iii.amirutham.service.SequenceService;
import com.iii.amirutham.service.UserService;

/**
 * @author sanka
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private SequenceService seqservice;

	@Override
	public String placeOrder(OrderDto orderDto) {
		// TODO Auto-generated method stub
		UserDetailsImpl user = userService.getUserDetails();
		Optional<ShoppingCart> mycart = cartRepository.findById(orderDto.getCartId());
		if (mycart.isPresent() && "Pending".equals(mycart.get().getShoppingCartStatus())) {
			ShoppingCart mypendingCart = mycart.get();
			Orders orderDao = new Orders();
			// order.setCustomerId(user.getId());
			SequnceDto sequence = seqservice.findMySeQuence("ORDER");
			orderDao.setOrderCode(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
			seqservice.updateMySeQuence(sequence);
			orderDao.setLastModified(new Date());
			orderDao.setDatePurchased(new Date());
			orderDao.setReceiverName(orderDto.getReceiverName());
			orderDao.setReceiverPhoneNumber(orderDto.getReceiverPhoneNumber());
			orderDao.setTotal(mypendingCart.getFinalpriceWithTax());
			orderDao.setShoppingCartCode(mypendingCart.getShoppingCartCode());
			orderDao.setUser(userRepository.findById(user.getId()).get());
			orderDao.setAddress(getShippingAddress(orderDto.getShippingAddress(), orderDao.getUser()));
			Set<OrderProduct> orderProducts = new LinkedHashSet<OrderProduct>();
			for (ShoppingCartItem cartItem : mypendingCart.getLineItems()) {
				Optional<AmiruthamProducts> product = productRepository.findById(cartItem.getProductId());
				if (product.isPresent()) {
					OrderProduct oProduct = new OrderProduct();

					oProduct.setOrderedproductCode(cartItem.getProductCode());
					oProduct.setOrderedproductName(product.get().getProductNm());
					oProduct.setProductPrice(cartItem.getItemPrice());
					oProduct.setSubTotal(cartItem.getSubTotal());
					oProduct.setOrderedproductId(cartItem.getProductId());
					oProduct.setOrderedQuantity(cartItem.getQuantity());
					oProduct.setProductImgURL(cartItem.getItemImgURL());
					oProduct.setAttributes(new OrderAttribute(cartItem.getAttributes().getMaximumRetailPrice(),
							cartItem.getAttributes().getSellingPrice(), cartItem.getAttributes().getSavedPrice(),
							cartItem.getAttributes().getDiscount(), cartItem.getAttributes().getUnit(),
							cartItem.getAttributes().getUnitType(), cartItem.getAttributes().getProdCode(),
							cartItem.getAttributes().getManufactureDate(), cartItem.getAttributes().getBestBeforeDate(),
							oProduct));
					oProduct.setOrder(orderDao);
					orderProducts.add(oProduct);
				}
			}
			orderDao.setOrderProducts(orderProducts);

			orderDao = orderRepository.save(orderDao);
			cartRepository.updateShoppingCartStatus(orderDto.getCartId(), "Converted");
			
			sentMailforOrderConformation(orderDao,user);
			
			
			return orderDao.getOrderCode();
		}
		return null;

	}
	
	
	
	void sentMailforOrderConformation(Orders orderDao,UserDetailsImpl user){
		
		
		List<OrderItemsMail> orderedItem = new ArrayList<OrderItemsMail>();
		
		Set<OrderProduct> orderedProducts =orderDao.getOrderProducts();
		if(null!=orderedProducts) {
			for(OrderProduct product : orderedProducts) {
				orderedItem.add(new OrderItemsMail(product.getOrderedproductName(),
						product.getOrderedQuantity(),product.getProductPrice()) );
			}
		}
		
		Address shippingAddress = orderDao.getAddress();
		OrderDeliveryDetails address =new OrderDeliveryDetails(orderDao.getReceiverName(),
				user.getEmail(),orderDao.getReceiverPhoneNumber(),
				shippingAddress.getAddress1()+" "+shippingAddress.getAddress2(),
				shippingAddress.getCity()+"-"+shippingAddress.getPostalCopde(),
				shippingAddress.getState());
		
	
		OrderDataMail order =new OrderDataMail(orderDao.getOrderCode(),
				user.getFirstName(),
				orderDao.getTotal(),"Free Shipping",
				"50","COD",orderDao.getTotal(),orderedItem,address,"http:localhost:4200/home");
		emailService.sendTemplateEmail(user.getEmail(), "Your Amiruthum ePortal order has been received!", "order-Conformation-template", 
				order, null);
	}
	
	
	
	

	public Address getShippingAddress(AddressDto addressDto, User u) {
		if (null != addressDto.getId()) {
			Optional<Address> address = addressRepo.findById(addressDto.getId());
			if (address.isPresent())
				return address.get();
			else
				return addressRepo.save(new Address(addressDto.getAddress1(), addressDto.getAddress2(), "Shipment",
						addressDto.getCity(), addressDto.getState(), addressDto.getPostalCopde(), u));
		} else {
			return addressRepo.save(new Address(addressDto.getAddress1(), addressDto.getAddress2(), "Shipment",
					addressDto.getCity(), addressDto.getState(), addressDto.getPostalCopde(), u));
		}

	}

	@Override
	public Orders getOrdersById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Orders> order = orderRepository.findById(id);
		if (order.isPresent())
			return order.get();
		else
			throw new UserNotFoundException("Orders Not Found");
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return (List<Orders>) orderRepository.findAll();
	}

	@Override
	public void updateOrderprocess(Integer id, OrderStatus status) {
		// TODO Auto-generated method stub
		orderRepository.updateOrderStatus(id, status);

	}

}
