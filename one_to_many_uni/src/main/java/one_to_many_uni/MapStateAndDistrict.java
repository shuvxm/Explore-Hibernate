package one_to_many_uni;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapStateAndDistrict {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		State s = em.find(State.class, 101);
		District d1 = em.find(District.class, 1);
		District d2 = em.find(District.class, 2);
		District d3 = em.find(District.class, 3);
		District d4 = em.find(District.class, 4);
		ArrayList<District> list = new ArrayList<District>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		s.setDistrict(list);
		et.begin();
		em.merge(s);
		et.commit();

	}

}