/**
 * 
 */
package com.iii.amirutham.common.report.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class OrderItemsReportData {
	
private String productName;
	
private Integer productQuantity;
	

private BigDecimal productPricewithoutGst;

private BigDecimal productPricewithGst;

private BigDecimal productGstAmount;

}
