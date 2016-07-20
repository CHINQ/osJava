package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.servlet.http.HttpSession;*/




import javax.servlet.http.HttpSession;

import vo.Friend;
import vo.Posting;
import vo.Reply;
import vo.SubPage;
import vo.Users;
import biz.FriendBiz;
import biz.PostingBiz;
import biz.ReplyBiz;

/**
 * Servlet implementation class Posting_InnerServlet
 */
public class Posting_InnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Posting_InnerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("users");
		String uid_ben=user.getUid();
		String pid=request.getParameter("pid");
		PostingBiz pbiz=new PostingBiz();
		Posting post=pbiz.searchOnePosting(pid);
		post.setPcount(post.addCount(post.getPcount()));
		pbiz.changePosting(post);
		post.setUser(user);
		ReplyBiz rbiz=new ReplyBiz();
		request.setAttribute("post", post);
		FriendBiz fbiz=new FriendBiz();
		List<Friend> friendList=fbiz.searchFriendAsOneUser(uid_ben);
		String cpage=request.getParameter("cpage");
		SubPage subPage=new SubPage();
		subPage.setShowNumber(2);
		if(cpage==null){
			subPage.setCurrentPage(1);
		}else{
			subPage.setCurrentPage(Integer.parseInt(cpage));
		}
		subPage.setTotalElement(rbiz.replyCount(Integer.parseInt(pid)));
		List<Reply> replyList=rbiz.searchSomeOnesOwnReply(pid,subPage);
		request.setAttribute("replyList", replyList);
		request.setAttribute("subPage", subPage);
		session.setAttribute("friendList", friendList);
		request.getRequestDispatcher("index.jsp?page=posting_inner").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();	
		Users user=(Users)session.getAttribute("users");
		int pid=Integer.parseInt(request.getParameter("pid"));
		String rcontent=request.getParameter("rcontent");
		Date df=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Reply reply=new Reply();
		reply.setUser(user);
		reply.setRcontent(rcontent);
		reply.setPost(new Posting(pid));
		reply.setRtime(sdf.format(df));
		ReplyBiz biz=new ReplyBiz();
		boolean flag=biz.addReply(reply);
		if(flag){
			Posting post=new Posting(pid);
			post.setPrcount(post.addPrCount(post.getPrcount()));
			PostingBiz pbiz=new PostingBiz();
			pbiz.changePosting(post);
			response.sendRedirect("Posting_InnerServlet?pid="+pid);
		}else{
			response.sendRedirect("Posting_InnerServlet?pid="+pid);
		}

	}

}
