package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ExamManage;
import vo.Option;
import vo.SubPage;
import vo.Test;
import vo.TestDetail;
import vo.TestPaper;
import vo.Users;
import biz.ExamManageBiz;
import biz.OptionBiz;
import biz.TestBiz;
import biz.TestDetailBiz;
import biz.TestPaperBiz;
/**
 * Servlet implementation class TsetServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
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
		List<Test> tlist=new ArrayList<Test>();
		TestBiz tbiz=new TestBiz();
		List<Option> olist=new ArrayList<Option>();
		OptionBiz obiz=new OptionBiz();
		TestPaperBiz tpbiz=new TestPaperBiz();
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
						if(flag){
						}
					}else{
						int emoverdue=0;
						flag=embiz.updateExamManage(emoverdue, emid);
						if(flag){
						}
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
			page.setTotalElement(embiz.searchCount());	
			emlist=embiz.selectExamManage(page);
			session.setAttribute("emlist", emlist);
			request.setAttribute("subPage", page);
			request.setAttribute("bnm", bnm);
			request.setAttribute("btxt", btxt);
			request.getRequestDispatcher("learn.jsp?page=Test").forward(request, response);
			break;
		case 1:
			Random rd=new Random();
			int count=tbiz.searchCount();
			int arr[]=new int[5]; 
			for(int i=0;i<5;i++){ 
				arr[i]=rd.nextInt(count)+1;
				for(int j=0;j<i;j++){ 
					if(arr[j]==arr[i]){ 
						i--; 
						break;
					}
				} 
			}
			String tid=arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4];
			session.setAttribute("tid", tid);
			String emid=request.getParameter("emid");
			session.setAttribute("emid", emid);
			tlist=tbiz.selectTest(tid);
			olist=obiz.selectOption(tid);
			emlist=embiz.selectExamManage(emid);
			session.setAttribute("emlist", emlist);
			session.setAttribute("olist", olist);
			session.setAttribute("tlist", tlist);
			response.sendRedirect("Examine.jsp");
			break;	
		case 2:
			String[] oid=new String[5];
			for(int j=0;j<5;j++){
				oid[j]=request.getParameter(j+1+"");
			}	
			String tppitch=oid[0]+","+oid[1]+","+oid[2]+","+oid[3]+","+oid[4];
			session.setAttribute("tppitch", tppitch);
			int i=0;
			int temp=0;
			String[] tkey=new String[5];
			tlist=(List<Test>) session.getAttribute("tlist");
			for(Test t:tlist){
				tkey[i]=t.getTruekey();
				if(oid[i]!=null){
					if(oid[i].equals(tkey[i])){
						temp+=1;
					}else{
						temp=temp;
					}
				}else{				
				}
				i+=1;
			}
			float fullScore=i*20;
			float score=temp*20;
			Users user=(Users) session.getAttribute("users");
			String uid=user.getUid();
			emid=(String) session.getAttribute("emid");
			Date date=new Date();
			String tpdate=sdf.format(date);
			flag=tpbiz.addTestPaper(uid, fullScore, score, emid,tpdate);
			if(flag){
				List<TestPaper> tplist=new ArrayList<TestPaper>();
				tplist=tpbiz.selectTestPaper(tpdate);
				session.setAttribute("tplist", tplist);
				int tpid=0;
				for(TestPaper tp:tplist){
					tpid=tp.getTpid();
				}
				tid=(String) session.getAttribute("tid");
				tppitch=(String) session.getAttribute("tppitch");
				TestDetailBiz tdbiz=new TestDetailBiz();
				flag=tdbiz.addTestDetail(tpid, tid, tppitch);
				if(flag){
						tplist=tpbiz.selectTestPaper2(uid, page);
						page.setTotalElement(tpbiz.searchCount(uid));
					    session.setAttribute("tplist", tplist);
						request.setAttribute("subPage", page);
						request.setAttribute("bnm", bnm);
						request.setAttribute("btxt", btxt);
						request.getRequestDispatcher("learn.jsp?page=historyExam").forward(request, response);
				}
			}
			break;	
		case 3:
			user=(Users) session.getAttribute("users");
			uid=user.getUid();
			List<TestPaper> tplist=new ArrayList<TestPaper>();
			tpbiz=new TestPaperBiz();
			tplist=tpbiz.selectTestPaper2(uid, page);
			page.setTotalElement(tpbiz.searchCount(uid));
		    session.setAttribute("tplist", tplist);
			request.setAttribute("subPage", page);
			request.setAttribute("bnm", bnm);
			request.setAttribute("btxt", btxt);
			request.getRequestDispatcher("learn.jsp?page=historyExam").forward(request, response);
			break;	
		case 4:
			String tpid=request.getParameter("tpid");
			List<TestDetail> tdlist=new ArrayList<TestDetail>();
			TestDetailBiz tdbiz=new TestDetailBiz();
			tdlist=tdbiz.selectTid(tpid);
			tid=null;
			String [] pitch=new String[5];
			for(TestDetail td:tdlist){
				tid=td.getTid();
				pitch=td.getTppitch().split(",");
			}
			tplist=tpbiz.selectTestPaper3(tpid);
			session.setAttribute("tplist", tplist);
			session.setAttribute("tppitch", pitch);
			tlist=tbiz.selectTest(tid);
			olist=obiz.selectOption(tid);
			session.setAttribute("tlist", tlist);
			session.setAttribute("olist", olist);
			response.sendRedirect("historyTest.jsp");
			break;	
		case 5:break;	
		}
	}

}
