package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class CreateStudentDemo {

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
			Student tempStudent = new Student("paul", "jack", "paul@rmail.com");
			
			// start a transaction 
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving studen.... ");
			session.save(tempStudent);
			
			// commit transation 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
