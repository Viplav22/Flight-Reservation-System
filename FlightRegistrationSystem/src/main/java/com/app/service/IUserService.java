package com.app.service;

import com.app.pojos.Card;
import com.app.pojos.User;

public interface IUserService {
	User authenticate(String email, String password);

	Boolean validateCardDetails(User u, Card c);

}
