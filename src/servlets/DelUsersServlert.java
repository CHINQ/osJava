package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UsersBiz;

/**
 * Servlet implementation class DelUsersServlert
 */
public class DelUsersServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUsersServlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String uid =request.getParameter("uid");
		 String path=this.getServletContext().getRealPath("/");
		UsersBiz biz=new UsersBiz();
		 boolean flag=biz.delUsers(uid,path);		
		 if(flag){
			 response.sendRedirect("usersee?delmsg=1");
		 }else {
			 response.sendRedirect("usersee?delmsg=0");
		 }
	}

}
