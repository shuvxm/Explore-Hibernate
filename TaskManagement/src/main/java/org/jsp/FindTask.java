package org.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindTask {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID :");
		Task task = em.find(Task.class, sc.nextInt());
		System.out.println(task);
		
	}

}
