/**
 * 
 */
package com.iii.amirutham.model.shoppingcart;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity(name = "cart")
@Table(name = "cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "SHP_CART_CODE", unique = true, nullable = false)
	private String shoppingCartCode;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "cartid")
	private Set<ShoppingCartItem> lineItems = new HashSet<ShoppingCartItem>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
	private AddOnCharges charges;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name="MERCHANT_ID", nullable=false) private MerchantStore
	 * merchantStore;
	 */
	/*
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "cart_item_id") private ShoppingCartAttributeItem
	 * attributes;
	 */

	@Column(name = "CUSTOMER_ID", nullable = true)
	private Integer customerId;

	@Column(name = "ORDER_ID", nullable = true)
	private Integer orderId;

	@Column(name = "SHP_CART_STATUS", nullable = false)
	private String shoppingCartStatus = "Pending";

}
