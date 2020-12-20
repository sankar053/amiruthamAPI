package com.iii.amirutham.model.user;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*INSERT INTO ROLE (id, role_Desc, role) VALUES (4, 'Admin role', 'ROLE_ADMIN');
INSERT INTO ROLE (id, role_Desc, role) VALUES (5, 'User role', 'ROLE_USER');*/

@Entity(name = "role")
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20,name="role")
	private ERole name;

	@Column(length = 20,name="roleDesc")
    private String description;
}