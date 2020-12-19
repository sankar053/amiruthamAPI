package com.iii.amirutham.dto.model;

import java.math.BigDecimal;

import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddditionalChargesDto extends BaseEntity{
	
	
	private Integer chargeid;

	private BigDecimal chargeAmount=new BigDecimal(40.00);

	private String description;

	private boolean discounted;

	private int discountPercent;
	


}
