/**
 * 
 */
package com.iii.amirutham.model.order;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iii.amirutham.model.BaseEntity;

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
	
	private String productCode;
	
	@Column (name="PRODUCT_NAME" , length=64 , nullable=false)
	private String productName;

	@Column (name="PRODUCT_QUANTITY")
	private int productQuantity;
	
	@Column (name="ONETIME_CHARGE" , nullable=false )
	private BigDecimal oneTimeCharge;

	
	@Column(name = "PRODUCT_PRICE", nullable = false)
	private BigDecimal productPrice;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	private Order order;
	

}
