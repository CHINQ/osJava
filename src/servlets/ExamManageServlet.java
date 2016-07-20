package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.ExamManageBiz;
import biz.LectorBiz;
import vo.ExamManage;
import vo.Lector;
import vo.SubPage;

/**
 * Servlet implementation class ExamManageServlet
 */
public class ExamManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExamManageServlet() {
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

		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String msg=request.getParameter("msg");
		switch(Integer.parseInt(msg)){
		case 0:
			emlist=embiz.selectALLExam();
			long t1=dt.getTime();
			String time=null;
			for(ExamManage em:emlist){
				time=em.getEmtime();
				int emid=em.getEmid();
				try {
					long t2=sdf.parse(time).getTime();
					long t3=t2-t1;
					if(t3>0){
						int emoverdue=1;
						flag=embiz.updateExamManage(emoverdue, emid);
					}else{
						int emoverdue=0;
						flag=embiz.updateExamManage(emoverdue, emid);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			page.setTotalElement(embiz.searchCount2());	
			emlist=embiz.selectExamManage2(page);
			session.setAttribute("emlist", emlist);
			request.setAttribute("subPage", page);
			request.setAttribute("bnm", bnm);
			request.setAttribute("btxt", btxt);
			request.getRequestDispatcher("learn.jsp?page=Exam").forward(request, response);
			break;
		case 1:
			String lid=request.getParameter("lid");
			String emtime=request.getParameter("emtime");
			String emduration=request.getParameter("emduration");
			if(emtime!=""){
				if(emduration!=""){
					int emstate=1;
					float emfull=100;
					long d1=dt.getTime();
					try {
						long d2=sdf.parse(emtime).getTime();
						long d3=d2-d1;
						if(d3>0){
							flag=embiz.addExamManage(lid, emtime, emduration,emfull,emstate);
							if(flag){
								response.sendRedirect("ExamManageServlet?msg=0");
							}
						}else{
							response.sendRedirect("learn.jsp?page=ExamManage&str=0");
						}
					} catch (ParseException e) {
						response.sendRedirect("learn.jsp?page=ExamManage&str=3");
					}
				}else{
					response.sendRedirect("learn.jsp?page=ExamManage&str=1");
				}
			}else{
				response.sendRedirect("learn.jsp?page=ExamManage&str=2");
			}


			break;
		case 2:
			String emid=request.getParameter("emid");
			flag=embiz.updateExamManage(emid);
			if(flag){
				page.setTotalElement(embiz.searchCount2());	
				emlist=embiz.selectExamManage2(page);
				session.setAttribute("emlist", emlist);
				request.setAttribute("subPage", page);
				request.setAttribute("bnm", bnm);
				request.setAttribute("btxt", btxt);
				request.getRequestDispatcher("learn.jsp?page=Exam&str=1").forward(request, response);
			}
			break;
		case 3:
			emid=request.getParameter("emid");
			emlist=embiz.selectExamManage(emid);
			List<Lector> llist=new ArrayList<Lector>();
			LectorBiz lbiz=new LectorBiz();
			llist=lbiz.selectLector();
			session.setAttribute("llist", llist);
			session.setAttribute("emlist", emlist);
			response.sendRedirect("learn.jsp?page=updateExam");
			break;		
		case 4:
			emid=request.getParameter("emid");
			lid=request.getParameter("lid");
			emtime=request.getParameter("emtime");
			emduration=request.getParameter("emduration");
			if(emtime!=""){
				if(emduration!=""){
					long s1=dt.getTime();
					try {
						long s2=sdf.parse(emtime).getTime();
						long s3=s2-s1;
						if(s3>0){
							flag=embiz.updateExamManage(lid, emtime, emduration, emid);
							if(flag){
								page.setTotalElement(embiz.searchCount2());	
								emlist=embiz.selectExamManage2(page);
								session.setAttribute("emlist", emlist);
								request.setAttribute("subPage", page);
								request.setAttribute("bnm", bnm);
								request.setAttribute("btxt", btxt);
								request.getRequestDispatcher("learn.jsp?page=Exam&str=2").forward(request, response);
							}
						}else{
							response.sendRedirect("learn.jsp?page=updateExam&str=0");
						}
					} catch (ParseException e) {
						response.sendRedirect("learn.jsp?page=updateExam&str=3");
					}
				}else{
					response.sendRedirect("learn.jsp?page=updateExam&str=1");
				}
			}else{
				response.sendRedirect("learn.jsp?page=updateExam&str=2");
			}
			break;		
		case 5:break;		
		}
	}

}
