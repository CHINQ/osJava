package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.FriendBiz;
import biz.UsersBiz;
import vo.Friend;
import vo.Users;

/**
 * Servlet implementation class FriendAddServlet
 */
public class FriendAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FriendAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("users");
		String uid=request.getParameter("uid");
		String pid=request.getParameter("pid");
		UsersBiz ubiz=new UsersBiz();
		Users oneUser=ubiz.searchOneUser(uid);
		Friend fri=new Friend(oneUser, user);
		FriendBiz biz=new FriendBiz();
		List<Friend> fList=biz.searchAllFriend();
		boolean flags=true;
		for(Friend ff:fList){
			if(ff.getUser_ben().getUid().equals(user.getUid()) && ff.getUser().getUid().equals(uid)){
				flags=false;
				break;
			}
		}
		if(flags){
			boolean flag=biz.addFriend(fri);
			if(flag){
				response.sendRedirect("Posting_InnerServlet?pid="+pid);
			}else{
				response.sendRedirect("Posting_InnerServlet?gzmsg=0&pid="+pid);
			}
		}else{
			response.sendRedirect("Posting_InnerServlet?gzmsg=0&pid="+pid);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
