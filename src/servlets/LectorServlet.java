package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.LectorBiz;
import vo.Lector;

/**
 * Servlet implementation class LectorServlet
 */
public class LectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LectorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		List<Lector> list=new ArrayList<Lector>();
		LectorBiz lbiz=new LectorBiz();
		String msg=request.getParameter("msg");
		switch(Integer.parseInt(msg)){
		case 0:
			list=lbiz.selectLector();
			session.setAttribute("llist", list);
			response.sendRedirect("learn.jsp?page=ExamManage");
			break;
		case 1:break;
		case 2:break;
		case 3:break;
		}
	}

}
