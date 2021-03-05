package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IFlightDao;
import com.app.pojos.Flight;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService {
	@Autowired
	private IFlightDao flightDao;

	@Override
	public List<Flight> fetchFlights(String sourceCity, String destCity, LocalDate date) {
		return flightDao.fetchFlights(sourceCity, destCity, date);
	}

	@Override
	public Flight getFlightById(int fid) {
		return flightDao.getFlightById(fid);
	}

}
