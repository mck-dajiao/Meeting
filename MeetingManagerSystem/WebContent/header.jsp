<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>会议管理系统</title>

	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="TM就是会议管理系统啊">
    <meta name="keywords" content="会议管理系统">
    <meta name="author" content="dajiao，dowson">
    <meta name="HandheldFriendly" content="True" />
    <meta name="MobileOptimized" content="320" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="./styles/dajiao.css" rel="stylesheet" type="text/css"/>
    <link href="./styles/main.min.css" rel="stylesheet" type="text/css"/>
	<% request.setCharacterEncoding("utf-8");
		String showUserName = (String)request.getParameter("showUserName");
		if(showUserName != null){
	%>
	<script type="text/javascript">
		loadName('<%=showUserName%>');
	</script>
	<%
		}
	%>
</head>
<body>


</body>
</html>