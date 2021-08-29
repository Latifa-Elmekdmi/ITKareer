package com.platform.Entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	@Column(length = 100)
	private String email;
	@Column(length = 100)
	private String password;
	private boolean active;
	
	@OneToOne@JoinColumn(name = "User_Id")
	private User user;
	
	@ManyToOne
	private Role role; 
	
	@OneToMany
	private Collection<Notification> notifications;
	
	
	public Account() {
		super();
	}
	public Account(Long accountId, String email, String password, boolean active, Role role,
			Collection<Notification> notifications) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.password = password;
		this.active = active;
		this.role = role;
		this.notifications = notifications;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Collection<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Collection<Notification> notifications) {
		this.notifications = notifications;
	}
	
}
