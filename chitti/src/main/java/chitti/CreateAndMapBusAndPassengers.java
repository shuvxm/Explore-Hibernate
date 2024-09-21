package chitti;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapBusAndPassengers {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Passenger p1 = new Passenger("Manoj", 100.0);
		Passenger p2 = new Passenger("Mohan", 600.0);
		Passenger p3 = new Passenger("Ramesh", 250.0);
		Passenger p4 = new Passenger("Priyanka", 500.0);
		
		ArrayList<Passenger> psl = new ArrayList<Passenger>();
		psl.add(p1);
		psl.add(p2);
		psl.add(p3);
		psl.add(p4);
		
		Bus b1 = new Bus();
		b1.setName("BMTC");
		b1.setCapacity(45);
		b1.setRegNo("KA17V5497");
		b1.setPassengers(psl);
		
		et.begin();
		em.persist(b1);
		et.commit();
		
	}
}
