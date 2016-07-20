package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Books;
import vo.SubPage;
import biz.BooksBiz;

/**
 * Servlet implementation class SearchBookServlet
 */
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				this.search(req, resp, true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				this.search(req, resp, true);
	}
	private void search(HttpServletRequest request,HttpServletResponse response,boolean flag)throws ServletException,IOException{
		request.setCharacterEncoding("iso-8859-1");  
		String cp=request.getParameter("cp");
		String bnm=request.getParameter("bnm");
		String btxt=request.getParameter("btxt");
		if(flag){
			if(bnm!=null){
				bnm=new String(bnm.getBytes("iso-8859-1"),"utf-8");
			}
			if(btxt!=null){
				btxt=new String(btxt.getBytes("iso-8859-1"),"utf-8");
			}
		}
		SubPage page=new SubPage();
		page.setShowNumber(3);
		if(cp==null){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.parseInt(cp));
		}
		BooksBiz biz=new BooksBiz();
		page.setTotalElement(biz.searchBookCount(bnm,btxt));
		List<Books>list=biz.searchBook(page,bnm,btxt);
		request.setAttribute("infoss", list);
		request.setAttribute("subPage", page);
		request.setAttribute("bnm", bnm);
		request.setAttribute("btxt", btxt);
		request.getRequestDispatcher("learn.jsp?page=studentct&page1=studentdata").forward(request, response);
	}
}
