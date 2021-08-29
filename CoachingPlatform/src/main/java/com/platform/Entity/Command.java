package com.platform.Entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
public class Command implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CommandId; 
	@Column(length = 25)
	private String CommandStatus;
	private double totalPrice;
	
	@ManyToOne @JoinColumn(name = "Client_Id")
	private Client client;
	
	@OneToMany(mappedBy = "Command")
	private Collection<Payment> payments;
	
	@ManyToOne @JoinColumn(name ="Package_Id")
	private Pack pack;
	
	@ManyToOne @JoinColumn(name = "Invoice_Id")
	private Invoice invoice;

	public Long getCommandId() {
		return CommandId;
	}

	public void setCommandId(Long commandId) {
		CommandId = commandId;
	}

	public String getCommandStatus() {
		return CommandStatus;
	}

	public void setCommandStatus(String commandStatus) {
		CommandStatus = commandStatus;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Collection<Payment> payments) {
		this.payments = payments;
	}

	public Pack getPackage() {
		return pack;
	}

	public void setPackage(Pack package1) {
		pack = package1;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Command(String commandStatus, double totalPrice, Client client, Collection<Payment> payments,
			com.platform.Entity.Pack package1, Invoice invoice) {
		super();
		CommandStatus = commandStatus;
		this.totalPrice = totalPrice;
		this.client = client;
		this.payments = payments;
		this.pack = package1;
		this.invoice = invoice;
	}

	
	
}
