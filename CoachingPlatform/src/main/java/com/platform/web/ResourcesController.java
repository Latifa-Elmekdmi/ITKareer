package com.platform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.platform.Entity.Resource;
import com.platform.dao.ResourceRepository;

@Controller
public class ResourcesController {

	@Autowired
	private ResourceRepository  resourceRepository;
	 
	@GetMapping(path = "/resources")
	public String resources(Model model,@RequestParam(name = "page",defaultValue = "0") int page) {
		Page<Resource> listEngagements = resourceRepository.findAll(PageRequest.of(page, 5));
		return "resources";
	}
}
