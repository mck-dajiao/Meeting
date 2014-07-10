<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.util.List,com.dajiao.model.Meeting,com.dajiao.model.User,com.dajiao.model.Department"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@include file="header.jsp"%>
<%@include file="navbar.html"%>
<%@include file="header2.jsp"%>

<body onload="navload(4);">
	<%
		request.setCharacterEncoding("utf-8");
		String currentPage = (String)request.getParameter("page");
	%>

	<main class="container" role="main">

	<div id="invite-content" class="carousel slide" data-ride="carousel"
		data-interval="0">
		<div class="carousel-inner">

			<div class="item active" id="page1">
				<div class="bookingRoom jumbotron">
					<table class="table">
						<thead>
							<tr>
								<th>会议主题</th>
								<th>会议室</th>
								<th>起始时间</th>
								<th>会议说明</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						<%
							List<Meeting> bookingList = (List<Meeting>)request.getAttribute("bookingList");
							if(bookingList != null){
								for(int i = 0; i<bookingList.size(); i++){
									Meeting meeting = bookingList.get(i);
						%>
							<tr>
								<td><%=meeting.getTopic() %></td>
								<td><%=meeting.getRoomname() %></td>
								<td><%=meeting.getStarttime() %></td>
								<td><%=meeting.getDetail() %></td>
								<td class="text-center"><a href="./MyInviteServlet?page=1&meetingId=<%=meeting.getId() %>"
									class="btn btn-default" >邀请参会人员</a></td>
							</tr>
						<%
								}
							}
						%>
						</tbody>
					</table>
				</div>
			</div>

			<div class="item" id="page2">
				<div class="jumbotron">
					<!-- 搜索表单开始 -->
					<div class="container">
						<form method="post" action="MyInviteServlet?page=2&search=1&meetingId=<%=(String)request.getParameter("meetingId") %>" >
							<div class="form-inline">
								<div class="form-group">
									<input type="text" placeholder="姓名" class="form-control" name="name"/>
								</div>
								<div class="form-group">
									<select class="form-control" name="sex">
										<option value="">不限性别</option>
										<option value="1">男</option>
										<option value="0">女</option>
									</select>
								</div>
								<div class="form-group">
									<select class="form-control" name="department">
										<option value="">不限部门</option>
										<%
											List<Department> departmentList = 
												(List<Department>)request.getAttribute("departmentList");
											if(departmentList != null){
												for(int i = 0; i<departmentList.size(); i++){
													Department department = departmentList.get(i);
													
										%>
										<option value="<%=department.getName()%>"><%=department.getName() %></option>
										<%
												}
											}
										%>
									</select>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary" >查询</button>
								</div>
							</div>
						</form>
					</div>
					<!-- 搜索表单结束 -->

					<div class="container">
						<table class="table table-striped table-bordered" id="inviteList" >
							<caption>
								<strong>会议（<%=(String)request.getAttribute("topic") %>）当前邀请名单</strong>
							</caption>
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
							String meetingId = (String)request.getAttribute("meetingId");
							List<User> userList = (List<User>)request.getAttribute("inviteList");
							if(userList != null && meetingId != null){
								for(int i = 0; i<userList.size(); i++){
									User user = userList.get(i);
							%>
								<tr id="itr<%=i%>">
									<td><%=user.getUserid() %></td>
									<td><%=user.getName() %></td>
									<td><%=user.getSex() %></td>
									<td><%=user.getDepartment() %></td>
									<td><a href="MyInviteServlet?page=2&&delete=1&&account=<%=user.getAccount() %>&&meetingId=<%=meetingId %>" 
										class="btn btn-primary btn-sm">删除</a></td>
								</tr>
							<%
								}
							}
							if(meetingId == null) meetingId="0";
							%>
							</tbody>
						</table>
						
						<div style="float: right; padding: 5px">
							<a href="MyInviteServlet?page=2&&invite=1" class="btn btn-primary btn-sm"
								data-slide="prev"
								">完成邀请</a>
						</div>
					</div>
				</div>
			</div>
			
			<div class="item" id="page3">
				<div class="jumbotron">
					<div class="container">
						<table class="table table-striped table-bordered" id="searchList">
							<caption>
								<strong>搜索列表</strong>
							</caption>
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>所属部门</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							<%
								meetingId = (String)request.getAttribute("meetingId");
								userList = (List<User>)request.getAttribute("userList");
								if(userList != null && meetingId != null){
									for(int i = 0; i<userList.size(); i++){
										User user = userList.get(i);
							%>
								<tr id="str<%=i%>">
									<td><%=user.getUserid() %></td>
									<td><%=user.getName() %></td>
									<td><%=user.getSex() %></td>
									<td><%=user.getDepartment() %></td>
									<td><a href="#"
										class="btn btn-primary btn-sm"
										onclick="inviteUser('<%=i%>','<%=user.getAccount() %>')"
										>邀请</a></td>
								</tr>
							<%
									}
								}
								if(meetingId==null) meetingId="0";
							%>
							</tbody>

						</table>
						
						<div style="float: right; padding: 5px">
							<a href="#" class="btn btn-primary btn-sm"
								onclick="completeInvite2(<%=meetingId %>)">完成</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</main>

	<!-- 修改对话框开始 -->
	<div id="modify" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title text-center">信息更改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="meetingTopic" class="control-label col-md-2">会议主题</label>
							<div class="col-md-10">
								<input type="text" id="meetingTopic" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="meetingRoom" class="control-label col-md-2">会议室</label>
							<div class="col-md-10">
								<input type="text" id="meetingRoom" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="startTime" class="col-md-2 control-label">起始时间</label>
							<div class="col-md-4">
								<input type="date" id="startTime" class="form-control"
									value="1979-05-04" />
							</div>
							<div class="col-md-4">
								<input type="time" id="startTime" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="endTime" class="col-md-2 control-label">结束时间</label>
							<div class="col-md-4">
								<input type="date" id="endTime" class="form-control"
									value="1979-05-04" />
							</div>
							<div class="col-md-4">
								<input type="time" id="endTime" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="control-label col-md-2">变更说明</label>
							<div class="col-md-10">
								<input type="text" id="description" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-5">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">确定</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
							</div>
						</div>
				</div>
				</form>
			</div>

		</div>
	</div>
	</div>
	<!-- 修改对话框结束 -->
	
	<!-- 提交数据暂存 -->
	<form id="deleteForm" method="post">
	</form>
	
	<form id="inviteForm" method="post">
	</form>
	<!-- 提交数据暂存结束 -->

	<%@include file="footer.html"%>
	<script type="text/javascript">
	var page = <%=currentPage%>;
	if(page!=null){
		if(page=='1'){
			document.getElementById('page1').setAttribute("class", "item active");
			document.getElementById('page2').setAttribute("class", "item");
			document.getElementById('page3').setAttribute("class", "item");
		}else if(page=='2'){
			document.getElementById('page1').setAttribute("class", "item");
			document.getElementById('page2').setAttribute("class", "item active");
			document.getElementById('page3').setAttribute("class", "item");
		}else if(page=='3'){
			document.getElementById('page1').setAttribute("class", "item");
			document.getElementById('page2').setAttribute("class", "item");
			document.getElementById('page3').setAttribute("class", "item active");
		}
	}
	titleLoad("邀请参会");
	
	
	/*
	function deleteUser(index, userAccount, meetingId){
		document.getElementById('inviteList').children[2].removeChild(document.getElementById('itr'+index));
		var deleteForm = document.getElementById('deleteForm');
		var input = document.createElement("input");
		var id = deleteForm.childElementCount + 1;
		var value = userAccount + " " + meetingId;
		input.setAttribute("type", "hidden");
		input.setAttribute("name", "deleteUser");
		input.setAttribute("value", value);
		
		deleteForm.appendChild(input);
	}
	
	function completeInvite(meetingId){
		var deleteForm = document.getElementById('deleteForm');
		deleteForm.setAttribute("action", "MyInviteServlet?page=2&&invite=1&&meetingId="+meetingId);
		deleteForm.submit();
	}
	*/
	
	function inviteUser(index, userAccount){
		document.getElementById('searchList').children[2].removeChild(document.getElementById('str'+index));
		var inviteForm = document.getElementById('inviteForm');
		var input = document.createElement("input");
		var id = inviteForm.childElementCount + 1;
		input.setAttribute("type", "hidden");
		input.setAttribute("name", "inviteUser");
		input.setAttribute("value", userAccount);
		
		inviteForm.appendChild(input);
	}
	
	function completeInvite2(meetingId){
		var inviteForm = document.getElementById('inviteForm');
		inviteForm.setAttribute("action", "MyInviteServlet?page=3&meetingId="+meetingId);
		inviteForm.submit();		
	}
	</script>

</body>
</html>