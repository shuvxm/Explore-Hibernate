package cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em1 = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		
		em1.find(User.class, 1);
		em1.find(User.class, 2);
		em2.find(User.class, 1);
		em2.find(User.class, 2);
		
		
	}
}
