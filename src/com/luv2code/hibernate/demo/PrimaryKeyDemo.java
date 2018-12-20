package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
				
		// create session 
		Session session = factory.getCurrentSession();
				
		try {
			// use the session object to save java object
					
			// create a student object
			System.out.println("Creating new studen object.... ");
			Student tempStudent1 = new Student("paul", "jack", "paul@rmail.com");
			Student tempStudent2 = new Student("John", "Do", "john@rmail.com");
			Student tempStudent3 = new Student("Merry", "Public", "merry@rmail.com");
						
			// start a transaction 
			session.beginTransaction();
						
			// save the student object
			System.out.println("Saving studen.... ");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
						
			// commit transation 
			session.getTransaction().commit();
						
			System.out.println("Done!");
						
			}finally {
				factory.close();
			}

	}

}
