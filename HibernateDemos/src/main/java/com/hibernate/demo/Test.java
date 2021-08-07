package com.hibernate.demo;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Test {

	public static void main(String[] args) {
		saveData();
		
//		retrieveData();
//		udpateData();
	//	deleteData();
		
	}

	private static void saveData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = new User();
		user.setUserId(6);
		user.setUsername("Aman");
		user.setCreatedBy("Intellect");
		user.setCreatedDate(new Date());
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("resource")
	private static void retrieveData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User"); //HQL - Hibernate Query Language
		List<User> list = (List<User>) query.list();
		for (User user : list) {
			System.out.println("List of Users::" + user.getUserId() + "," + user.getUsername());
		}
		// Get Employee with id
		query = session.createQuery("from User where userId= :userId");
		query.setLong("userId", 1);
		User user = (User) query.uniqueResult();
		System.out.println("User Detail::" + user.getUserId() + "," + user.getUsername());
		session.getTransaction().commit();
		session.close();
	}
	
	private static void udpateData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	        // Update Employee
	        Query query = session
	                .createQuery("update User set username= :name where userId= :id");
	        query.setParameter("name", "Amit Raj");
	        query.setLong("id", 1);
	        int result = query.executeUpdate();
	        System.out.println("User data Update Status=" + result);
	        session.getTransaction().commit();
	        session.close();
	}
	
	private static void deleteData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
			Query query = null;
	        query = session.createQuery("delete from User where userId= :id");
	        query.setLong("id", 3);
	        int result = query.executeUpdate();
	        System.out.println("User Data Delete Status=" + result);
	        session.getTransaction().commit();
	        session.close();
		
	}
}