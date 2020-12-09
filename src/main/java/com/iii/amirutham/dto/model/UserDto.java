package com.iii.amirutham.dto.model;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.iii.amirutham.validation.ValidEmail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "All Details about User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto  {

	@NotNull
    @Size(min = 1, message = "{Size.userDto.firstName}")
	private String firstName;

	@NotNull
    @Size(min = 1, message = "{Size.userDto.lastName}")
	private String lastName;

	@Size(min = 10, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String phoneNbr;

	@ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
	private String emailAddress;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String password;

	private List<UserAddressDto> address;
	
	private Set<String> role;


}
