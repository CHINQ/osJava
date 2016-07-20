package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Users;
import biz.UsersBiz;

/**
 * Servlet implementation class AddUserTcServlet
 */
public class AddUserTcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserTcServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Users users=new Users();	  
		String id=request.getParameter("uid");
		String pass=request.getParameter("upass");
		String name=request.getParameter("uname");
		String sex=request.getParameter("usex");
		String age=request.getParameter("uage");
		users.setUid(id);
		users.setUpass(pass);
		users.setUname(name);
		users.setUsex(sex);
		users.setUage(Integer.parseInt(age));
		users.setUpower("10");
		UsersBiz biz=new UsersBiz();
		boolean flag=biz.addUsers1(users);
		if(flag){
			response.sendRedirect("learn.jsp?page=userscontrol");
		}else{
			response.sendRedirect("learn.jsp?page=userscontrolmsg=11");
		}
	}	

}
