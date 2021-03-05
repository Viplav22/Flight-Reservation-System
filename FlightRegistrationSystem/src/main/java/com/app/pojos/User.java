package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(length = 20, name = "user_name")
	private String userName;

	@Column(length = 50,unique = true)
	private String email;
	
	@Column(length = 20)
	private String password;
	
	@Column(length = 10,name = "phone_no", unique = true)
	private String phoneNo;

	@Embedded
	private Card cardDetails;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String email, String phoneNo) {
		super();
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Card getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(Card cardDetails) {
		this.cardDetails = cardDetails;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", phoneNo=" + phoneNo + ", cardDetails="
				+ cardDetails + "]";
	}

}
