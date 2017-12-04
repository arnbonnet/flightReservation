package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "seq_flight", sequenceName = "seq_flight", initialValue = 1, allocationSize = 1)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "flight_number" }))
public class Flight {

	@Id
	@GeneratedValue(generator = "seq_flight")
	private Long id;

	@Column(name = "flight_number")
	@NotBlank
	private String flightNumber;

	@Column(name = "flight_type")
	@Enumerated(EnumType.STRING)
	@NotBlank
	private FlightType flightType;

	@NotNull
	private Integer seats;

	@Column(name = "start_city")
	@NotBlank
	private String startCity;

	@Column(name = "arrival_city")
	@NotBlank
	private String arrivalCity;

	@Column(name = "flight_take_off")
	@NotNull
	private LocalDate flightTakeOff;

	@OneToMany(fetch = FetchType.EAGER ,mappedBy = "flight")
	private List<Reservation> reservations = new ArrayList<>();

	public Flight() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public FlightType getFlightType() {
		return flightType;
	}

	public void setFlightType(FlightType flightType) {
		this.flightType = flightType;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDate getFlightTakeOff() {
		return flightTakeOff;
	}

	public void setFlightTakeOff(LocalDate flightTakeOff) {
		this.flightTakeOff = flightTakeOff;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return flightNumber + "\t | " + flightType.name() + " | " + seats + "\t | " + startCity + "\t | "
				+ arrivalCity + "\t | " + flightTakeOff;
	}

}
