package org.jsp;

import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAllTasks {
	public static void main(String[] args) {
 	EntityManagerFactory emf	= Persistence.createEntityManagerFactory("dev");
 	EntityManager em = emf.createEntityManager();
 	
// 	Query q = em.createQuery("select t from Task t");
 	Query q = em.createQuery("from Task");
 	
 	List<Task>	lt = q.getResultList();
 	System.out.println(lt);
 	
 	ListIterator<Task> l = lt .listIterator();
 	while(l.hasNext()) {
 		System.out.println(l.next());
 	}
 	
 	
 	
	}
}
