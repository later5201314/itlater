package zhangsan.chatServlet;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineListener
 *
 */
@WebListener
public class OnlineListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public OnlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    	String username = (String) arg0.getSession().getAttribute("username");
    	ArrayList<String> online = (ArrayList<String>) arg0.getSession().getServletContext().getAttribute("online");
		if(online==null){
			online = new ArrayList<String>();
		}
		online.add(username);
		arg0.getSession().getServletContext().setAttribute("online", online);
		Integer onlinenum = (Integer) arg0.getSession().getServletContext().getAttribute("onlinenum");
		if(onlinenum==null){
			onlinenum = 0;
		}
		onlinenum++;
		arg0.getSession().getServletContext().setAttribute("onlinenum", onlinenum);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    	String username = (String) arg0.getSession().getAttribute("username");
		ArrayList<String> online = (ArrayList<String>)arg0.getSession().getServletContext().getAttribute("online");
		online.remove(username);
		Integer num = (Integer)arg0.getSession().getServletContext().getAttribute("onlinenum");
		num--;
		arg0.getSession().getServletContext().setAttribute("onlinenum", num);
		arg0.getSession().getServletContext().setAttribute("online", online);
    }
	
}
