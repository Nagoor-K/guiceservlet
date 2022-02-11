package crudservlet.serviceimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.inject.Guice;
import com.google.inject.servlet.ServletModule;

import crudservlet.entity.Student;
import crudservlet.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	  public void addStudents(Student student) {
		  emf=(EntityManagerFactory) Guice.createInjector(new ServletModule());
		  em=emf.createEntityManager();
		  em.getTransaction().begin();
		  em.persist(student);
		  em.close();
	  }
	  
	}