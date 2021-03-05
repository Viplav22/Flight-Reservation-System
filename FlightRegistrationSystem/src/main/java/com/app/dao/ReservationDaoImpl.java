package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.pojos.Reservation;

@Repository
public class ReservationDaoImpl implements IReservationDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public Integer reservePassengerInFlight(Flight fid, Passenger pid) {
		Reservation reservation = new Reservation(fid, pid);
		System.out.println(" in reservation " + reservation);
		mgr.persist(reservation);
		return reservation.getId();
	}

}
