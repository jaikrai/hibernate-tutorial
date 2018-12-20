package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class UpdateStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "daffy@email.com");
			
			// start a transaction 
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving student.... ");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction 
			session.getTransaction().commit();
			
			// MY NEW CODE 
			
			// find out the student's id: primary key 
			System.out.println("Saved students. Generted id: "+tempStudent.getId());
			
			// now get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key 
			System.out.println("\nGetting student with id: "+tempStudent.getId());
			
			Student myStudnet = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "+myStudnet);
			// commit the transaction
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
