package org.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookManagementApp {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("1.To save book \n2.To update book \n3.To seach book \n4.To Delete book");
			System.out.println("Enter yuor choice to perform Book Management Operation");
			switch (sc.nextInt()) {
			case 1:
				saveBook();
				break;
			case 2:
				updateBook();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				deleteBook();
				break;
			default:
				System.out.println("Invalid choice...");
				break;
			}
		}
	}

	static void saveBook() {
		Book b = new Book();

		System.out.println("Enter ID : ");
		b.setId(sc.nextInt());
		System.out.println("Enter Book Name : ");
		b.setName(sc.next());
		System.out.println("Enter Book's Author : ");
		b.setAuthor(sc.next());
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(b);
		et.commit();
	}

	static void updateBook() {
		System.out.println("Enter ID : ");
		Book book = em.find(Book.class, sc.nextInt());
		System.out.println("Enter Author: ");
		book.setAuthor(sc.next());

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(book);
		et.commit();

	}

	static void searchBook() {
		System.out.println("Enter Id : ");
		Book book = em.find(Book.class, sc.nextInt());
		System.out.println(book);
	}

	static void deleteBook() {
		EntityTransaction et = em.getTransaction();
		System.out.println("Enter Id : ");
		Book book = em.find(Book.class, sc.nextInt());

		et.begin();
		em.remove(book);
		et.commit();
	}

}
