package com.platform.Entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId; 
	@Column(length = 25)
	private String roleName;
	
	@OneToMany(mappedBy = "role")
	private Collection<Account> accounts;
	
	public Role() {
		super();
	}
	
	public Role(String roleName, Collection<Account> accounts) {
		super();
		this.roleName = roleName;
		this.accounts = accounts;
	}

	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Collection<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	} 
	
}
