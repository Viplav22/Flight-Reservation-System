package com.app.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IReservationDao;
import com.app.pojos.Flight;
import com.app.pojos.Passenger;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {
	@Autowired
	private IReservationDao reservationDao;

	@Override
	public Integer reservePassengerInFlight(Flight fid, Passenger pid) {
		return reservationDao.reservePassengerInFlight(fid, pid);
	}

}
