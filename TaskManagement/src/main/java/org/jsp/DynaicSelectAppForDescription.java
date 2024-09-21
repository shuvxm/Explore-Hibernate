package org.jsp;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynaicSelectAppForDescription {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);

		// Number PlaceHolder
//		Query q = em.createQuery("select t from Task t where t.title=?21 and t.des=?22");
		
		// Name PlaceHolder
		Query q = em.createQuery("select t from Task t where t.title=:abb and t.des=?1");
		System.out.println("Enter title: ");
		q.setParameter("abb", sc.next());
		System.out.println("ENter your description: ");
		q.setParameter(1, sc.next());

		List<Task> list = q.getResultList();

		for (Task t : list) {
			System.out.println(t);
		}

	}
}
