package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import vo.Course;
import vo.SubPage;
import biz.CourseBiz;

/**
 * Servlet implementation class HoutaiCourseServlet
 */
public class HoutaiCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoutaiCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String cp=request.getParameter("cp");		
		String bnm=request.getParameter("bnm");
		String btxt=request.getParameter("btxt");
		boolean flag = false;
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
		CourseBiz biz=new CourseBiz();
		page.setTotalElement(biz.searchCourseCount(bnm,btxt));		
		List<Course> list=biz.searchCourse(page,bnm,btxt);
		request.setAttribute("infos",list);
		request.setAttribute("subPage",page);
		request.setAttribute("bnm",bnm);
		request.setAttribute("btxt",btxt);
		request.getRequestDispatcher("index.jsp?page=houtaiCourse").forward(request, response);
	}

}
