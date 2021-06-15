package com.treykapfer.ninjagold;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDateTime;    
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	
	private boolean sessionOnline = false;
	
	@RequestMapping("/")
	public String home(HttpSession session) {
		if (sessionOnline == false) {
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("gold", 0);
			session.setAttribute("activities", activities);
			sessionOnline = true;
		}
		return "index.jsp";
	}
	
	@RequestMapping(value="/process_gold", method=RequestMethod.POST)
	public String submit(@RequestParam(name="option") String option, HttpSession session) {
		System.out.println(option);
		
		if (option.equals("farm")) {
			Random rand = new Random();
			
			//set new gold
			int tendies = rand.nextInt(10) + 10;
			int tempGold = (int) session.getAttribute("gold") + tendies;
			session.setAttribute("gold", tempGold);
			
			//append activities
			ArrayList<String> tempActivities = new ArrayList<String>();
			tempActivities = (ArrayList<String>) session.getAttribute("activities");
			tempActivities.add("Earned " + tendies + " gold from the farm!  " + LocalDateTime.now());
			session.setAttribute("activities", tempActivities);
			System.out.println(session.getAttribute("activities"));
		}
		
		else if (option.equals("cave")) {
			Random rand = new Random();
			
			//set new gold
			int tendies = rand.nextInt(5) + 5;
			int tempGold = (int) session.getAttribute("gold") + tendies;
			session.setAttribute("gold", tempGold);
			
			//append activities
			ArrayList<String> tempActivities = new ArrayList<String>();
			tempActivities = (ArrayList<String>) session.getAttribute("activities");
			tempActivities.add("Earned " + tendies + " gold from the cave!  " + LocalDateTime.now());
			session.setAttribute("activities", tempActivities);
			System.out.println(session.getAttribute("activities"));
		}
		
		else if (option.equals("house")) {
			Random rand = new Random();
			
			//set new gold
			int tendies = rand.nextInt(4) + 1;
			int tempGold = (int) session.getAttribute("gold") + tendies;
			session.setAttribute("gold", tempGold);
			
			//append activities
			ArrayList<String> tempActivities = new ArrayList<String>();
			tempActivities = (ArrayList<String>) session.getAttribute("activities");
			tempActivities.add("Earned " + tendies + " gold from the house!  " + LocalDateTime.now());
			session.setAttribute("activities", tempActivities);
			System.out.println(session.getAttribute("activities"));
		}
		
		else {
			Random rand = new Random();
			
			//set new gold
			int tendies = 0;
			boolean neg = false;
			double coinflip = rand.nextFloat();
			if (coinflip > 0.50) {
				tendies = rand.nextInt(50);
			} else {
				tendies = rand.nextInt(50)*-1;
				neg = true;
			}
			int tempGold = (int) session.getAttribute("gold") + tendies;
			session.setAttribute("gold", tempGold);
			
			//append activities
			ArrayList<String> tempActivities = new ArrayList<String>();
			tempActivities = (ArrayList<String>) session.getAttribute("activities");
			//check for negative value
			if (neg) {
				tempActivities.add("You entered the casino and gambled away " + tendies + " gold!  " + LocalDateTime.now());
			} else {
				tempActivities.add("You entered the casino and won " + tendies + " gold!  " + LocalDateTime.now());
			}
			session.setAttribute("activities", tempActivities);
			System.out.println(session.getAttribute("activities"));
		}
		
		return "redirect:/";
	}
	
}
