package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.FlightDAO;
import dao.GenericDAO;
import model.Flight;
import model.FlightType;

public class FlightController {

	public static void flightMenu() {
		System.out.println("1) Création d'un vol");
		System.out.println("2) Liste des vols");
		System.out.println("3) Recherche d'un vol");

		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		switch(input) {
		case 1 :
			flightCreationSystem();
			break;
			
		case 2 :
			showAllFlights();
			break;
			
		case 3 :
		default :
			findFlight();
			break;
			
		}
	}

	private static void findFlight() {
		System.out.println("Rechercher par : ");
		System.out.println("1) Numéro du vol");
		System.out.println("2) Villes de départ et d'arrivée");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		switch(input) {
		case 1 :
			findByFlightNumber();
			break;
		case 2 :
		default :
			findByFlightStartAndArrival();
			break;
		}
	}
	
	private static void findByFlightStartAndArrival() {
		System.out.println("Veuillez entrer la ville de départ");
		Scanner scanner = new Scanner(System.in);
		String startCity = scanner.nextLine();
		
		System.out.println("Veuillez entrer la ville d'arrivée");
		Scanner scanner2 = new Scanner(System.in);
		String arrivalCity = scanner2.nextLine();
		
		FlightDAO flightDAO = new FlightDAO();
		List<Flight> flights = flightDAO.getFlightByStartAndArrival(startCity, arrivalCity);
		System.out.println("Numéro \t | Type | Places | Départ \t | Arrivée \t  | Date");
		for(Flight flight : flights) {
			System.out.println(flight.toString());
		}
		
	}
	
	private static void findByFlightNumber() {
		System.out.println("Veuillez entre le numéro du vol");
		Scanner scanner = new Scanner(System.in);
		String flightNumber = scanner.nextLine();
		FlightDAO flightDAO = new FlightDAO();
		Flight flight = flightDAO.getFlightByNumber(flightNumber);
		System.out.println("Numéro \t | Type | Places | Départ \t | Arrivée \t  | Date");
		System.out.println(flight.toString());
	}

	private static void flightCreationSystem() {
		System.out.println("Veuillez renseigner le numéro de vol");
		Scanner scanner2 = new Scanner(System.in);
		String flightNumber = scanner2.nextLine();
		
		FlightType flightType = flightTypeMenu();

		System.out.println("Veuillez renseigner le nombre de places");
		Scanner scanner3 = new Scanner(System.in);
		Integer seats = scanner3.nextInt();
		
		System.out.println("Veuillez renseigner la ville de départ");
		Scanner scanner4 = new Scanner(System.in);
		String startCity = scanner4.nextLine();
		
		System.out.println("Veuillez renseigner la ville d'arrivée");
		Scanner scanner5 = new Scanner(System.in);
		String arrivalCity = scanner5.nextLine();
		
		System.out.println("Veuillez renseigner la date de départ (JJ/MM/AAAA)");
		Scanner scanner6 = new Scanner(System.in);
		String takeOffDate = scanner5.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate flightTakeOff = LocalDate.parse(takeOffDate, formatter);
		
		Flight flight = new Flight();
		flight.setFlightNumber(flightNumber);
		flight.setFlightType(flightType);
		flight.setStartCity(startCity);
		flight.setArrivalCity(arrivalCity);
		flight.setSeats(seats);
		flight.setFlightTakeOff(flightTakeOff);
		flight.setReservations(new ArrayList<>());
		
		GenericDAO<Flight> flightDAO = new FlightDAO();
		flightDAO.persist(flight);
	}

	private static FlightType flightTypeMenu() {
		System.out.println("Veuillez renseigner le type d'avion");
		System.out.println("1) A330");
		System.out.println("2) A340");
		System.out.println("3) A380");
		System.out.println("4) B747");
		
		Scanner scanner = new Scanner(System.in);
		
		switch(scanner.nextLine()) {
		case "1" :
			return FlightType.A330;
		case "2" :
			return FlightType.A340;
		case "3" :
			return FlightType.A380;
		case "4" :
		default:
			return FlightType.B747;
		}
	}
	
	private static void showAllFlights() {
		FlightDAO flightDAO = new FlightDAO();
		List<Flight> flights = flightDAO.getAllFlights();
		
		System.out.println("Numéro \t | Type | Places | Départ \t | Arrivée \t  | Date");
		for(Flight flight : flights) {
			System.out.println(flight.toString());
		}
	}
}
