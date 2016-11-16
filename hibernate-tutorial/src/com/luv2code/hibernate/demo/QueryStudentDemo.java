package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			//query student: lastName='Lee'
			theStudents = session.createQuery("from Student s where s.lastName='lee' ").getResultList();
			
			//display the students
			System.out.println("print out the students who have last name of Lee.");
			displayStudents(theStudents);
			
			//query student: lastName='Lee' or firstName='Apuju'
			theStudents = session.createQuery("from Student s where s.lastName='lee' OR firstName='Apuju' ").getResultList();
			System.out.println("print out the students who have lastName='Lee' or firstName='Apuju'.");
			displayStudents(theStudents);
			
			//query students where email like gmail.com
			theStudents = session.createQuery("from Student s where s.email like('%gmail.com') ").getResultList();
			System.out.println("print out the students who have email like gmail.com.");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student theStudent : theStudents){
			System.out.println(theStudent);
		}
	}

}
