package zhangsan.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import zhangsan.chatServlet.User;

public class DButil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String name="root";
	private static String password = "java";
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static Connection getConnection(){
    	Connection conn = null;
    	try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhangsan_chat?useUnicode=true&characterEncoding=utf8", name,password );
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
    }
    
    public static void addUser(User user){
    	Connection conn = null;
    	conn = DButil.getConnection();
    	try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user(username,password, age, sex, email)VALUES (?, ?, ?, ?,?)");
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getAge());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getEmail());
			pstmt.executeUpdate();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static User queryUser(String name){
    	Connection conn = null;
    	conn = DButil.getConnection();
    	ResultSet rs = null;
    	User user  = null;
    	try {
			PreparedStatement pstmt = conn.prepareStatement("select *from user where username= ? ");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				System.out.println("ok");
				String username = rs.getString("username");  
                int age = rs.getInt("age");  
                String sex = rs.getString("sex");  
                String password = rs.getString("password");  
                String email = rs.getString("email");  
                user = new User();
                user.setAge(age);
                user.setEmail(email);
                user.setPassword(password);
                user.setSex(sex);
                user.setUsername(username);
			}
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
    }
    
    

}
