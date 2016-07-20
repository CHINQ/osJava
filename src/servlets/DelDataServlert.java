package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.BooksBiz;

/**
 * Servlet implementation class DelDataServlert
 */
public class DelDataServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelDataServlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String bid =request.getParameter("bid");
		 String path=this.getServletContext().getRealPath("/");
		BooksBiz biz=new BooksBiz();
		 boolean flag=biz.delBooks(bid, path);		
		 if(flag){
			 response.sendRedirect("studentdatadel?delmsg=1");
		 }else {
			 response.sendRedirect("studentdatadel?delmsg=0");
		 }
	}

}
