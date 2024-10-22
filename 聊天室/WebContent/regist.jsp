<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>注册</title>
    <style type="text/css">
      body {
       background-image: url(image/B.jpg);
      }
    </style>
  </head>
  <body>
    <center>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <form action="regist" method="POST">
        <table>
          <caption><b><font size="5" color="blue">注册&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></b></caption>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;&nbsp;</td>
          </tr>
          <tr>
            <td align="right">用户名:</td>
            <td>*<input type="text" name="username" size="20" /></td>
            <td></td>
          </tr>
          <tr>
            <td align="right">密码:</td>
            <td>*<input type="password" name="password" size="20" /></td>
            <td>(密码必须是六位以上)</td>
          </tr>
          <tr>
            <td align="right">性别:</td>
            <td><select name="sex">
                <option value ="男">男</option>
                <option value ="女">女</option>
                </select>
            </td>
            <td></td>
          </tr>
          <tr>
            <td align="right">年龄:</td>
            <td><input type="text" name="age" size="20" /></td>
            <td></td>
          </tr>
          <tr>
            <td align="right">邮箱:</td>
            <td><input type="text" name="email" size="20" /></td>
            <td></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr align="center">
            <td colspan="2">
            <input type="submit"  name="btnkOK" value="提交"/>
            </td>
          </tr>
        </table>
      </form>
    </center>
  </body>
</html>