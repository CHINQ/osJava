package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Message;
import vo.Users;
import biz.MessageBiz;

/**
 * Servlet implementation class HouMessageChangeServlet
 */
public class HouMessageChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouMessageChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid=request.getParameter("mid");
		MessageBiz biz=new MessageBiz();
		Message oneMessage=biz.searchOneMessage(mid);
		request.setAttribute("oneMessage", oneMessage);
		request.getRequestDispatcher("index.jsp?page=message").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid=request.getParameter("mid");
		String uid=request.getParameter("uid");
		String mtitle=request.getParameter("mtitle");
		String mcontent=request.getParameter("mcontent");
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Message mes=new Message(Integer.parseInt(mid), new Users(uid,uid), mtitle, mcontent, sdf.format(dt));
		MessageBiz biz=new MessageBiz(); 
		boolean flag=biz.changeMessage(mes);
		if(flag){
			response.sendRedirect("HouMessageServlet");
		}else{
			response.sendRedirect("HouMessageServlet?changeMmsg=0");
		}
		
	}

}
