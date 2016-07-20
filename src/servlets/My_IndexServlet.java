package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.MessageBiz;
import vo.Message;
import vo.SubPage;

/**
 * Servlet implementation class My_IndexServlet
 */
public class My_IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public My_IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageBiz biz=new MessageBiz();
		String cp=request.getParameter("cp");				
		SubPage page=new SubPage();
		page.setShowNumber(8);
		if(cp==null){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.parseInt(cp));
		}
		page.setTotalElement(biz.searchMessageCount());
		request.setAttribute("subPage", page);
		List<Message> MessageList=biz.searchAllMessage(page);
		request.setAttribute("MessageList", MessageList);
		request.getRequestDispatcher("index.jsp?page=my_index").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
