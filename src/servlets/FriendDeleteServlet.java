package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.FriendBiz;
/**
 * Servlet implementation class FriendDeleteServlet
 */
public class FriendDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String pid=request.getParameter("pid");
		FriendBiz biz=new FriendBiz();
		boolean flag=biz.deleteFriend(uid);
		if(flag){
			response.sendRedirect("Posting_InnerServlet?pid="+pid);
		}else{
			response.sendRedirect("Posting_InnerServlet?delFriMsg=0&pid="+pid);
		}
		
	}

}
