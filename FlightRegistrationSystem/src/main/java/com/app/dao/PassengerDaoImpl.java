package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Passenger;

@Repository
public class PassengerDaoImpl implements IPassengerDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public void savePassengerDetails(Passenger transientPassenger) {
		mgr.persist(transientPassenger);
	}
}
