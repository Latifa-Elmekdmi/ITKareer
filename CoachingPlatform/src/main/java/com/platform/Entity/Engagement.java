package com.platform.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
public class Engagement implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long engagementId;
	private String engagemetnTitle; 
	private Date schedule; 
	private Pack Pack;
	private String engagementStatus;
	
	@ManyToOne @JoinColumn(name = "Client_Id")
	private Client client; 
	
	@ManyToOne @JoinColumn(name = "Coach_Id")
	private Coach coach; 
	

	public Engagement(String engagemetnTitle, Date schedule, com.platform.Entity.Pack package1,
			String engagementStatus) {
		super();
		this.engagemetnTitle = engagemetnTitle;
		this.schedule = schedule;
		Pack = package1;
		this.engagementStatus = engagementStatus;
	}
	public Long getEngagementId() {
		return engagementId;
	}
	public void setEngagementId(Long engagementId) {
		this.engagementId = engagementId;
	}
	public String getEngagemetnTitle() {
		return engagemetnTitle;
	}
	public void setEngagemetnTitle(String engagemetnTitle) {
		this.engagemetnTitle = engagemetnTitle;
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
	
	public Engagement() {
		super();
	}
	
	public Engagement(Long engagementId, String engagemetnTitle, Date schedule, com.platform.Entity.Pack pack,
			String engagementStatus, Client client, Coach coach) {
		super();
		this.engagementId = engagementId;
		this.engagemetnTitle = engagemetnTitle;
		this.schedule = schedule;
		Pack = pack;
		this.engagementStatus = engagementStatus;
		this.client = client;
		this.coach = coach;
	}
	public Engagement(String engagemetnTitle, Date schedule, com.platform.Entity.Pack pack, String engagementStatus,
			Client client, Coach coach) {
		super();
		this.engagemetnTitle = engagemetnTitle;
		this.schedule = schedule;
		Pack = pack;
		this.engagementStatus = engagementStatus;
		this.client = client;
		this.coach = coach;
	}

	
}
