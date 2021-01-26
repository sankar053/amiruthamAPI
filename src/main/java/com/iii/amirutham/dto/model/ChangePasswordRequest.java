/**
 * 
 */
package com.iii.amirutham.dto.model;

import javax.validation.constraints.NotBlank;

import com.iii.amirutham.validation.ValidPassword;

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
public class ChangePasswordRequest {

	@ValidPassword
	@NotBlank(message = "{NotEmpty.user.password}")
	private String password;

	@ValidPassword
	@NotBlank(message = "{NotNull.user.password}")
	private String oldPassword;

}
