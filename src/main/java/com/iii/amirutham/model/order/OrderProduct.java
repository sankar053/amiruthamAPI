/**
 * 
 */
package com.iii.amirutham.model.order;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "orderlineitems")
@Table(name = "orderlineitems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ORDER_PRODUCT_CODE", nullable = false) // TODO CODE
	private String orderedproductCode;
	
	@Column(name = "ORDER_PRODUCT_ID", nullable = false) // TODO CODE
	private Integer orderedproductId;
	
	@Column (name="ORDER_PRODUCT_NAME" , length=64 , nullable=false)
	private String orderedproductName;
	
	@Transient
	private AmiruthamProducts product;

	@Column (name="ORDER_QUANTITY")
	private Integer orderedQuantity = new Integer(1);;
	
	@Column(name = "ORDER_PRODUCT_IMGURL", nullable = false) // TODO CODE
	private String productImgURL;
	
	@Column(name = "PRODUCT_SELLER", nullable = false) // TODO CODE
	private String sellerName="Amirum & Oil .co";

	
	@Column(name = "PRODUCT_PRICE", nullable = false)
	private BigDecimal productPrice;
	
	@Column(name = "PRODUCT_SUB_TOTAL", nullable = false)
	private BigDecimal subTotal;// item final price * quantity

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_item_id",referencedColumnName = "id")
	private OrderAttribute attributes;

	@JsonIgnore
	@ManyToOne(targetEntity = Orders.class)
	@JoinColumn(name = "ORDER_ID", nullable = true)
	private Orders order;
	

}
