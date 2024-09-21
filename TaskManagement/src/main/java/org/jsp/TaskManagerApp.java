package org.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TaskManagerApp {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("1.Save task \n2.Update Task \n3.Find Task \n4.Delete Task");
			System.out.println("Enter your choice to perform the task");
			switch (sc.nextInt()) {
			case 1: 
				saveTask();
				break;
			case 2: 
				updateTask();
				break;
			case 3:
				findTask();
				break;
			case 4:
				deleteTask();
				break;
			default:
				System.out.println("Invalid choice..");
				break;
			}
		}
	}
	
	static void saveTask()
	{
		Scanner sc = new Scanner(System.in);

		Task t = new Task();
		System.out.println("Enter ID :");
		t.setId(sc.nextInt());
		System.out.println("Enter Title :");
		t.setTitle(sc.next());
		System.out.println("Enter Description :");
		t.setDes(sc.next());

		
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(t);
		et.commit();
		System.out.println("Task saved");
	}
	
	static void findTask() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID :");
		Task task = em.find(Task.class, sc.nextInt());
		System.out.println(task);
	}
	
	static void deleteTask() 
	{
		EntityTransaction et = em.getTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID :");
		Task task = em.find(Task.class, sc.nextInt());
		
		et.begin();
		em.remove(task);
		et.commit();
	}
	
	static void updateTask()
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID :");
		Task task = em.find(Task.class, sc.nextInt());
		
		System.out.println("Enter description: ");
		task.setDes(sc.next());
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(task);
		et.commit();
	}
}
