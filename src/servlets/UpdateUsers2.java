package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import vo.Users;
import biz.UsersBiz;

/**
 * Servlet implementation class UpdateUsers2
 */
public class UpdateUsers2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUsers2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imagePath=null;
		SmartUpload up=new SmartUpload("utf-8");
		up.initialize(this.getServletConfig(),request,response); 
		up.setAllowedFilesList("jpg,png,gif");
		up.setMaxFileSize(1000*1024);
		try{
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
		Users users=new Users();
		users.setUimage(imagePath);
		SmartRequest re=up.getRequest();
		users.setUid(re.getParameter("uid"));
		users.setUname(re.getParameter("uname"));
		users.setUage(Integer.parseInt(re.getParameter("uage")));
		users.setUsex(re.getParameter("usex"));
		users.setUtext(re.getParameter("utext"));
		UsersBiz biz=new UsersBiz();
		boolean flag=biz.updateUsers(users,this.getServletContext().getRealPath("/"));
		if(flag){
			HttpSession session=request.getSession();
			session.setAttribute("users",users);
			response.sendRedirect("UsersServlet");
		}
	}
}
