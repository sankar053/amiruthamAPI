package com.iii.amirutham.config;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iii.amirutham.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String firstName;
	
	private String lastName;

	private String email;
	
	@JsonIgnore
	private String username;
	
	private String phoneNumber;
	
	private String isPendingCartAvailable;
	
	private Integer cartItemCount;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Integer id, String firstName,String lastName, String email, String phoneNbr, String password,
		Integer availitemCount,String ispendingCart,Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username=email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber=phoneNbr;
		this.password = password;
		this.cartItemCount = availitemCount;
		this.isPendingCartAvailable = ispendingCart;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user,Integer availitemCount,String ispendingCart) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getFirstName(), 
				user.getLastName(),
				user.getEmailAddress(),
				user.getPhoneNbr(), 
				user.getPassword(), 
				availitemCount,
				ispendingCart,
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}


	
}
