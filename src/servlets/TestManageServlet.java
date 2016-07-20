package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.OptionBiz;
import biz.TestBiz;
import vo.Option;
import vo.SubPage;
import vo.Test;

/**
 * Servlet implementation class TestManageServlet
 */
public class TestManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestManageServlet() {
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
		List<Option> olist=new ArrayList<Option>();
		OptionBiz obiz=new OptionBiz();
		List<Test> tlist=new ArrayList<Test>();
		TestBiz tbiz=new TestBiz();
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
		page.setShowNumber(10);
		if(cp==null){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.parseInt(cp));
		}
		
		String msg=request.getParameter("msg");
		switch(Integer.parseInt(msg)){
		case 0:
			page.setTotalElement(tbiz.searchCount());
			tlist=tbiz.selectTest(page);
			olist=obiz.selectOption();
			session.setAttribute("tlist", tlist);
			session.setAttribute("olist", olist);
			request.setAttribute("subPage", page);
			request.setAttribute("bnm", bnm);
			request.setAttribute("btxt", btxt);
			request.getRequestDispatcher("learn.jsp?page=TestManage").forward(request, response);
			break;
		case 1:
			String tid=request.getParameter("tid");
			tlist=tbiz.selectOneTest(tid);
			olist=obiz.selectOneOption(tid);
			session.setAttribute("tlist", tlist);
			session.setAttribute("olist", olist);
			response.sendRedirect("learn.jsp?page=updateOneTest");
			break;
		case 2:
			tid=request.getParameter("tid");
			String title=request.getParameter("title");
			String A=request.getParameter("A");
			String B=request.getParameter("B");
			String C=request.getParameter("C");
			String D=request.getParameter("D");
			String truekey=request.getParameter("truekey");
			flag=obiz.updateA(A, tid);
			if(flag){
				obiz.updateB(B, tid);
				if(flag){
					obiz.updateC(C, tid);
					if(flag){
						obiz.updateD(D, tid);
						
					}
				}
			}
			flag=tbiz.updateTruekey(title, truekey, tid);
			if(flag){
				response.sendRedirect("TestManageServlet?msg=0");
			}
			break;
		case 3:
			title=request.getParameter("title");
			A=request.getParameter("A");
			B=request.getParameter("B");
			C=request.getParameter("C");
			D=request.getParameter("D");
			truekey=request.getParameter("truekey");
			String oidA="A";
			String oidB="B";
			String oidC="C";
			String oidD="D";
			Date dt=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String ttime=sdf.format(dt);
			flag=tbiz.addTest(title, truekey, ttime);
			tid=null;
			if(flag){
				tid=tbiz.searchOneTid(ttime)+"";
			}
			flag=obiz.addA(oidA, tid, A);
			if(flag){
				flag=obiz.addB(oidB, tid, B);
				if(flag){
					flag=obiz.addC(oidC, tid, C);
					if(flag){
						flag=obiz.addD(oidD, tid, D);
						if(flag){
							response.sendRedirect("TestManageServlet?msg=0");
						}
					}
				}
			}
			break;
		case 4:break;
		}
	}
}
