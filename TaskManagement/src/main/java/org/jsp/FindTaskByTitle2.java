package org.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindTaskByTitle2 {
	public static void main(String[] args) {
		EntityManagerFactory emf	= Persistence.createEntityManagerFactory("dev");
	 	EntityManager em = emf.createEntityManager();
	 	
	 	Query q = em.createQuery("select t from Task t where t.title=:a ");
	 	q.setParameter("a", "SQL");
	 	
	 	System.out.println(q.getSingleResult());
	}

}
