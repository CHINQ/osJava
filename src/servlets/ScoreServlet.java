package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ExamManage;
import vo.SubPage;
import vo.TestPaper;
import vo.Users;
import biz.ExamManageBiz;
import biz.LectorBiz;
import biz.TestPaperBiz;

/**
 * Servlet implementation class ScoreServlet
 */
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.service(req, resp, true);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.service(req, resp, false);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response,boolean flag) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		List<ExamManage> emlist=new ArrayList<ExamManage>();
		ExamManageBiz embiz=new ExamManageBiz();
		LectorBiz lbiz=new LectorBiz();
		TestPaperBiz tpbiz=new TestPaperBiz();
		List<TestPaper> tplist=new ArrayList<TestPaper>();
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
		page.setShowNumber(4);
		if(cp==null){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.parseInt(cp));
		}		
		Users user=(Users) session.getAttribute("users");
		String uid=user.getUid();	
		String msg=request.getParameter("msg");
		switch(Integer.parseInt(msg)){
		case 0:
			page.setTotalElement(lbiz.searchCount(uid));	
			emlist=embiz.selectCourse(uid, page);
			session.setAttribute("emlist", emlist);
			request.setAttribute("subPage", page);
			request.setAttribute("bnm", bnm);
			request.setAttribute("btxt", btxt);
			request.getRequestDispatcher("learn.jsp?page=score").forward(request, response);
			break;
		case 1:
			String emid=request.getParameter("emid");
			page.setTotalElement(tpbiz.searchScoreCount(emid));
			tplist=tpbiz.selectScore(emid, page);
			int emid2=0;
			for(TestPaper tp:tplist){
				emid2=tp.getEm().getEmid();
			}
			session.setAttribute("emid", emid2);
			session.setAttribute("tplist", tplist);
			request.setAttribute("subPage", page);
			request.setAttribute("bnm", bnm);
			request.setAttribute("btxt", btxt);
			request.getRequestDispatcher("learn.jsp?page=searchScore").forward(request, response);
			break;
		case 2:break;
		case 3:break;
		}
	}

}



