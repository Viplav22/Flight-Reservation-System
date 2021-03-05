package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.service.IReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private IReservationService reservationService;

	public ReservationController() {
		System.out.println("in init of  " + getClass().getName() + " " + reservationService);
	}

	// add req handling method to display reservation status page
	@GetMapping("/status")
	public String showStatusPage(HttpSession session, Model modelMap, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("in show status page");
		try {
			Passenger passenger = (Passenger) session.getAttribute("passenger_details_http");
			System.out.println("passenger : " + passenger);
			Flight selectedflight = (Flight) session.getAttribute("selected_flight_http");
			System.out.println("flight : " + selectedflight);

			Integer reservationId = reservationService.reservePassengerInFlight(selectedflight, passenger);
			System.out.println("Reservation Id : " + reservationId);
			modelMap.addAttribute("rid", "Reservation Id : " + reservationId);

			// invalidate session before logout
			session.invalidate();
			// set refresh header to navigate the clnt to home page(index.jsp) after some
			// delay
			response.setHeader("refresh", "5;url=" + request.getContextPath());
			modelMap.addAttribute("redirect_message", "You will be redirected to Welcome Page in 5 seconds...");

			return "/reservation/status";// status.jsp
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			// adding the err message under req scope using ModelMap
			modelMap.addAttribute("message", "Reservation Unsuccessfull!!!");
			return "redirect:/reservation/status";
		}
	}
}