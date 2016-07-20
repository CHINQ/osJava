package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Books;
import vo.Users;
import biz.BooksBiz;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class AddDataServlert
 */
public class AddDataServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDataServlert() {
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
		SmartUpload up=new SmartUpload("utf-8");
		up.initialize(this.getServletConfig(), request, response);
		up.setAllowedFilesList("jpg,gif,png,txt,doc");
		up.setMaxFileSize(10*1024*1024); 
		String path="images";
		String name="";
		String name1="";
		String name2="";
		try {		
			up.upload();
			SmartFiles  fileList= up.getFiles(); 
			int coun=fileList.getCount();   
			while(coun>0){
				SmartFile file=fileList.getFile(0); 
				SmartFile file1=fileList.getFile(1);
				Date dt=new Date();			
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
				SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				name2=sdf2.format(dt);
				if("txt".equals(file1.getFileExt())||"doc".equals(file1.getFileExt())){
					name1=sdf.format(dt)+"."+file1.getFileExt();
					file1.saveAs(path+"/"+name1);
				}
				if("jpg".equals(file.getFileExt())||"gif".equals(file.getFileExt())||"png".equals(file.getFileExt())){
					name=sdf.format(dt)+"."+file.getFileExt();
					file.saveAs(path+"/"+name);
				}
				coun--;
			}

		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		Books books=new Books();
		Users user=(Users) session.getAttribute("users");
		books.setBimage(path+"/"+name);	  
		SmartRequest re=up.getRequest();
		books.setBname(re.getParameter("bname"));
		books.setBtext(re.getParameter("btext"));
		books.setBtime(name2);
		books.setBaddress(path+"/"+name1);
		books.setUid(user.getUid());
		BooksBiz biz=new BooksBiz();
		boolean flag=biz.addBooks(books);
		if(flag){
			response.sendRedirect("learn.jsp?page=datamanager&page1=adddata&mag=1");
		}else{
			response.sendRedirect("learn.jsp?page=datamanager&page1=adddata&msg=0");
		}
	}

}
