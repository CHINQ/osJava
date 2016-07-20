package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.MenuBiz;
import vo.Menu;
import vo.Users;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("users");
		List<Menu> list=new ArrayList<Menu>();
		MenuBiz biz=new MenuBiz();
		list=biz.selectMenu(user);
		session.setAttribute("mlist", list);
//		response.sendRedirect("learn.jsp?page="+list.get(1).getMpath());
		response.sendRedirect("learn.jsp");
	}

}
