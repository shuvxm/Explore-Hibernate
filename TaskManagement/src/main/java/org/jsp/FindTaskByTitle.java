package org.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindTaskByTitle {
	public static void main(String[] args) {
		EntityManagerFactory emf	= Persistence.createEntityManagerFactory("dev");
	 	EntityManager em = emf.createEntityManager();
	 	
	 	Query q = em.createQuery("select t from Task t where t.title='Learn' ");
	 	
	 	List<Task> lt = q.getResultList();
	 	
	 	for(Task t: lt) {
	 		System.out.println(t);
	 	}
	}
}
