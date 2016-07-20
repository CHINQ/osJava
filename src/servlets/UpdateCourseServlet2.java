package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CourseBiz;
import vo.Course;

/**
 * Servlet implementation class UpdateCourseServlet2
 */
public class UpdateCourseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourseServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cid=request.getParameter("cid");
		  /*String lcourse=request.getParameter("lcourse"); 
		  String uname=request.getParameter("uname");*/
		  String ctime=request.getParameter("ctime");
		  String cplace=request.getParameter("cplace");
		  Course course=new Course(Integer.parseInt(cid),ctime,cplace);
		  CourseBiz biz=new CourseBiz();
		boolean flag1=biz.updateCourse(course);
			if(flag1){
				    response.sendRedirect("houtaiCourseServlet");
				    }		   
	}
}
