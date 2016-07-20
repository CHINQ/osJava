package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Users;
import biz.UsersBiz;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		ServletContext application=this.getServletContext();
		String aname=request.getParameter("uid");
		String apass=request.getParameter("upass");
		UsersBiz aBiz=new UsersBiz();
		Users adm=aBiz.login(aname,apass);
		if(adm!=null){
			List<String> nameList=(List<String>)application.getAttribute("OnlineNameList");
            if(!nameList.contains(aname)){
            	session.setAttribute("users",adm );
            	session.setAttribute("aname", aname);
            	nameList.add(aname);
            	session.setAttribute("OnlineNameList", nameList);
            	response.sendRedirect("learning/MenuServlet?ms=1");
            }else{
            	response.sendRedirect("index.jsp?ms=0");
            	
            }
		}
	}
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	String name=request.getParameter("uid");
	String pass=request.getParameter("upass");
	UsersBiz biz=new UsersBiz();
	Users users=biz.login(name,pass);	
	if(users!=null){
		HttpSession session=request.getSession();
		session.setAttribute("users",users);
		response.sendRedirect("learning/MenuServlet");
	}else{
		response.sendRedirect("index.jsp?msg=10");
	}
	
}
}
