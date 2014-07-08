<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<%@include file="adminNavbar.html"%>
<%@include file="header2.jsp"%>
</head>
<body>



	<%@include file="footer.html"%>
</body>
<script type="text/javascript">
titleLoad("会议管理系统");
var h2node = document.createElement('h2');
var anode = document.createElement('a');
h2node.setAttribute("class","blog-desc");
anode.innerText="管理员,你好哇";
h2node.appendChild(anode);
document.getElementById('header').appendChild(h2node);
</script>

</html>