package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Flight;

public interface IFlightService {
		
	List<Flight> fetchFlights(String sourceCity, String destCity, LocalDate date);
	
	Flight getFlightById(int fid);
}
