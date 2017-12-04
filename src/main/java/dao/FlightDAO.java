package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Flight;

public class FlightDAO extends GenericDAO<Flight>{
	
	public FlightDAO() {
		super(Flight.class);
	}
	
	public List<Flight> getAllFlights() {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Flight> query = em.createQuery("select f from Flight f", Flight.class);
		
		List<Flight> flights = query.getResultList();
		
		return flights;
	}

	public Flight getFlightByNumber(String flightNumber) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Flight> query = em.createQuery("select f from Flight f where f.flightNumber=:fn", Flight.class)
									.setParameter("fn", flightNumber);
		
		return query.getSingleResult();
	}

	public List<Flight> getFlightByStartAndArrival(String startCity, String arrivalCity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Flight> query = em.createQuery("select f from Flight f where f.startCity=:sc and f.arrivalCity=:ac", Flight.class)
									.setParameter("sc", startCity)
									.setParameter("ac", arrivalCity);
		
		return query.getResultList();
	}

}
