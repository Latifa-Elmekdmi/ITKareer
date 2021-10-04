package com.platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.platform.registration.RegistrationRequest;
import com.platform.registration.RegistrationService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {
	

    private final RegistrationService registrationService;

    @PostMapping(path = "/SaveRegistration")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);}
   
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	 
	@GetMapping("/registration")
	public String registration() {
		return "register";
	}
}
