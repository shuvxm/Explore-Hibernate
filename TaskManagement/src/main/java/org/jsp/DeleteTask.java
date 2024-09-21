package org.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteTask {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID :");
		Task task = em.find(Task.class, sc.nextInt());
		
		et.begin();
		em.remove(task);
		et.commit();
	}
}
