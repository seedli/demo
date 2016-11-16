package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			//use the session object to save Java object
			System.out.println("Create new student object...");
			Student tempStudent = new Student("Apuju","Su","apuju@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("save the student.");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			//NEW CODE
			
			//find out the student's id: primary key
			System.out.println("Save student. Generated id: " + tempStudent.getId());
			
			//now get a transaction and start it
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student from database on the id: primary key
			System.out.println("\nGetting student with id: "+ tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally{
			factory.close();
		}

	}

}
