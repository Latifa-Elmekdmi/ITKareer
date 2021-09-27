package com.platform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.platform.Entity.Engagement;
import com.platform.dao.EngagementRepository;

@Controller
public class EngagementController {

	@Autowired
	private EngagementRepository engagementRepository;
	
	@GetMapping(path = "/engagements")
	public String listEngagements(Model model,@RequestParam(name = "page",defaultValue = "0") int page) {
		Page<Engagement> listEngagements = engagementRepository.findAll(PageRequest.of(page, 5));
		model.addAttribute("engagements", listEngagements);
		
		return "engagements";
	}
}
