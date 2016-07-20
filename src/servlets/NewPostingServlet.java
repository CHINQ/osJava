package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.PostingBiz;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import vo.Posting;
import vo.Users;

/**
 * Servlet implementation class NewPostingServlet
 */
public class NewPostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewPostingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random ra=new Random();
		int number1=ra.nextInt(10);
		int number2=ra.nextInt(10);
		int number3=ra.nextInt(10);
		int number4=ra.nextInt(10);
		request.setAttribute("number1", number1);
		request.setAttribute("number2", number2);
		request.setAttribute("number3", number3);
		request.setAttribute("number4", number4);
		request.getRequestDispatcher("index.jsp?page=newposting").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date dt=new Date();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		SmartUpload up=new SmartUpload("utf-8");
		up.initialize(this.getServletConfig(), request, response);
		up.setAllowedFilesList("jpg,png,gif");
		up.setMaxFileSize(1000*1024);
		String path="images/posting";
		String name="";
		try {
			up.upload();
			SmartFiles filelist=up.getFiles();		
			SmartFile file=filelist.getFile(0);
			name=dt.getTime()+"."+file.getFileExt();
			file.saveAs(path+"/"+name);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SmartRequest re=up.getRequest();
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("users");
		String ptitle=re.getParameter("ptitle");
	    String pcontent=re.getParameter("pcontent");
		Posting post=new Posting();
		post.setPtitle(ptitle);
		post.setPcontent(pcontent);
		post.setUser(user);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		post.setPtime(sdf.format(dt));
		post.setPimage(path+"/"+name);
		PostingBiz biz=new PostingBiz();
		boolean flag=biz.addNewPosting(post);
		if(flag){
			response.sendRedirect("PostingServlet");
		}else{
			response.sendRedirect("index.jsp?page=newposting&newpmsg=0");
		}

	}
}
