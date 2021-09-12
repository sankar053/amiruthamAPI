package com.iii.amirutham.dto.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.iii.amirutham.validation.ValidPassword;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidateOtpDto {
	
	@NotEmpty(message = "{NotEmpty.user.otp}")
	@NotNull(message = "{NotEmpty.user.otp}")
	private String oneTimePassword;
	
	
	private String userName;
	
	@ValidPassword
	@NotEmpty(message = "{message.username}")
	@NotNull(message = "{message.username}")
	private String changePassword;
}
