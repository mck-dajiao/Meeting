<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.dajiao.model.Meeting"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@include file="header.jsp"%>
<%@include file="navbar.html"%>
<%@include file="header2.jsp"%>

<body onload="navload(3);">
	<%
		String insert = (String)request.getParameter("modify");
	%>

	<main class="container" role="main">

	<div class="bookingRoom jumbotron">
		<table class="table">
			<thead>
				<tr>
					<th>会议主题</th>
					<th>会议室</th>
					<th>起始时间</th>
					<th>结束时间</th>
					<th>会议说明</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Meeting> bookingList = (List<Meeting>)request.getAttribute("bookingList");
					if(bookingList != null){
						for(int i = 0; i< bookingList.size(); i++){
							Meeting meeting = bookingList.get(i);
				%>
				<tr>
					<td id="topic<%=i%>"><%=meeting.getTopic()%></td>
					<td id="roomname<%=i%>"><%=meeting.getRoomname()%></td>
					<td id="starttime<%=i%>"><%=meeting.getStarttime()%></td>
					<td id="endtime<%=i%>"><%=meeting.getEndtime()%></td>
					<td id="detail<%=i%>"><%=meeting.getDetail()%></td>
					<td class="text-center">
					<a href="#modify"
						class="btn btn-default" data-toggle="modal"
						onclick="modify('<%=i%>',<%=meeting.getId()%>)">修改</a> 
					<a href="#apply" class="btn btn-default" data-toggle="modal"
						onclick="apply('<%=meeting.getId()%>',)">设备</a> 
					<a	href="#summary" class="btn btn-default" data-toggle="modal"
						onclick="summary(<%=meeting.getId()%>)">总结</a>
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

	<!-- 修改对话框开始 -->
	<div id="modify" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title text-center">信息更改</h4>
				</div>
				<div class="modal-body" method="post" action="MyBookingServlet">
					<form class="form-horizontal" method="post"
						action="MyBookingServlet">
						<div class="form-group">
							<label for="meetingTopic" class="control-label col-md-2">会议编号</label>
							<div class="col-md-10">
								<input id="meetingId" name="meetingId" class="form-control"
									readonly="true" />
							</div>
						</div>
						<div class="form-group">
							<label for="meetingTopic" class="control-label col-md-2">会议主题</label>
							<div class="col-md-10">
								<input type="text" id="meetingTopic" name="topic"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="meetingRoom" class="control-label col-md-2">会议室</label>
							<div class="col-md-10">
								<input type="text" id="meetingRoom" name="room"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="startTime" class="col-md-2 control-label">起始时间</label>
							<div class="col-md-4">
								<input type="date" id="startDate" name="startDate"
									class="form-control" readonly="true" />
							</div>
							<div class="col-md-4">
								<input type="time" id="startTime" name="startTime"
									class="form-control" readonly="true" />
							</div>
						</div>
						<div class="form-group">
							<label for="endTime" class="col-md-2 control-label">结束时间</label>
							<div class="col-md-4">
								<input type="date" id="endDate" name="endDate"
									class="form-control" readonly="true" />
							</div>
							<div class="col-md-4">
								<input type="time" id="endTime" name="endTime"
									class="form-control" readonly="true" />
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="control-label col-md-2">变更说明</label>
							<div class="col-md-10">
								<input type="text" id="detail" name="detail"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-5">
								<button type="submit" class="btn btn-default">确定</button>
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

	<!-- 设备申请对话框开始 -->
	<div id="apply" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title text-center">设备申请</h4>
				</div>
				<div class="modal-body" method="post" action="MyBookingServlet">
					<form class="form-horizontal" method="post"
						action="MyBookingServlet?apply=1">
						<div class="form-group">
							<label for="meetingTopic" class="control-label col-md-2">会议编号</label>
							<div class="col-md-10">
								<input id="meetingIdEquit" name="meetingId" class="form-control"
									readonly="true" />
							</div>
						</div>
						<div class="form-group">
							<label for="meetingTopic" class="control-label col-md-2">设备A数量</label>
							<div class="col-md-10">
								<input type="text" id="equitmentA" name="equitmentA"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="meetingRoom" class="control-label col-md-2">设备B数量</label>
							<div class="col-md-10">
								<input type="text" id="equitmentB" name="equitmentB"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="description" class="control-label col-md-2">设备C数量</label>
							<div class="col-md-10">
								<input type="text" id="equitmentC" name="equitmentC"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-5">
								<button type="submit" class="btn btn-default">确定</button>
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
	<!-- 设备申请对话框结束 -->

	<!-- 提交总结对话框开始 -->
	<div id="summary" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title text-center">提交总结</h4>
				</div>
				<div class="modal-body" method="post" action="Servlet">
					<form class="form-horizontal" method="post"
						action="MyBookingServlet?submit=1">
						<div class="form-group">
							<label for="meetingTopic" class="control-label col-md-2">会议编号</label>
							<div class="col-md-10">
								<input id="meetingIdSummary" name="meetingId" class="form-control"
									readonly="true" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2" for="textarea">总结</label>
							<div class="col-md-10">
								<textarea class="input-xlarge form-control" name="summaryText" rows="3"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-5">
								<button type="submit" class="btn btn-default">确定</button>
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
	<!-- 提交总结对话框结束 -->
	


	<%@include file="footer.html"%>
	<script type="text/javascript">
var insert = <%=insert%>;

if(insert != null){
	if(insert=='1'){
		bootbox.alert("修改成功");
	}else if(insert=='2'){
		bootbox.alert("修改失败");
	}else if(insert=="3"){
		bootbox.alert("申请成功");
	}else if(insert=="4"){
		bootbox.alert("申请失败");
	}else if(insert=="5"){
		bootbox.alert("提交成功");
	}else if(insert=="6"){
		bootbox.alert("提交失败");
	}
}

titleLoad("我的预订");

function modify(index, meetingId){
	var topic = document.getElementById("topic"+index).innerText;
	var roomname = document.getElementById("roomname"+index).innerText;
	var startDate = document.getElementById("starttime"+index).innerText.split(' ')[0];
	var startTime = document.getElementById("starttime"+index).innerText.split(' ')[1].split('.')[0];
	var endDate = document.getElementById("endtime"+index).innerText.split(' ')[0];
	var endTime = document.getElementById("endtime"+index).innerText.split(' ')[1].split('.')[0];
	var detail = document.getElementById("detail"+index).innerText;

	document.getElementById("meetingId").setAttribute("value", meetingId);
	document.getElementById("meetingTopic").setAttribute("value", topic);
	document.getElementById("meetingRoom").setAttribute("value", roomname);
	document.getElementById("startDate").setAttribute("value", startDate);
	document.getElementById("startTime").setAttribute("value", startTime);
	document.getElementById("endDate").setAttribute("value", endDate);
	document.getElementById("endTime").setAttribute("value", endTime);
	document.getElementById("detail").setAttribute("value", detail);
}

function apply(meetingId){
	document.getElementById("meetingIdEquit").setAttribute("value", meetingId);
}

function summary(meetingId){
	document.getElementById("meetingIdSummary").setAttribute("value", meetingId);
}

</script>

</body>
</html>