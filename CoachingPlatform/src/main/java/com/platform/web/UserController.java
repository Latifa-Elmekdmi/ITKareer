package com.platform.web;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.platform.registration.RegistrationRequest;
import com.platform.registration.RegistrationService;
import com.platform.service.UserService;
import com.platform.token.ConfirmationToken;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {
	private final UserService UserService;
    private final com.platform.token.ConfirmationTokenService confirmationTokenService  ;
    private final RegistrationService registrationService;

    @PostMapping(path = "/SaveRegistration")
    public String register( RegistrationRequest request) {
         registrationService.register(request);
         return "saved" ; 
    }

//    @PostMapping(path = "/Save")
//    public String register( RegistrationRequest request) {
//         registrationService.register(request);
//         return "saved" ; 
//    }

   
    public String confirm( String token,Model model) {
        model.addAttribute("token", token);
        
    	return "confirmed";
        
    }
    
    @PostMapping(path = "/registration/confirm/**")
    public String confirmToken(@RequestParam("token") String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
             
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        UserService.enableAppUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }
   
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	 
	@GetMapping("/registration")
	public String registration() {
		return "register";
	}
	
	
	@GetMapping("/login/google")
    public Principal registerUsingGoogle( Principal principal) {
         System.out.println(principal.getName());
         return principal ; 
    }
}
