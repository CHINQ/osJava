package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UsersBiz;

/**
 * Servlet implementation class UpdateNewUsersServlert
 */
public class UpdateNewUsersServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewUsersServlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String uid =request.getParameter("uid");
		 UsersBiz biz=new UsersBiz();
		 boolean flag=biz.updanewUsers(uid);		
		 if(flag){
			 response.sendRedirect("usersee?delmsg=1");
		 }else {
			 response.sendRedirect("usersee?delmsg=0");
		 }
	}

}
