package com.platform.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
public class Engagement implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long engagementId;
	private String engagementTitle; 
	private Date schedule; 
	
	private String engagementStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Client_Id")
	private Client client; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Coach_Id")
	private Coach coach; 
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Pack_Id")
	private Pack Pack;
	
	public Long getEngagementId() {
		return engagementId;
	}
	public void setEngagementId(Long engagementId) {
		this.engagementId = engagementId;
	}
	
	public String getEngagementTitle() {
		return engagementTitle;
	}
	public void setEngagementTitle(String engagementTitle) {
		this.engagementTitle = engagementTitle;
	}
	public Date getSchedule() {
		return schedule;
	}
	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}
	public Pack getPackage() {
		return Pack;
	}
	public void setPackage(Pack package1) {
		Pack = package1;
	}
	public String getEngagementStatus() {
		return engagementStatus;
	}
	public void setEngagementStatus(String engagementStatus) {
		this.engagementStatus = engagementStatus;
	} 
	
	


	public Engagement(String engagementTitle, Date schedule, String engagementStatus, Client client, Coach coach,
			com.platform.Entity.Pack pack) {
		super();
		this.engagementTitle = engagementTitle;
		this.schedule = schedule;
		this.engagementStatus = engagementStatus;
		this.client = client;
		this.coach = coach;
		Pack = pack;
	}
	public Engagement(String engagementTitle, Date schedule, String engagementStatus, Client client, Coach coach) {
		super();
		this.engagementTitle = engagementTitle;
		this.schedule = schedule;
		this.engagementStatus = engagementStatus;
		this.client = client;
		this.coach = coach;
	}
	public Engagement() {
		super();
	}



	
}
