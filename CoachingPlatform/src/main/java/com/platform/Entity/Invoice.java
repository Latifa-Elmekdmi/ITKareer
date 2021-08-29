package com.platform.Entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
public class Invoice implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceId; 
	private Date invoiceDate;
	private Double totalPrice;
	@ManyToOne
	private Client owner;
	
	@OneToMany(mappedBy ="invoice")
	private Collection<Command> Commands;
	
	public Invoice() {
		super();
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Collection<Command> getCommands() {
		return Commands;
	}

	public void setCommands(Collection<Command> Commands) {
		this.Commands = Commands;
	}

	public Invoice(Date invoiceDate, Double totalPrice, Collection<Command> Commands) {
		super();
		this.invoiceDate = invoiceDate;
		
		this.totalPrice = totalPrice;
		this.Commands = Commands;
	}
	
	
}
