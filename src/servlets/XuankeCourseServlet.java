package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.SelectCourseBiz;
import vo.Users;

/**
 * Servlet implementation class XuankeCourseServlet
 */
public class XuankeCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuankeCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("users");
		String cid=request.getParameter("cid");
		SelectCourseBiz biz=new SelectCourseBiz();
		boolean flag=biz.searchSelectCourse(cid,user.getUid());
		if(flag){
			response.sendRedirect("Course_Servlet?msgsel=0");	
	}
	}
}
