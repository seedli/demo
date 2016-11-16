package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			int studentId = 1;
			
			//start a transaction
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("\nget student: "+myStudent);
			
			myStudent.setLastName("Hao");
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally{
			factory.close();
		}

	}

}
