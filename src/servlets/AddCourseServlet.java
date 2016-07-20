package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Course;
import vo.Lector;
import biz.CourseBiz;

/**
 * Servlet implementation class AddCourseServlet
 */
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String lid=request.getParameter("lid");
		String ctime=request.getParameter("ctime");
		String cplace=request.getParameter("cplace");
		Course course=new Course(new Lector(Integer.parseInt(lid)),ctime,cplace);
		CourseBiz biz=new CourseBiz();
		boolean flag=biz.addCourse(course);
		if(flag){
			response.sendRedirect("houtaiCourseServlet");
		}
	}


}






