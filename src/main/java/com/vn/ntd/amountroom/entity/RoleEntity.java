package com.vn.ntd.amountroom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {

	@Id
	private String roleCode;
	
	private String roleName;
}
