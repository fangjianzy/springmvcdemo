<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>index</title>
  </head>
  
  <body>
    <form action="<%=path %>/order/login" method="post">
          用户：<input type="text" name="userName"><br><br>
          密码：<input type="text" name="password"><br><br>
        <input type="submit" value="确定">
    </form>
    
    <br>
    
  </body>
</html>