package com.iii.amirutham.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*INSERT INTO AMIR_USER_ROLE (id, AMIR_USER_RLE_DSC, AMIR_USER_RLE) VALUES (4, 'Admin role', 'ROLE_ADMIN');
INSERT INTO AMIR_USER_ROLE (id, AMIR_USER_RLE_DSC, AMIR_USER_RLE) VALUES (5, 'User role', 'ROLE_USER');*/

@Entity(name = "role")
@Table(name = "AMIR_USER_ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20,name="AMIR_USER_RLE")
	private ERole name;

	@Column(length = 20,name="AMIR_USER_RLE_DSC")
    private String description;
}