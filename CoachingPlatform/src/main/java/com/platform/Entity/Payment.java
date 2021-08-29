package com.platform.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Payment implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	private Long cardNumber; 
	private String country; 
	@Temporal(TemporalType.DATE)
	private Date expirationDate; 
	private Client cardOwner;
	private Double totalPice;
		
	@ManyToOne @JoinColumn(name = "Command_Id")
	private Command Command;

	
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Client getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(Client cardOwner) {
		this.cardOwner = cardOwner;
	}

	public Double getTotalPice() {
		return totalPice;
	}

	public void setTotalPice(Double totalPice) {
		this.totalPice = totalPice;
	}

	public Command getOrder() {
		return Command;
	}

	public void setOrder(Command Command) {
		this.Command = Command;
	}

	public Payment(Long cardNumber, String country, Date expirationDate, Client cardOwner, Double totalPice,
			Command Command) {
		super();
		this.cardNumber = cardNumber;
		this.country = country;
		this.expirationDate = expirationDate;
		this.cardOwner = cardOwner;
		this.totalPice = totalPice;
		this.Command = Command;
	}

	public Payment() {
		super();
	}
	
	
}
