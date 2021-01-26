/**
 * 
 */
package com.iii.amirutham.model.shoppingcart;

import java.math.BigDecimal;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iii.amirutham.model.BaseEntity;
import com.iii.amirutham.model.product.AmiruthamProducts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity(name = "cartitem")
@Table(name = "cartitem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItem extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@SuppressWarnings("deprecation")
	@Column(name = "QUANTITY")
	private Integer quantity = new Integer(1);

	@Column(name = "PRODUCT_ID", nullable = false) // TODO CODE
	private Integer productId;
	
	@Column(name = "PRODUCT_VARIENT_ID", nullable = false) // TODO CODE
	private Integer varientId;
	
	@Column(name = "ITEM_NAME", nullable = false) // TODO CODE
	private String itemName;
	
	@Column(name = "ITEM_IMGURL", nullable = false) // TODO CODE
	private String ItemImgURL;
	
	@Column(name = "ITEM_SELLER", nullable = false) // TODO CODE
	private String sellerName="Amirum & Oil .co";

	@Column(name = "PRODUCT_CODE", nullable = false) // TODO CODE
	private String productCode;
	
	@Column(name = "CART_CODE", nullable = false) // TODO CODE
	private String cartCode;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_item_id",referencedColumnName = "id")
	private ShoppingCartAttributeItem attributes;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "cartitemid",referencedColumnName = "id")
	private TaxInformation taxinfo;
	
	
	
	private BigDecimal itemPrice;// item final price including all rebates

	// @JsonIgnore
	// @Transient
	private BigDecimal subTotal;// item final price * quantity

	/*
	 * @JsonIgnore
	 * 
	 * @Transient private FinalPrice finalPrice;//contains price details (raw
	 * prices)
	 */
	//@JsonIgnore
	@Transient
	private AmiruthamProducts product;

	@JsonIgnore
	@Transient
	private boolean obsolete = false;

	public ShoppingCartItem(AmiruthamProducts product) {
		this.product = product;
		this.productId = product.getId();
		this.productCode = product.getProductCode();
		this.quantity = 1;

	}

}
