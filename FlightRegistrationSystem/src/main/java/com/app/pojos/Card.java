package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Card {

	@Column(name = "card_no", length = 16)
	@NotBlank(message = "Enter Card Number")
	private String cardNo;

	@Column(name = "exp_date")
	@NotBlank(message = "Enter Card Number")
	private LocalDate expDate;

	@NotBlank(message = "Enter Card Number")
	private int cvv;

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(String cardNo, LocalDate expDate, int cvv) {
		super();
		this.cardNo = cardNo;
		this.expDate = expDate;
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", expDate=" + expDate + ", cvv=" + cvv + "]";
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	
}
