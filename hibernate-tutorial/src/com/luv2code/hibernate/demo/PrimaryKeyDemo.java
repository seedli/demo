package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
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
			Student Student1 = new Student("John","Cena","YouCantSeeMe@gmail.com");
			Student Student2 = new Student("Mike","Trout","LAATrout@gmail.com");
			Student Student3 = new Student("Justin","Verlander","LoveKateUpton@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("save the students...");
			session.save(Student1);
			session.save(Student2);
			session.save(Student3);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally{
			factory.close();
		}

	}

}
