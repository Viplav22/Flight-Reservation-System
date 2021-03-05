package com.app.dao;

import com.app.pojos.Card;
import com.app.pojos.User;

public interface IUserDao {
	User authenticate(String email, String password);

	Boolean validateCardDetails(User u, Card c);
}
