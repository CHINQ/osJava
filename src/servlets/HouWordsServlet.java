package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.SubPage;
import vo.Users;
import vo.Words;
import biz.WordsBiz;

/**
 * Servlet implementation class HouWordsServlet
 */
public class HouWordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouWordsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("index.jsp?page=words").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

}
