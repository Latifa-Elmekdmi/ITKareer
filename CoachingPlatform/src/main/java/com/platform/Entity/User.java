package com.platform.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
public  class User implements Serializable, UserDetails {
			
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long userId ;
@Column(length = 25)
private String firstName;
@Column(length = 25)
private String lastName;
@Column(length = 14)
private String phoneNumber;
private String email;
private String password;

private UserRole userRole;

@Lob
private String photo;
private Boolean locked = false;
private Boolean enabled = false;



public User(String firstName, String lastName, String phoneNumber, String email, String password) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.password = password;
}

public User(String firstName, String lastName, String phoneNumber) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNumber = phoneNumber;
}
public User(String firstName, String lastName, String phoneNumber, String photo) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNumber = phoneNumber;
	this.photo = photo;

}


@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	 SimpleGrantedAuthority authority =
             new SimpleGrantedAuthority(userRole.name());
     return Collections.singletonList(authority);
}
@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return email;
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return !locked;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return enabled;
}

@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return password;
}

public User(String firstName, String lastName, String email, String password, UserRole role) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.userRole = role;
}


}
