/**
 * 
 */
package com.iii.amirutham.dto.model;

import javax.validation.constraints.NotBlank;

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
	@NotBlank(message = "{NotEmpty.user.email}")
	private String email;


	

}
