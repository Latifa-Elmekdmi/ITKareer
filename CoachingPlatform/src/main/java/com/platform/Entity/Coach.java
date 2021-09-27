package com.platform.Entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Coach extends User implements Serializable{
	private String profileSummary; 
	private String education;
	private String experience;
	
	@OneToMany(mappedBy = "coach")
	private Collection<Engagement> engagements;
	
	@OneToMany(mappedBy = "coach")
	private Collection<Pack> packs;
	
	@OneToMany(mappedBy = "coach")
	private Collection<Resource> resources;
	
	@OneToMany(mappedBy = "coach")
	private Collection<Report> reportes;
	
	public Coach() {
		super();
	}

	public String getProfileSummary() {
		return profileSummary;
	}

	public void setProfileSummary(String profileSummary) {
		this.profileSummary = profileSummary;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Collection<Engagement> getEngagements() {
		return engagements;
	}

	public void setEngagements(Collection<Engagement> engagements) {
		this.engagements = engagements;
	}

	public Collection<Pack> getPackages() {
		return packs;
	}

	public void setPackages(Collection<Pack> packs) {
		this.packs = packs;
	}

	public Collection<Resource> getResources() {
		return resources;
	}

	public void setResources(Collection<Resource> resources) {
		this.resources = resources;
	}

	public Collection<Report> getReportes() {
		return reportes;
	}

	public void setReportes(Collection<Report> reportes) {
		this.reportes = reportes;
	}

	public Coach(String firstName, String lastName, String phoneNumber, String photo, Account account,
			String profileSummary, String education, String experience, Collection<Engagement> engagements,
			Collection<Pack> packs, Collection<Resource> resources, Collection<Report> reportes) {
		super(firstName, lastName, phoneNumber, photo, account);
		this.profileSummary = profileSummary;
		this.education = education;
		this.experience = experience;
		this.engagements = engagements;
		this.packs = packs;
		this.resources = resources;
		this.reportes = reportes;
	}

	public Coach(String firstName, String lastName, String phoneNumber, String profileSummary, String education) {
		super(firstName, lastName, phoneNumber);
		this.profileSummary = profileSummary;
		this.education = education;
	}

	@Override
	public String toString() {
		return "Coach [profileSummary=" + profileSummary + ", education=" + education + "]";
	}

	public Coach(String firstName, String lastName, String phoneNumber, String profileSummary, String education,
			String experience, Collection<Engagement> engagements, Collection<Pack> packs) {
		super(firstName, lastName, phoneNumber);
		this.profileSummary = profileSummary;
		this.education = education;
		this.experience = experience;
		this.engagements = engagements;
		this.packs = packs;
	}
	
	
	

}
