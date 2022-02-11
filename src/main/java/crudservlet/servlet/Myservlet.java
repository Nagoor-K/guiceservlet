package crudservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import crudservlet.entity.Student;
import crudservlet.service.StudentService;

@Singleton
public class Myservlet extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = -4610057044542474058L;
  @Inject
  public StudentService studentService;
  
  public Myservlet() {
	  
  }
@Inject
public Myservlet(StudentService studentService){
	super();
	this.studentService=studentService;
	}

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	  PrintWriter out = resp.getWriter();
	  int id=Integer.parseInt(req.getParameter("id"));
	  String name=req.getParameter("name");
	  String city=req.getParameter("city");
	  Student student=new Student(id, name, city);
	  
	  studentService.addStudents(student);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
  }
	
}
