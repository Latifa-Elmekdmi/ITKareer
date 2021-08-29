package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
	public Page<Report> findByReportNameContains(String nameReport, Pageable pageable);

}
