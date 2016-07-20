package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.SelectCourse;
import vo.SubPage;
import vo.Users;
import biz.SelectCourseBiz;

/**
 * Servlet implementation class SelectCourseServlet
 */
public class SelectCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.search(request, response, true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.search(request, response, true);
	}
	
	private void search(HttpServletRequest request,HttpServletResponse response,boolean flag)throws ServletException,IOException{
		HttpSession session=request.getSession();
		String cp=request.getParameter("cp");
		String snm=request.getParameter("snm");
		String stxt=request.getParameter("stxt");
		if(flag){
			if(snm!=null){
				snm=new String(snm.getBytes("iso-8859-1"),"utf-8");
			}
			if(stxt!=null){
				stxt=new String(stxt.getBytes("iso-8859-1"),"utf-8");
			}
		}
		SubPage page=new SubPage();
		page.setShowNumber(3);
		Users user=(Users) session.getAttribute("users");
		String uid=user.getUid();		
		if(cp==null){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.parseInt(cp));
		}
		SelectCourseBiz scbiz=new SelectCourseBiz();
		page.setTotalElement(scbiz.searchSelectCourseCount(snm,stxt));
		List<SelectCourse> list=scbiz.searchSelectCourse(page,snm,stxt);
		List<SelectCourse> clist=scbiz.searchSelectCourse2(uid);
		request.setAttribute("infoss", clist);
		request.setAttribute("subPage", page);
		request.setAttribute("snm", snm);
		request.setAttribute("stxt", stxt);
		request.getRequestDispatcher("learn.jsp?page=studentct&page1=classsee").forward(request, response);
		
	}
	

}
