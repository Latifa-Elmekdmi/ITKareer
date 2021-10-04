package com.platform.Entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
public class Client extends User implements Serializable{
	
	@OneToMany(mappedBy = "client")
	private Collection<Engagement> engagements;
	
	@OneToMany(mappedBy = "client")
	private Collection<Command> orders;
	
	@OneToMany(mappedBy = "owner")
	private Collection<Invoice> invoices; 
	public Collection<Engagement> getEngagements() {
		return engagements;
	}

	public void setEngagements(Collection<Engagement> engagements) {
		this.engagements = engagements;
	}

	public Collection<Command> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Command> orders) {
		this.orders = orders;
	}

	public Client(String firstName, String lastName, String phoneNumber, String photo,
			Collection<Engagement> engagements, Collection<Command> orders) {
		super(firstName, lastName, phoneNumber, photo);
		this.engagements = engagements;
		this.orders = orders;
	}

	public Client(String firstName, String lastName, String phoneNumber, String photo) {
		super(firstName, lastName, phoneNumber, photo);
	}

	public Client(String firstName, String lastName, String phoneNumber) {
		super(firstName, lastName, phoneNumber);
	}

	

	public Client(String firstName, String lastName, String phoneNumber, Collection<Engagement> engagements) {
		super(firstName, lastName, phoneNumber);
		this.engagements = engagements;
	}

	 
	
	
	

	
	
	
}
