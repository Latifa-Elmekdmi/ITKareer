package com.platform.Entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements Serializable {
			
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long userId ;
@Column(length = 25)
private String firstName;
@Column(length = 25)
private String lastName;
@Column(length = 14)
private String phoneNumber;

@OneToOne
@JoinColumn(name = "Account_Id")
private Account account;

@Lob
private String photo;


public User(String firstName, String lastName, String phoneNumber) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNumber = phoneNumber;
}
public User(String firstName, String lastName, String phoneNumber, String photo,Account account) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNumber = phoneNumber;
	this.photo = photo;
	this.account = account; 
}
public User() {
	super();
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}


}
