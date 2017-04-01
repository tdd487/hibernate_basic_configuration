package com.tdd.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

public class TeacherTest1 {
	private  static SessionFactory sessionFactory = null;
	private  static Session session = null;
	@BeforeClass
	public static void before(){
		sessionFactory =
				new AnnotationConfiguration().configure().buildSessionFactory();
		session = sessionFactory.getCurrentSession();
	}

	@Test
	public void savetest(){
		Teacher teacher = new Teacher();
		teacher.setTitle("中级");
		teacher.setName("春娇");
		teacher.setId(8);
		teacher.setBirthDate(new Date());
		session.beginTransaction();
		session.save(teacher);
	}
	@AfterClass
	public static void after(){
		session.getTransaction().commit();
	}
}
