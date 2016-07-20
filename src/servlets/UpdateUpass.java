package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Users;
import biz.UsersBiz;

/**
 * Servlet implementation class UpdateUpass
 */
public class UpdateUpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUpass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newupass=request.getParameter("newupass");
		String newupass1=request.getParameter("newupass1");
		HttpSession session=request.getSession();
		Users user=(Users) session.getAttribute("users");
		String pass=user.getUpass();
		String uid=user.getUid();
        String oldpass=request.getParameter("oldupass");
        if(pass.equals(oldpass)){
        	if(newupass!=""){
        		if(newupass.equals(newupass1)){
    		UsersBiz biz=new UsersBiz();
    		boolean flag=biz.updateUpass(newupass,uid);
    		 if(flag){   			
    			 response.sendRedirect("index.jsp?page=updateUsers&msg=1");   			 
    		 }
        	} else{
        		response.sendRedirect("index.jsp?page=updateUsers&msg=3");
        	}
        	}else{
        		response.sendRedirect("index.jsp?page=updateUsers&msg=2");
        	}	
        }else{      
        	response.sendRedirect("index.jsp?page=updateUsers&msg=0");
        }        	
	}
}
