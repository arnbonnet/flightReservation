package App;

import dao.DatabaseHelper;
import dao.FlightDAO;
import dao.GenericDAO;
import dao.ReservationDAO;
import model.Flight;
import model.FlightType;
import model.Reservation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.persistence.EntityManager;

import controller.FlightController;
import controller.ReservationController;

public class Run {

	public static void main(String[] args) {
		
		System.out.println("1) Gestion des vols");
		System.out.println("2) Gestion des réservations");
		System.out.println("3) Quitter");
		System.out.println();
		System.out.println("Entrez votre choix : ");
		
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		switch(input) {
		case 1 :
			FlightController.flightMenu();
			break;
			
		case 2 :
			ReservationController.reservationMenu();
			break;
			
		case 3 :
			System.exit(0);
			break;
			
		default :
			break;
		}
		
		
		/*
		 * FLIGHTS
		 */
//		Flight flight = new Flight();
//		flight.setFlightNumber("0001");
//		flight.setFlightType(FlightType.A330);
//		flight.setStartCity("Bordeaux");
//		flight.setArrivalCity("Montpellier");
//		flight.setSeats(380);
//		flight.setFlightTakeOff(LocalDate.now().plus(1, ChronoUnit.DAYS));
//		flight.setReservations(new ArrayList<>());
//
//		GenericDAO<Flight> flightDAO = new FlightDAO(Flight.class);
//		flightDAO.persist(flight);
		
		
		/*
		 * RESERVATIONS
		 */
//		Reservation reservation = new Reservation();
//		reservation.setFirstName("Paul");
//		reservation.setLastName("Watson");
//		reservation.setAge(51);
//		reservation.setReservationNumber("1");
//		
//		GenericDAO<Reservation> reservationDAO = new ReservationDAO(Reservation.class);
//		reservationDAO.persist(reservation);
	}

}
