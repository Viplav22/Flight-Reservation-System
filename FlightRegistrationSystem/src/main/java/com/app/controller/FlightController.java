package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Flight;
import com.app.service.IFlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private IFlightService flightService;

	public FlightController() {
		System.out.println("in init of  " + getClass().getName() + " " + flightService);
	}

	// add req handling method to show flight search form
	@GetMapping("/search")
	public String showFlightSearchForm() {
		System.out.println("in  show flight search form ");
		return "/flight/search";// search.jsp
	}

	// add a req handling method to process search form
	@PostMapping("/search")
	public String processSearchForm(@RequestParam String src_city, @RequestParam String dest_city,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dept_date, Model modelMap) {
		System.out.println("in process search form " + src_city + " " + dest_city + " " + dept_date);
		try {
			// invoke service layer method for B.L
			List<Flight> flights = flightService.fetchFlights(src_city, dest_city, dept_date);
			flights.forEach(System.out::println);
		
			// if no flights found display message
			if(flights.isEmpty()) {
				modelMap.addAttribute("message", "Flights not found please try again!!!");
			}
			modelMap.addAttribute("flight_details", flights);

			return "/flight/display";
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			// adding the err message under req scope using ModelMap
			modelMap.addAttribute("message", "could not fetch flight list!!!!");
			return "redirect:/flight/search";
		}
	}

	// add a req handling method to display flight list
	@GetMapping("/display")
	public String showFlightListPage() {
		return "/flight/display";// display.jsp
	}
}
