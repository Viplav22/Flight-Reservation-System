package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.service.IFlightService;
import com.app.service.IPassengerService;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	private IPassengerService passengerService;

	@Autowired
	private IFlightService flightService;

	public PassengerController() {
		System.out.println("in init of  " + getClass().getName() + " " + passengerService + " " + flightService);
	}

	// add req handling method to get passenger details
	@GetMapping("/details")
	public String getPassengerDetails(@RequestParam int fid, Model modelMap, Passenger p, HttpSession hs) {
		System.out.println("in get passenger details form " + fid + modelMap + p);
		try {
			// added selected flight details to the session scope
			Flight selectedFlight = flightService.getFlightById(fid);
			// modelMap.addAttribute("selected_flight", selectedFlight);
			hs.setAttribute("selected_flight_http", selectedFlight);
			return "/passenger/details";// details.jsp
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			// adding the err message under req scope using ModelMap
			modelMap.addAttribute("message", "could not fetch flight details!!!!");
			// => invalid login
			return "redirect:/flight/display";
		}
	}

	// add a method to process passenger details
	@PostMapping("/details")
	public String processPassengerDetails(@Valid Passenger p, BindingResult res, Model modelMap, HttpSession hs) {
		System.out.println("in process passenger details " + modelMap);
		System.out.println("passenger details : " + p);
		System.out.println("binding result " + res);
		// check for P.L. errors first
		if (res.hasErrors()) {
			System.out.println("in P.L. validation failure");
			// forward the clnt to reg form : highlighted with errors
			return "/passenger/details";
		}
		// => no presentation logic errors, p : TRANSIENT(auto bound to req data by SC)
		try {
			// calling service layer method
			passengerService.savePassengerDetails(p);

			// saving passenger details under the map
			modelMap.addAttribute("passenger_details", p);
			hs.setAttribute("passenger_details_http", p);

			return "redirect:/user/card_dtls";
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			// adding the err message under req scope using ModelMap
			modelMap.addAttribute("message", "Could not save passenger details!!!");
			return "/passenger/details";
		}
	}
}