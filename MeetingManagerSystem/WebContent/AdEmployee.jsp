<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,com.dajiao.model.Meeting,com.dajiao.model.User"%>
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
					<input type="text" placeholder="姓名" name="name" class="form-control" />
				</div>

				<label class="control-label col-md-offset-1">工号</label>
				<div class="form-group">
					<input type="text" placeholder="工号" name="userId"
						class="form-control" />
				</div>

				<label class="control-label col-md-offset-1">部门</label>
				<div class="form-group">
					<input type="text" placeholder="部门" name="department"
						class="form-control" />
				</div>
				<div class="form-group col-md-offset-1">
					<button type="submit" class="btn btn-primary">查询</button>
				</div>
			</div>
		</form>
	</div>
	<!-- 搜索表单结束 -->

	<div class="container text-center jumbotron">
		<table class="table" id="table">
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
				<tr id="tr<%=i%>">
					<td><%=user.getUserid()%></td>
					<td><%=user.getName()%></td>
					<td><%=user.getSex()%></td>
					<td><%=user.getDepartment()%></td>
					<td><a href="#" class="btn btn-primary btn-sm"
						onclick="deleteUser('<%=i %>','<%=user.getaccount()%>')">删除</a></td>
				</tr>
				<%
					}
								}
				%>
			</tbody>
		</table>
	</div>
	
	<p>
		<a class="btn btn-lg btn-primary btn-shadow bs3-link " role="button"
			data-toggle="modal" href="#newEmp">添加员工</a>
	</p>
	
	<p>
		<a class="btn btn-lg btn-primary btn-shadow bs3-link " role="button"
			onclick="document.getElementById('deleteForm').submit();">完成</a>
	</p>

	</main>
	
	<!-- 注册对话框开始 -->
    <div id="newEmp" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title text-center">用户注册</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="post" action="AdEmployeeServlet?newEmployee=1" onsubmit="return check()">
                        <div class="form-group">
                            <label for="username" class="control-label col-md-2">用户名</label>
                            <div class="col-md-10">
                                <input type="text"  name="accountRe" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="control-label col-md-2">密码</label>
                            <div class="col-md-10">
                                <input type="password" name="passwordRe" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="control-label col-md-2">确认密码</label>
                            <div class="col-md-10">
                                <input type="password" name="passwordRe2" class="form-control" />
                            </div>
                        </div>
						<div class="form-group">
                            <label for="realname" class="control-label col-md-2">真实姓名</label>
                            <div class="col-md-10">
                                <input type="text" name="nameRe" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sex" class="control-label col-md-2">性别</label>
                            <div class="col-md-10">
                                <input type="text" name="sexRe" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="userid" class="control-label col-md-2">员工编号</label>
                            <div class="col-md-10">
                                <input type="text" name="useridRe" class="form-control" />
                            </div>
                        </div>
						<div class="form-group">
                            <label for="department" class="control-label col-md-2">部门</label>
                            <div class="col-md-10">
                                <input type="text" name="departmentRe" class="form-control" />
                            </div>
                        </div>
						<div class="form-group">
                            <label for="anhao" class="control-label col-md-2">暗号</label>
                            <div class="col-md-10">
                                <input type="text" name="anhaoRe" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="text-center">
                                <button type="submit" class="btn btn-default" >注册</button>
                                <button type="button" class="btn btn-default" >返回</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <!-- 注册对话框结束 -->

	<form id="deleteForm" method="post" action="AdEmployeeServlet?delete=1">
	</form>

	<%@include file="footer.html"%>
	<script type="text/javascript">
		titleLoad("用户管理");

		function deleteUser(index, userAccount){
			document.getElementById('table').children[1].removeChild(document.getElementById('tr'+index));
			var deleteForm = document.getElementById('deleteForm');
			var input = document.createElement("input");
			var id = deleteForm.childElementCount + 1;
			input.setAttribute("type", "hidden");
			input.setAttribute("name", "userAccount");
			input.setAttribute("value", userAccount);
			
			deleteForm.appendChild(input);
		}
		
		function check(){
			var pwd = document.getElementsByName('passwordRe')[0].value;
			var pwd2 = document.getElementsByName('passwordRe2')[0].value;
			if(pwd==pwd2)
				return true;

			if(pwd==null || pwd2==null){
				alert("密码不能为空");
				return false;
			}
			
			if(document.getElementsByName("accountRe")[0]==null){
				alert("用户名不能为空");
				return false;
			}
			
			if(document.getElementsByName("nameRe")[0]==null){
				alert("姓名不能为空");
				return false;
			}
			
			if(document.getElementsByName("departmentRe")[0]==null){
				alert("部门不能为空");
				return false;
			}
			
			if(document.getElementsByName("anhaoRe")[0]==null){
				alert("暗号不能为空");
				return false;
			}
			
			if(document.getElementsByName("useridRe")[0]==null){
				alert("员工编号不能为空");
				return false;
			}
			
			if(document.getElementsByName("sexRe")[0]==null){
				alert("性别不能为空");
				return false;
			}
			
			alert("两次密码不一样");
			return false;
		}
	</script>

</body>
</html>