package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "flight_id", nullable = false)
	private Flight flightId;

	@OneToOne
	@JoinColumn(name = "passenger_id", nullable = false)
	private Passenger pid;

	public Reservation(Flight flightId, Passenger pid) {
		super();
		this.flightId = flightId;
		this.pid = pid;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight getFlightId() {
		return flightId;
	}

	@Override
	public String toString() {
		return "Reservation [flightId=" + flightId + ", pid=" + pid + "]";
	}

	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	}

	public Passenger getPid() {
		return pid;
	}

	public void setPid(Passenger pid) {
		this.pid = pid;
	}

}
