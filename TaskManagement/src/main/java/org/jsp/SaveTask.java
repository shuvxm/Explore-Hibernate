package org.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveTask {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Task t = new Task();
		System.out.println("Enter ID :");
		t.setId(sc.nextInt());
		System.out.println("Enter Title :");
		t.setTitle(sc.next());
		System.out.println("Enter Description :");
		t.setDes(sc.next());
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(t);
		et.commit();
		System.out.println("Task saved");
	}

}
