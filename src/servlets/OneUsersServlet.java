package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import vo.Users;
import biz.UsersBiz;

/**
 * Servlet implementation class OneUsersServlet
 */
public class OneUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String uid=(String) session.getAttribute("uid");
		UsersBiz biz=new UsersBiz();
		List<Users> list=biz.searchUsers(uid);
		request.setAttribute("oneUsers",list);
		request.getRequestDispatcher("index.jsp?page=updateUsers").forward(request, response);
	}

}
