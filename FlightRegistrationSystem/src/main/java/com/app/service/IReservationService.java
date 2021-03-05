package com.app.service;

import com.app.pojos.Flight;
import com.app.pojos.Passenger;

public interface IReservationService {
	Integer reservePassengerInFlight(Flight fid, Passenger pid);

}
