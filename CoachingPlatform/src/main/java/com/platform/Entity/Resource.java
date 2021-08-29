package com.platform.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Resource implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resourceId; 
	@Column(length = 25)
	private String resourceName; 
	@Column(length = 25)
	private String resourceType;
	@Column(length = 25)
	private String resourceOwnership;
	
	@ManyToOne @JoinColumn(name = "Coach_Id")
	private Coach coach;
	public Resource() {
		super();
	}
	public Resource(String resourceName, String resourceType, String resourceOwnership) {
		super();
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.resourceOwnership = resourceOwnership;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getResourceOwnership() {
		return resourceOwnership;
	}
	public void setResourceOwnership(String resourceOwnership) {
		this.resourceOwnership = resourceOwnership;
	} 
	

}
