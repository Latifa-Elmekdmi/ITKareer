package com.platform.Entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
@Entity 
public class Program implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long programId; 
	@Column(length = 25)
	private String programName; 
	private String programDescription;
	
	@OneToMany(mappedBy = "program")
	private Collection<Pack> packs;
	public Program() {
		super();
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public Collection<Pack> getPackages() {
		return packs;
	}
	public void setPackages(Collection<Pack> packs) {
		this.packs = packs;
	}
	public Program(String programName, String programDescription, Collection<Pack> packs) {
		super();
		this.programName = programName;
		this.programDescription = programDescription;
		this.packs = packs;
	}
	
	
	
	
	

}
