package com.platform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.platform.Entity.Client;
import com.platform.Entity.Engagement;
import com.platform.Entity.Resource;
import com.platform.dao.ClientRepository;
import com.platform.dao.ResourceRepository;

@Controller
public class ClientController {

	@Autowired
	private ClientRepository  clientRepository;
	 
	@GetMapping(path = "/clients")
	public String clients(Model model,@RequestParam(name = "page",defaultValue = "0") int page) {
		Page<Client> clients = clientRepository.findAll(PageRequest.of(page, 5));
		return "clients";
	}
	
}
