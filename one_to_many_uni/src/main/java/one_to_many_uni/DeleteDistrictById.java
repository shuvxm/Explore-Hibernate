package one_to_many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDistrictById {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		int dId = 8;
		District d = em.find(District.class, dId);
		Query q = em.createQuery("from State");
		List<State> sl = q.getResultList();
		for (State s : sl) {
			ArrayList<District> al = new ArrayList<District>();
			List<District> ld = s.getDistrict();
			for (District di : ld) {
				if (di.getId() != d.getId())
					al.add(di);
			}
			s.setDistrict(al);
			et.begin();
			em.merge(s);
			et.commit();
		}
		et.begin();
		em.remove(d);
		et.commit();
	}
}