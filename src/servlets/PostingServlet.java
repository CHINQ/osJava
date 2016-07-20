package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.PostingBiz;
import vo.SubPage;
import vo.Posting;

/**
 * Servlet implementation class PostingServlet
 */
public class PostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpage=request.getParameter("cpage");
		SubPage subPage=new SubPage();
		subPage.setShowNumber(5);
		if(cpage==null){
			subPage.setCurrentPage(1);
		}else{
			subPage.setCurrentPage(Integer.parseInt(cpage));
		}
		PostingBiz biz=new PostingBiz();
		subPage.setTotalElement(biz.searchPostingCount());
		List<Posting> list=biz.searchAllPosting();
		request.setAttribute("posting", list);
		request.setAttribute("subPage", subPage);
		request.getRequestDispatcher("index.jsp?page=posting").forward(request, response);
	}

}
