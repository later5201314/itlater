package zhangsan.chatServlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhangsan.dbUtil.DButil;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = null;
		String b = request.getParameter("isrem");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"  "+password+" "+b);
		User user = DButil.queryUser(username);
		System.out.println(user.getPassword());
		if(user!=null&&user.getPassword().equals(password)){
			System.out.println(user.getPassword());
			cookies = request.getCookies();
			if(cookies!=null){
				for(Cookie c:cookies){
					if(c.getName().equals("username")||c.getName().equals("password")){
						System.out.println(c.getName()+" "+c.getValue());
						c.setMaxAge(0);
						c.setPath(request.getContextPath());
						response.addCookie(c);
					}
						
				}
			}
			if(b!=null){
				System.out.println("b is not null");
				Cookie c1 = new Cookie("username",URLEncoder.encode(username,"UTF-8"));
				c1.setPath(request.getContextPath());
				c1.setMaxAge(100000);
				response.addCookie(c1);
				Cookie c2 = new Cookie("password",password);
				c2.setPath(request.getContextPath());
				c2.setMaxAge(100000);
				response.addCookie(c2);
				
			}
			request.getSession().setAttribute("username", username);
			RequestDispatcher red = request.getRequestDispatcher("/WEB-INF/chatroom.jsp");
	        red.forward(request, response);
		}else{
			RequestDispatcher red = request.getRequestDispatcher("/WEB-INF/loginfail.jsp");
	        red.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
