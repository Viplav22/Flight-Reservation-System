package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "passengers")
public class Passenger extends BaseEntity {

	@Override
	public String toString() {
		return "Passenger [passengerName=" + passengerName + ", passengerEmail=" + passengerEmail
				+ ", passengerPhoneNo=" + passengerPhoneNo + "]";
	}

	@Column(length = 20)
	@NotBlank(message = "Name is required")
	private String passengerName;

	@Column(length = 50, unique = true)
	@NotBlank(message = "Email is required")
	private String passengerEmail;

	@Column(length = 10, unique = true)
	@NotBlank(message = "Email is required")
	private String passengerPhoneNo;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String passengerName, String passengerEmail, String passengerPhoneNo) {
		super();
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.passengerPhoneNo = passengerPhoneNo;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerPhoneNo() {
		return passengerPhoneNo;
	}

	public void setPassengerPhoneNo(String passengerPhoneNo) {
		this.passengerPhoneNo = passengerPhoneNo;
	}

}
