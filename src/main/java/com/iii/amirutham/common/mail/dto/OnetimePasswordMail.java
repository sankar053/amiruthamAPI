package com.iii.amirutham.common.mail.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OnetimePasswordMail {
	
	
	
	private String otp;
	
	private String name;
	
	private String email;
	
	private String time;

	public OnetimePasswordMail(String otp, String name,String email) {
		super();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		this.otp = otp;
		this.name = name;
		this.time = simpleDateFormat.format(new Date())+" IST";
		this.email =email;
	};
	
	
	

}
