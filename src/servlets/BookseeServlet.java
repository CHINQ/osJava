package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookseeServlet
 */
public class BookseeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookseeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String fileName=request.getParameter("fileName");	
		String rootPath=getClass().getResource("/").getFile();   
		String content=getReadContent(request.getSession().getServletContext().getRealPath("/")+fileName);
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		out.println(content);
		if("".equals(fileName)){
			out.println("资料为空");
		} 

	}
	private String getReadContent(String fileName){
		String readContent="";

		try {File file=new File(fileName);
		FileReader in=new FileReader(file);
		BufferedReader inTwo=new BufferedReader(in);
		StringBuffer stringbuffer=new StringBuffer();
		String s=null;
		while((s=inTwo.readLine())!=null){
			byte bb[]=s.getBytes();
			s=new String(bb);
			stringbuffer.append("\n"+s);
		}
		readContent=new String(stringbuffer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e){
			readContent=""+e;
		}
		return readContent;
	}

}
