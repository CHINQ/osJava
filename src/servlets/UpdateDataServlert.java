package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Books;
import biz.BooksBiz;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UpdateDataServlert
 */
public class UpdateDataServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDataServlert() {
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
		   String imagePath=null; 
		   SmartUpload up=new SmartUpload("utf-8");
		   up.initialize(this.getServletConfig(), request, response);
		   up.setAllowedFilesList("jpg,png,gif");
		   up.setMaxFileSize(70*1024);
		   try {
			up.upload();
			SmartFiles list=up.getFiles();
			SmartFile file=list.getFile(0);
			if(file.getSize()!=0){
				Date dt=new Date();
				imagePath="images/"+dt.getTime()+"."+file.getFileExt();				
				file.saveAs(imagePath);
			}		
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Books  book=new Books();
		  book.setBimage(imagePath);
		  SmartRequest re=up.getRequest();
		  String bid2=re.getParameter("bid");
		  int bid=Integer.parseInt(bid2);
		  book.setBid(bid);
		  book.setBname(re.getParameter("bname"));
		  book.setBtext(re.getParameter("btext"));
		  book.setBimage(imagePath);
		  book.setBaddress(re.getParameter("baddress"));
		BooksBiz biz=new BooksBiz();
		boolean flag=biz.upBooks(book, this.getServletContext().getRealPath("/"));
		if(flag){
			response.sendRedirect("learn.jsp?page=datamanager?msg=10");
		}else{
			response.sendRedirect("updatedata?msg=0&bid="+book.getBid());
		}
	}

}
