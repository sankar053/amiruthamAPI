/**
 * 
 */
package com.iii.amirutham.dto.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.iii.amirutham.validation.ValidEmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerNewsLetterDto {

	private String firstName;

	private String lastName;

	private String phoneNbr;

	@ValidEmail
	@NotEmpty(message = "{NotEmpty.user.email}")
	@NotNull(message = "{NotNull.user.email}")
	@Size(min = 1, message = "{Size.userDto.email}")
	private String emailAddress;


	

}
