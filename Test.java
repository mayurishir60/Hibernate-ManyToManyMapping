package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		User user1 = new User();

		user1.setUsername("Ram");
		user1.setEmail("ram@gmail.com");

		User user2 = new User();
		user2.setUsername("Ravi");
		user2.setEmail("ravi@gmail.com");

		Nominee nominee1 = new Nominee();

		nominee1.setName("Puja");

		Nominee nominee2 = new Nominee();

		nominee2.setName("payal");

		Nominee nominee3 = new Nominee();

		nominee3.setName("Pallavi");

		user1.getNominees().add(nominee1);
		user1.getNominees().add(nominee2);
		user1.getNominees().add(nominee3);

		user2.getNominees().add(nominee2);
		user2.getNominees().add(nominee3);

		nominee1.getUsers().add(user1);
		nominee2.getUsers().add(user1);
		nominee3.getUsers().add(user1);

		nominee2.getUsers().add(user2);
		nominee3.getUsers().add(user2);

		session.save(user1);
		session.save(user2);

		transaction.commit();
		session.close();

		System.out.println("Inserted Successfully...............");

	}

}
