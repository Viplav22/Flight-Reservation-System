package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Flight;

public interface IFlightDao {
	
	// get list of flights
	List<Flight> fetchFlights(String sourceCity, String destCity, LocalDate date);

	Flight getFlightById(int fid);
}
