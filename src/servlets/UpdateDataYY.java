package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Books;
import biz.BooksBiz;

/**
 * Servlet implementation class UpdateDataYY
 */
public class UpdateDataYY extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDataYY() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bid=request.getParameter("bid");
		String bids=bid.substring(0, bid.indexOf(".",bid.indexOf(".")));
		BooksBiz biz=new BooksBiz();
		Books book=biz.searchBook(bids);		
		request.setAttribute("oneBook", book);
		request.getRequestDispatcher("datamanager.jsp?page1=updatedata").forward(request, response);
	}

}
