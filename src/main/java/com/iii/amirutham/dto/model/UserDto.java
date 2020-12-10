package com.iii.amirutham.dto.model;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.iii.amirutham.validation.ValidEmail;
import com.iii.amirutham.validation.ValidPassword;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto  {

	@NotEmpty(message = "{NotEmpty.user.lastName}")
	@NotNull(message = "{NotNull.user.firstName}")
    @Size(min = 1, message = "{Size.userDto.firstName}")
	private String firstName;

	@NotEmpty(message = "{NotEmpty.user.lastName}")
	@NotNull(message = "{NotNull.user.lastName}")
    @Size(min = 1, message = "{Size.userDto.lastName}")
	private String lastName;

	@Size(min = 10, message = "{Size.userDto.phoneNumber}")
	@NotEmpty(message = "{NotEmpty.user.phoneNbr}")
	@NotNull(message = "{NotNull.user.phoneNbr}")
	private String phoneNbr;

	@ValidEmail
	@NotEmpty(message = "{NotEmpty.user.email}")
	@NotNull(message = "{NotNull.user.email}")
    @Size(min = 1, message = "{Size.userDto.email}")
	private String emailAddress;

	@ValidPassword
	@NotEmpty(message = "{NotEmpty.user.password}")
	@NotNull(message = "{NotNull.user.password}")
	private String password;

	private List<UserAddressDto> address;
	
	@NotEmpty(message = "{NotEmpty.user.role}")
	@NotNull(message = "{NotNull.user.role}")
	private Set<String> role;


}
