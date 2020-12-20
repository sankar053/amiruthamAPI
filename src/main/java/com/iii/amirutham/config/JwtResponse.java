package com.iii.amirutham.config;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	private String accessToken;
	private String type = "Bearer";
	private Integer customerId;
	private String username;
	private String email;
	private Integer myCartItemCount;
	private String ispendingCartAvailable;
	private List<String> roles;

	public JwtResponse(String accessToken, Integer id, String username, String email, List<String> roles,Integer myCartItemCount,String ispendingCartAvailable) {
		this.accessToken = accessToken;
		this.customerId = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.myCartItemCount = myCartItemCount;
		this.ispendingCartAvailable = ispendingCartAvailable;
	}

	
}
