package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction 
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display the students 
			displayStudents(theStudents);
			
			// query students: lastName:="paul"
			System.out.println("------------------------------------------");
			theStudents = session.createQuery("\nfrom Student s where s.lastName='jack'").list();
			
			
			// display the students 
			System.out.println("\n\nStudents who have last name of jack");
			displayStudents(theStudents);
			
			// query students: lastName:="paul" OR firstName='Merry'
			theStudents = session.createQuery("\nfrom Student s where s.lastName='jack' OR s.firstName='Merry'").list();

			// display the students 
			System.out.println("\n\nStudents who have llastName:=\"paul\" OR firstName='Merry'");
			displayStudents(theStudents);
			
			
			// query students where email LIKE '%luv2code.com' 
			theStudents = session.createQuery("\nfrom Student s where " +"s.email LIKE '%rmail.com'").list();
			
			// display the students 
			System.out.println("\n\nStudents who email");
			displayStudents(theStudents);
			
			// commit transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

}
