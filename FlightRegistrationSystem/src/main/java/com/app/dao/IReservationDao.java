package com.app.dao;

import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.pojos.Reservation;

public interface IReservationDao {
	Integer reservePassengerInFlight(Flight fid, Passenger pid);
}
