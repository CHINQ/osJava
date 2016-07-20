package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Lector;
import vo.SubPage;
import vo.Users;
import vo.Words;
import biz.LectorBiz;
import biz.WordsBiz;

/**
 * Servlet implementation class LeaveWordsServlet
 */
public class LeaveWordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeaveWordsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LectorBiz biz=new LectorBiz();
		List<Lector> lectorList=biz.selectLector();
		request.setAttribute("lectorList", lectorList);
		WordsBiz wbiz=new WordsBiz();
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("users");
		String uid=user.getUid();
		String cp=request.getParameter("cp");					
		SubPage page=new SubPage();
		page.setShowNumber(4);
		if(cp==null){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.parseInt(cp));
		}
		page.setTotalElement(wbiz.searchWordsCount(uid));
		request.setAttribute("subPage", page);
		List<Words> wordsList=wbiz.searchNowUserWords(user,page);
		request.setAttribute("wordsList", wordsList);
		request.getRequestDispatcher("index.jsp?page=leavewords").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("users");
		String lid=request.getParameter("lid");
		LectorBiz lbiz=new LectorBiz();
		Lector lector=lbiz.searchOneLector(lid);
		String wcontent=request.getParameter("wcontent");
		Words wor=new Words();
		wor.setUser(user);
		wor.setToUser(new Users(lector.getUser().getUid(),lector.getUser().getUname()));
		wor.setWcontent(wcontent);
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		wor.setWtime(sdf.format(dt));
		WordsBiz biz=new WordsBiz();
		boolean flag=biz.addWords(wor);
		if(flag){
			response.sendRedirect("LeaveWordsServlet");
		}else{
			response.sendRedirect("LeaveWordsServlet?leavemsg=0");
		}
	}

}
