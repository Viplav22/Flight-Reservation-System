package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.pojos.Card;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Override
	public User authenticate(String email, String password) {
		return userDao.authenticate(email, password);
	}

	@Override
	public Boolean validateCardDetails(User u, Card c) {

		return userDao.validateCardDetails(u, c);
	}

}
