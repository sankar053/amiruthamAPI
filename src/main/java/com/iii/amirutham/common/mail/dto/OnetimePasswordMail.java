package com.iii.amirutham.common.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OnetimePasswordMail {
	
	private String otp;
	
	private String name;

}
