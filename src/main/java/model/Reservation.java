package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "seq_reservation", sequenceName = "seq_reservation", initialValue = 1, allocationSize = 1)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"reservation_number"})) 
public class Reservation {
	
	@Id
	@GeneratedValue(generator = "seq_reservation")
	private Long id;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String firstName;
	
	@NotNull
	private Integer age;
	
	@ManyToOne
	@NotNull
	private Flight flight;
	
	@Column(name = "reservation_number")
	@NotBlank
	private String reservationNumber;
	
	public Reservation() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	
}
