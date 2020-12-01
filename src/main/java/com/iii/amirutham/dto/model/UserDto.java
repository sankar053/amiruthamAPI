package com.iii.amirutham.dto.model;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Size;

import com.iii.amirutham.model.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "All Details about User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto  {

	@Size(min = 2, message = "FirstName Should have Atleast two character")
	@ApiModelProperty(notes = "FirstName Should have Atleast two character")
	private String firstName;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String lastName;

	@Size(min = 10, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String phoneNbr;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String emailAddress;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String password;

	private List<UserAddressDto> address;
	
	private Set<String> role;


}
