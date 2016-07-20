package listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
public class LoginListener implements ServletContextListener, HttpSessionAttributeListener,HttpSessionListener {

	private List<String> nameList=null;
	
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }

    public void attributeAdded(HttpSessionBindingEvent arg0) {
    	ServletContext application=arg0.getSession().getServletContext();
    	int count = Integer.parseInt(application.getAttribute("OnlineCount").toString());
    	count++;
    	application.setAttribute("OnlineCount", count);
    	nameList=(List<String>)application.getAttribute("OnlineNameList");
    	application.setAttribute("OnlineNameList", nameList);
    }

    public void contextInitialized(ServletContextEvent arg0) {
    	ServletContext application=arg0.getServletContext();
    	application.setAttribute("OnlineCount", 0);
    	nameList=new ArrayList<String>();
    	application.setAttribute("OnlineNameList", nameList);  	
    }
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub		
	}
	
}
