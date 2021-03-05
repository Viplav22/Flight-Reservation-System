package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "flights")
public class Flight extends BaseEntity {

	@Column(length = 20, unique = true)
	private String airlineName;

	@Column(length = 20)
	private String departureCity;

	@Column(length = 20)
	private String arrivalCity;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate departureDate;

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(String airlineName, String departureCity, String arrivalCity, LocalDate departureDate) {
		super();
		this.airlineName = airlineName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDate = departureDate;
	}

	@Override
	public String toString() {
		return "Flight [airlineName=" + airlineName + ", departureCity=" + departureCity + ", arrivalCity="
				+ arrivalCity + ", departureDate=" + departureDate + "]";
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureTime(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

}
