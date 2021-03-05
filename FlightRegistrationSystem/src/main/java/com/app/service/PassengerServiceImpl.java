package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IPassengerDao;
import com.app.pojos.Passenger;

@Service
@Transactional
public class PassengerServiceImpl implements IPassengerService {
	@Autowired
	private IPassengerDao passengerDao;

	@Override
	public void savePassengerDetails(Passenger transientPassenger) {
		passengerDao.savePassengerDetails(transientPassenger);
	}
}