package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Posting;
import vo.SubPage;
import vo.Users;
import biz.PostingBiz;

/**
 * Servlet implementation class MyPostingServlet
 */
public class MyPostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPostingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("users");
		String uid=user.getUid();
		String cpage=request.getParameter("cpage");
		SubPage subPage=new SubPage();
		subPage.setShowNumber(4);
		if(cpage==null){
			subPage.setCurrentPage(1);
		}else{
			subPage.setCurrentPage(Integer.parseInt(cpage));
		}
		PostingBiz biz=new PostingBiz();
		subPage.setTotalElement(biz.searchPostingCount(uid));
		List<Posting> list=biz.searchAllPosting(uid);
		request.setAttribute("subPage", subPage);
		request.setAttribute("mypost", list);
		request.getRequestDispatcher("index.jsp?page=myposting").forward(request, response);;
		
	}

}
