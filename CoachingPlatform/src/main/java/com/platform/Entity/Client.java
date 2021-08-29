package com.platform.Entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
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

	public Client(String firstName, String lastName, String phoneNumber, String photo, Account account,
			Collection<Engagement> engagements, Collection<Command> orders) {
		super(firstName, lastName, phoneNumber, photo, account);
		this.engagements = engagements;
		this.orders = orders;
	}

	public Client(String firstName, String lastName, String phoneNumber, String photo, Account account) {
		super(firstName, lastName, phoneNumber, photo, account);
	} 
	
	
	

	
	
	
}
