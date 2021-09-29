package com.platform.Entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
@Entity 
public class Pack implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long packageId; 
	@Column(length = 50)
	private String packageName; 
	private String packageDetails; 
	private int sessions; 
	private int hours; 
	private double packagePrice; 
	
	@ManyToOne @JoinColumn(name = "program_Id")
	private Program program;
	
	@OneToMany(mappedBy = "pack")
	private Collection<Command> Commands; 
	
	@ManyToOne @JoinColumn(name = "Coach_Id")
	private Coach coach;

	
	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDetails() {
		return packageDetails;
	}

	public void setPackageDetails(String packageDetails) {
		this.packageDetails = packageDetails;
	}

	public int getSessions() {
		return sessions;
	}

	public void setSessions(int sessions) {
		this.sessions = sessions;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Collection<Command> getCommands() {
		return Commands;
	}

	public void setCommands(Collection<Command> Commands) {
		this.Commands = Commands;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Pack(String packageName, String packageDetails, int sessions, int hours, double packagePrice,
			Program program, Collection<Command> Commands, Coach coach) {
		super();
		this.packageName = packageName;
		this.packageDetails = packageDetails;
		this.sessions = sessions;
		this.hours = hours;
		this.packagePrice = packagePrice;
		this.program = program;
		this.Commands = Commands;
		this.coach = coach;
	}

	public Pack() {
		super();
	}

	public Pack(String packageName, String packageDetails, int sessions, int hours, double packagePrice,
			Program program) {
		super();
		this.packageName = packageName;
		this.packageDetails = packageDetails;
		this.sessions = sessions;
		this.hours = hours;
		this.packagePrice = packagePrice;
		this.program = program;
	}

	public Pack(String packageName, String packageDetails, int sessions, int hours, double packagePrice,
			Program program, Coach coach) {
		super();
		this.packageName = packageName;
		this.packageDetails = packageDetails;
		this.sessions = sessions;
		this.hours = hours;
		this.packagePrice = packagePrice;
		this.program = program;
		this.coach = coach;
	} 
	
	
	
	
	
	
}
	