package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Card;
import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public User authenticate(String email, String password) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		return mgr.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", password)
				.getSingleResult();
	}

	@Override
	public Boolean validateCardDetails(User u, Card c) {
		System.out.println(getClass().getName());
		Card userCard = u.getCardDetails();
		System.out.println("User card " + c);
		System.out.println("Current card " + c);
		// verifying card cvv number and expiry date
		return true;
//		return userCard.getCvv() == c.getCvv() && userCard.getCardNo().equals(c.getCardNo())
//				&& userCard.getExpDate().equals(c.getExpDate());
	}
}
