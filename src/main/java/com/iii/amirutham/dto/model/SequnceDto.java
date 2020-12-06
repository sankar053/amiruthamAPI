package com.iii.amirutham.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SequnceDto{
	

	private Integer id;
	
	private String seqName;
	
	private String seqChar;

	private Integer seqCurVal;

	private Integer seqNxtVal;

	private Integer seqLimVal;

}
