<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.dajiao.model.Meeting,com.dajiao.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@include file="header.jsp"%>
<%@include file="adminNavbar.html"%>
<%@include file="header2.jsp"%>

<body onload="navload(2);">

	<main class="container" role="main"> <!-- 搜索表单开始 -->
	<div class="container jumbotron">
		<form method="post" action="AdEmployeeServlet?search=1">
			<div class="form-inline">
				<label class="control-label">姓名</label>
				<div class="form-group">
					<input type="text" placeholder="姓名" id="name" class="form-control" />
				</div>

				<label class="control-label col-md-offset-1">工号</label>
				<div class="form-group">
					<input type="text" placeholder="工号" id="number"
						class="form-control" />
				</div>

				<label class="control-label col-md-offset-1">部门</label>
				<div class="form-group">
					<input type="text" placeholder="部门" id="department"
						class="form-control" />
				</div>
				<div class="form-group col-md-offset-1">
					<button type="submit" class="btn btn-primary">查询</button>
				</div>
				<div class="form-group col-md-offset-1">
					<button type="submit" class="btn btn-primary">添加员工</button>
				</div>
			</div>
		</form>
	</div>
	<!-- 搜索表单结束 -->

	<div class="container text-center jumbotron">
		<table class="table">
			<thead>
				<tr>
					<th>员工编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>所属部门</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<User> userList = (List<User>)request.getAttribute("userList");
						if(userList != null){
							for(int i = 0; i<userList.size(); i++){
								User user = userList.get(i);
				%>
				<tr id="itr<%=i%>">
					<td><%=user.getId()%></td>
					<td><%=user.getName()%></td>
					<td><%=user.getSex()%></td>
					<td><%=user.getDepartment()%></td>
					<td>
					<a href="#" class="btn btn-primary btn-sm"
						onclick="deleteUser('<%=user.getId()%>')">删除</a>
					</td>
				</tr>
				<%
							}
				}
				%>
			</tbody>
		</table>
	</div>

	</main>


	<%@include file="footer.html"%>
	<script type="text/javascript">
titleLoad("用户管理");

function deleteUser(id){
	
}
</script>

</body>
</html>