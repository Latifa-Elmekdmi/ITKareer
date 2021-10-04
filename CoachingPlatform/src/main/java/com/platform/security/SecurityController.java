package com.platform.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	
	@GetMapping(path = "/login")
	public String loginClient() {
		return "login";
	}
	@GetMapping(path = "/403")
	public String accesDenied() {
		return "403";
	}
}
