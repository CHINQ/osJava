package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Books;
import vo.Lector;
import vo.Message;
import vo.SubPage;
import biz.BooksBiz;
import biz.LectorBiz;
import biz.MessageBiz;

/**
 * Servlet implementation class Index_Servlet
 */
public class Index_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageBiz biz=new MessageBiz();
		BooksBiz bizs=new BooksBiz();
		String cp=request.getParameter("cp");						
		SubPage page=new SubPage();
		page.setShowNumber(6);
		if(cp==null){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.parseInt(cp));
		}
		page.setTotalElement(biz.searchMessageCount());
		request.setAttribute("subPage", page);
		List<Message> MessageList=biz.searchAllMessage(page);
		request.setAttribute("MessageList", MessageList);
		LectorBiz lbiz=new LectorBiz();
		String cpage=request.getParameter("cpage");
		SubPage subPage=new SubPage();
		subPage.setShowNumber(3);
		if(cpage==null){
			subPage.setCurrentPage(1);
		}else{
			subPage.setCurrentPage(Integer.parseInt(cpage));
		}
		subPage.setTotalElement(lbiz.lectorCount());
		List<Books>booklist=bizs.searchBook(page);
		List<Lector> list=new ArrayList<Lector>();
		list=lbiz.selectLector(subPage);
		request.setAttribute("lectorList", list);
		request.setAttribute("bookList", booklist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
