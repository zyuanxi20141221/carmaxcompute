<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%= basePath %>"/>
<title>index page</title>
</head>

<body>
	<form method="post">
		<input type="button" name="showlist" value="显示列表" onclick="window.location.href='CarInfoServlet?page=first';" /><br/>
		<input type="button" name="ok" value="ok" onclick="window.location.href='<%=basePath%>show.jsp'"/><br/>
		
		使用Action属性接收参数<a href="user/UserAction1!add?name=john&age=30">Add User</a><br/>
		使用Domain Model接收参数<a href="user/UserAction2!add?user.name=johnzheng&user.age=31">Add User</a><br/>
		使用ModelDriven接收参数<a href="user/UserAction3!add?name=郑飞&age=20">Add User</a><br/>
<ol>
	<li><a href="r/r1">dispatcher</a></li>
	<li><a href="r/r2">redirect</a></li>
	<li><a href="r/r3">chain</a></li>
	<li><a href="r/r4">redirectAction</a></li>
	<li>freemarker</li>
	<li>httpheader</li>
	<li>stream</li>
	<li>velocity</li>
	<li>xslt</li>
	<li>plaintext</li>
	<li>tiles</li>
</ol>
	</form>
</body>
</html>