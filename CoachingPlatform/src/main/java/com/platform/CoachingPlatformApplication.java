package com.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.platform.Entity.Client;
import com.platform.Entity.Coach;
import com.platform.Entity.Engagement;
import com.platform.Entity.Pack;
import com.platform.Entity.Program;
import com.platform.dao.ClientRepository;
import com.platform.dao.CoachRepository;
import com.platform.dao.EngagementRepository;
import com.platform.dao.PackRepository;
import com.platform.dao.ProgramRepository;
import com.platform.dao.UserRepository;

@SpringBootApplication
public class CoachingPlatformApplication  implements CommandLineRunner{
	@Autowired
	private ClientRepository clientRepository ; 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CoachRepository coachRepository;
	@Autowired
	private ProgramRepository programRepository;
	@Autowired
	private PackRepository packRepository;
	@Autowired
	private EngagementRepository engagementRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CoachingPlatformApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// clientRepository.save(Client());
		
		//userRepository.save(new User())
		coachRepository.save(new Coach("elmekdmi", "latifa", "0762701129", "I am a professional lifestyle coach ", "Harvard university"));
		coachRepository.findAll().forEach(c -> {
			System.out.println(c.toString());
		});
		System.out.println("*******************************************************************");
		 Program pr = new Program("Personality Reading", "Get a private reading using Human Design, the Enneagram, and Meyer's Briggs to understand how you're uniquely designed to help you build the right business for you and help you make decisions.");
		 Program pr1 = new Program("Executive Coaching", "If something is holding you back from your performance potential or what you aspire to accomplish, we should talk.");
		 Program pr2 = new Program("Rise Up", " an individual leadership program tested & approved by many women leaders, focusing on: \n" + 
		 		"🔹Growing your self awareness \n" + 
		 		"🔹Building your leadership presence and greater emotional intelligence \n" + 
		 		"🔹Clarifying your career vision, mission and goals \n" + 
		 		"🔹Enhancing networking and communication skills");
		 Program pr3 = new Program("Career focus", "This is an individual program that will help you get that job or promotion you want.");
		 programRepository.save(pr);
		 programRepository.save(pr1);
		 programRepository.save(pr2);
		 programRepository.save(pr3);
		 
		 //**********************************************************************************************************
		 Pack pack = new Pack("6 months leadership program tailored for women", pr2.getProgramDescription(), 24, 48, 2800.00, pr2);
		 Pack pack1 = new Pack("RiseUp - Career focus", pr3.getProgramDescription(), 14, 28, 1500.00, pr3);
		 Pack pack2 = new Pack("Executive Coaching", pr1.getProgramDescription(), 10, 30, 2000.00, pr1);
		 Pack pack3 = new Pack("Personality ", pr.getProgramDescription(), 5, 10, 1200.00, pr);
		 
		 packRepository.save(pack);
		 packRepository.save(pack1);
		 packRepository.save(pack2);
		 packRepository.save(pack3);
		 //**********************************************************************************************************
				 
		Coach coach = new Coach("Joi", "Whithmore", "0762701124", "I have made my career as an IT Professional in the Web Design and Development field. For the past decade it has been my goal and passion to work with digital technology in an intuitive and supportive manner.","digital technology, organic SEO training,powerful brand development and creative content marketing ");
		Coach coach1 = new Coach("Json", "Meredith", "0674719950", "Andy’s coaching practice began during his time in the London Fire Brigade in the early 2000s.  The provided Andy with early experience in coaching at a senior level and across culturally diverse teams.", "COMMUNICATION,INFLUENCE and LEADERSHIP DEVELOPMENT");
		Coach coach2 = new Coach("Chris", "Hagood", "0625874160", "Over the last decade, Terry Lipovski has established himself as one of the top Executive Coaches in North America. With a background in Psychology, Corporate Leadership and Coaching.", "COACHING AND MENTORING,\n" + 
				"EXECUTIVE PRESENCE and INTERPERSONAL SKILLS");
		Coach coach3 = new Coach("Andy", "Johnson","0676676620", "As a Transformational Coach, I help Business Owners & Multipassionates come back to who they truly are, radically align with their dreams & desires, and transform their Life + Mindset + Business so they can confidently be who they are, create more money & opportunities, and live life on their own terms!", "BUSINESS, MINDSET AND LIFE TRANSFORMATION");
		
		coachRepository.save(coach);
		coachRepository.save(coach1);
		coachRepository.save(coach2);
		coachRepository.save(coach3);
		//**********************************************************************************************************
		
				Engagement eng =new Engagement("Engagement NO 1", new Date(), pack, "IN PROGRESS");
				Engagement eng1 =new Engagement("Engagement NO 2", new Date(), pack1, "IN PROGRESS");
				Engagement eng2 =new Engagement("Engagement NO 3", new Date(), pack2, "IN PROGRESS");
				Engagement eng3 =new Engagement("Engagement NO 4", new Date(), pack3, "IN PROGRESS");
				
				engagementRepository.save(eng);
				engagementRepository.save(eng1);
				engagementRepository.save(eng2);
				engagementRepository.save(eng3);
		 //**********************************************************************************************************
				ArrayList<Engagement> listOfCl = new ArrayList<Engagement>();
				ArrayList<Engagement> listOfCl1 = new ArrayList<Engagement>();
				ArrayList<Engagement> listOfCl2 = new ArrayList<Engagement>();
				ArrayList<Engagement> listOfCl3 = new ArrayList<Engagement>();
				listOfCl1.add(eng);
				listOfCl1.add(eng3);
				listOfCl.add(eng);
				listOfCl2.add(eng1);
				listOfCl2.add(eng3);
				listOfCl3.add(eng2);
		Client client = new Client("Latifa", "elmekdmi", "0762701129", listOfCl);
		Client client1 = new Client("Hajar", "jmouhi", "0674719960", listOfCl1);
		Client client2 = new Client("Ali", "alaoui", "0677485962", listOfCl2);
		Client client3 = new Client("Mohamed", "Nour", "074719960", listOfCl3);
		
		clientRepository.save(client);
		clientRepository.save(client1);
		clientRepository.save(client2);
		clientRepository.save(client3);
		
		 
		
	}

}
