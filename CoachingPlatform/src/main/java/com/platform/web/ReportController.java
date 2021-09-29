package com.platform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.platform.Entity.Engagement;
import com.platform.Entity.Report;
import com.platform.Entity.Resource;
import com.platform.dao.ReportRepository;
import com.platform.dao.ResourceRepository;

@Controller
public class ReportController {

	@Autowired
	private ReportRepository  reportRepository;
	 
	@GetMapping(path = "/reports")
	public String reports(Model model,@RequestParam(name = "page",defaultValue = "0") int page) {
		Page<Report> listEngagements = reportRepository.findAll(PageRequest.of(page, 5));
		return "reports";
	}
}
