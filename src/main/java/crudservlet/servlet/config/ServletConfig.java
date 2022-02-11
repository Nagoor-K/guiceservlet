package crudservlet.servlet.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import crudservlet.service.StudentService;
import crudservlet.serviceimpl.StudentServiceImpl;
import crudservlet.servlet.Myservlet;

public class ServletConfig extends GuiceServletContextListener{

	  @Override
	  protected Injector getInjector() {
	    
	    return Guice.createInjector(new ServletModule() {
	    	@Override
	    	protected void configureServlets() {
	    		serve("/*").with(Myservlet.class);
	    		bind(StudentService.class).to(StudentServiceImpl.class);
	    	}
	    });
	  }
	  
		
	}
