package com.app.controller;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Card;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor of " + getClass().getName() + " " + userService);
	}

	@PostConstruct
	public void anyInit() {
		System.out.println("in init of  " + getClass().getName() + " " + userService);
	}

	// add request handling method for : showing the login form
	@GetMapping("/login")
	// Key : /user/login: method=get
	// Value : com.app.controller.UserController.showLoginForm
	public String showLoginForm() {
		System.out.println("in show login form ");
		return "/user/login";
		// Actual view name : /WEB-INF/views/user/login.jsp
	}

	// add a req handling method to process the form
	// Key : /user/login: method=post
	// Value : com.app.controller.UserController.processLoginForm
	@PostMapping("/login")
	// @PostMapping => @RequestMapping: method=post
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model modelMap,
			HttpSession hs) {
		System.out.println("in process login form " + email + " " + password);
		try {
			// invoke service layer method for B.L
			User user = userService.authenticate(email, password);
			System.out.println(user);
			// => valid login
			// save validated user details under session scope
			hs.setAttribute("user_details", user);

			// directly forward to flight search page
			return "redirect:/flight/search";

		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			// adding the err message under req scope using ModelMap
			modelMap.addAttribute("message", "Invalid Login ,Please retry!!!!");
			// => invalid login
			return "/user/login";
		}
	}

	// add request handling method for : for signup req (just message)
	@GetMapping("/signup")
	public String showSignUpMsg(Model modelMap) {
		System.out.println("in showSignUpMsg ");
		modelMap.addAttribute("message", "Signup facility is not available");
		return "/welcome";// welcome.jsp
	}

	// add req handling method to display card details page
	@GetMapping("/card_dtls")
	public String showCardDetails() {
		System.out.println("in show card details form ");
		return "/user/card_dtls";// card_dtls.jsp
	}

	// add req handling method to process card details page
	@PostMapping("/card_dtls")
	public String processCardDetails(@RequestParam String c_num, @RequestParam String c_name,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate c_exp, @RequestParam int cvv,
			RedirectAttributes flashMap, HttpSession hs) {
		System.out.println("in process card details form ");
		try {
			Card c = new Card(c_num, c_exp, cvv);
			System.out.println(c);
			hs.setAttribute("card_details", c);

			// get user from the session
			User u = (User) hs.getAttribute("user_details");
			System.out.println("user details : "+u);

			// validate card details
			if (userService.validateCardDetails(u, c)) {
				System.out.println("verified");
				flashMap.addFlashAttribute("message", "Card details verified!!!");
				return "redirect:/reservation/status";
			}
			else {
				System.out.println("not verified");
				//flashMap.addFlashAttribute("message", "Card details not verified!!!");
				return "redirect:/user/card_dtls";
			}

//			flashMap.addFlashAttribute("message", "Reservation Successfull!!!");
//			return "redirect:/reservation/status";

		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			// adding the err message under req scope using ModelMap
			flashMap.addFlashAttribute("message", "Could not verify card details");
			return "redirect:/user/card_dtls";
		}
	}
}
