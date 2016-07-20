package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Message;
import vo.Users;
import biz.MessageBiz;

/**
 * Servlet implementation class HouMessageAddServlet
 */
public class HouMessageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouMessageAddServlet() {
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
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("users");		
		String mtitle=request.getParameter("mtitle");
		String mcontent=request.getParameter("mcontent");
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Message mes=new Message(user, mtitle, mcontent, sdf.format(dt));
		MessageBiz biz=new MessageBiz(); 
		boolean flag=biz.addNewMessage(mes);
		if(flag){
			response.sendRedirect("HouMessageServlet");
		}else{
			response.sendRedirect("HouMessageServlet?addMmsg=0");
		}
		
	}

}
