package com.platform.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.platform.Entity.Client;
import com.platform.Entity.Coach;
import com.platform.Entity.Engagement;
import com.platform.dao.ClientRepository;
import com.platform.dao.CoachRepository;
import com.platform.dao.EngagementRepository;

@Controller
public class EngagementController {

	@Autowired
	private EngagementRepository engagementRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CoachRepository coachRepository;
	
	@GetMapping(path = "/engagements")
	public String listEngagements(Model model,@RequestParam(name = "page",defaultValue = "0") int page) {
//		Page<Engagement> listEngagements = engagementRepository.findAll(PageRequest.of(page, 5));
//		List<Client> listClient = clientRepository.findAll();
//		List<Coach> listCoach = coachRepository.findAll();
//		model.addAttribute("listClient", listClient);
//		model.addAttribute("listCoach", listCoach);
//		model.addAttribute("engagements", listEngagements);
		
		return "engagements";
		
	}
}
