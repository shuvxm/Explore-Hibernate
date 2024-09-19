package one_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateDistrictAndMapToExistingState {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		int sId = 102;

		State s = em.find(State.class, sId);

		District d = new District();
		d.setId(8);
		d.setName("Guntur");

		List<District> dl = s.getDistrict();
		dl.add(d);
		s.setDistrict(dl);
		et.begin();
		em.persist(d);
		em.merge(s);
		et.commit();
	}

}