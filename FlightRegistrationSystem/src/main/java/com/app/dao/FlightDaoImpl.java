package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Flight;

@Repository
public class FlightDaoImpl implements IFlightDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public List<Flight> fetchFlights(String sourceCity, String destCity, LocalDate date) {
		String jpql = "select f from Flight f where f.departureCity= :sourceCity and f.arrivalCity= :destCity and f.departureDate= :date";
		return mgr.createQuery(jpql, Flight.class).setParameter("sourceCity", sourceCity)
				.setParameter("destCity", destCity).setParameter("date", date).getResultList();
	}

	@Override
	public Flight getFlightById(int fid) {
		return mgr.find(Flight.class, fid);
	}
}
