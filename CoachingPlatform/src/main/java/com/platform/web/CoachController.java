package com.platform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.platform.dao.CoachRepository;

@Controller
public class CoachController {
	@Autowired
private CoachRepository coachRepository;
 

}
