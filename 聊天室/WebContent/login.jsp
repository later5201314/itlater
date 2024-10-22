<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <script type="javascript">
    function ishave(){
    var name=document.myform.txtName.value;
    var pass=document.myform.txtPassword.value;
    if(name.length==null){
      alert("请输入用户名！");
      return;
    }else if(pass.length==null){
    alert("请输入密码！");
    return;
    }
    }
    </script>
    <style type="text/css">
    A{
    color:blue;
    text-decoration:none;
    }
    A:hover{
    color:red;
    text-decoration:underline;
    }
    </style>
  </head>
  <body style="background-image: url(image/B.jpg);">
  <%
Cookie[] cs = request.getCookies();
Cookie username = null;
Cookie password = null;
String name="";
String pass="";
boolean b1=false;
boolean b2=false;
if(cs!=null&&cs.length>0){
for(Cookie c:cs){
	System.out.println(c.getName());
	if(c.getName().equals("username")){
		username=c;
		b1=true;
	}
	if(c.getName().equals("password")){
		password=c;
		b2=true;
	}
	if(b1&&b2)
		break;
}
}
if(b1&&b2){
	name=URLDecoder.decode(username.getValue(),"UTF-8");
	pass=password.getValue();
}
	
%>
    <center>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <form action="login" method="POST" name="myform" onsubmit="ishava()">
        <table>
          <caption><b><font size="5" color="blue">登录</font></b></caption>
          <tr>
            <td align="right">用户名:</td>
            <td><input type="text" name="username" size="20" value="<%=name %>" /></td>
          </tr>
          <tr>
            <td align="right">密码:</td>
            <td><input type="password" name="password" size="20" value="<%=pass %>" /></td>
          </tr>
          <tr>
            <td>记住密码</td>
            <td><input type="checkbox" name="isrem" value="1"  /></td>
          </tr>
          <tr align="center">
            <td colspan="2">
            <input type="submit" name="btnOK" value="登录" />
            &nbsp;&nbsp;<a href="regist.jsp">注册</a>
            </td>
          </tr>
        </table>
      </form>
    </center>
  </body>
</html>
