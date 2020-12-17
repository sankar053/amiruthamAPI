package com.iii.amirutham.model.shoppingcart;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "addonChatges")
@Table(name = "addonChatges")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOnCharges extends BaseEntity{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "chargeamount", nullable = false)
	private BigDecimal chargeAmount=new BigDecimal(40.00);

	@Column(name = "description", nullable = false) // TODO CODE
	private String description="ShipmentCharges";

	@Column(name = "discounted", nullable = false) 
	private boolean discounted = false;
	
	@Column(name = "discountPercent", nullable = false) 
	private int discountPercent = 0;
	


}
