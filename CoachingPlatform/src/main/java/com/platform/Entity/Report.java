package com.platform.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
public class Report implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId ; 
	@Column(length = 25)
	private String reportName; 
	@Column(length = 25)
	private String reportType;
	
	@ManyToOne @JoinColumn(name = "Coach_Id")
	private Coach coach;
	
	public Report() {
		super();
	}
	public Report(String reportName, String reportType) {
		super();
		this.reportName = reportName;
		this.reportType = reportType;
	}
	public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	} 
	
	
}
