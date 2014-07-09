<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List,com.dajiao.model.MeetingRoom"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@include file="header.jsp" %>
<%@include file="navbar.html" %>
<%@include file="header2.jsp" %>
<%
	String success = (String)request.getParameter("success");
%>

<body onload="navload(1);">

<main class="container" role="main">
                    
	<div class="bookingRoom jumbotron">
    <!-- 搜索表单开始 -->
    <div class="container">
        <form method="post" action="BookingRoomServlet?search=1">
            <div class="form-inline">
				<label class="control-label">起始时间:</label>
                <div class="form-group">
                    <input type="date" placeholder="起始时间日期" name="startdate" class="form-control" />
                </div>
				<div class="form-group">
                    <input type="time" placeholder="起始时间" name="starttime" class="form-control" />
                </div>
				<label class="control-label col-md-offset-1">结束时间:</label>
				<div class="form-group">
                    <input type="date" placeholder="结束时间日期" name="enddate" class="form-control" />
                </div>
				<div class="form-group">
                    <input type="time" placeholder="结束时间" name="endtime" class="form-control" />
                </div>
                <div class="form-group col-md-offset-1">
                    <button type="submit" class="btn btn-primary" >查询</button>
                </div>
            </div>
        </form>
    </div>
    <!-- 搜索表单结束 -->
	
	</div>

    <div class="text-center jumbotron">
        <table class="table">
            <caption>
            </caption>
            <thead>
                <tr>
                    <th class="text-center" >会议室</th>
                    <th class="text-center" >说明</th>
                    <th class="text-center" >操作</th>
                </tr>
            </thead>
            <tbody>
            <%
            	List<MeetingRoom> roomList = (List<MeetingRoom>)request.getAttribute("roomList");
            if(roomList != null){
            	for(int i = 0;i<roomList.size();i++){
            		MeetingRoom room = roomList.get(i);
            %>
                <tr>
                    <td><%=room.getName() %></td>
                    <td><%=room.getType() %></td>
                    <td class="text-center">
                        <a href="#booking" class="btn btn-default" data-toggle="modal" onclick="addRoomId('<%=room.getId()%>');">预约</a>
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

<!-- 预约对话框开始 -->
    <div id="booking" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title text-center">预约会议室</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="username" class="control-label col-md-2">会议主题</label>
                            <div class="col-md-10">
                                <input type="text" id="meetingTopic" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="text-center">
                                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="bookingSubmit();">预约</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <!-- 预约对话框结束 -->

	<form id="bookingForm" name="bookingForm" method="post" action="BookingRoomServlet"> 
		<input type="hidden" id="topic" name="topic" />
		<input type="hidden" id="meetingRoom" name="meetingRoom" />
	</form>

<%@include file="footer.html" %>
<script type="text/javascript">
titleLoad("预约会议");

var success = '<%=success%>';
if(success.equals("1")){
	bootbox.alert("预订成功！");
}

function addRoomId(id){
	document.getElementById('meetingRoom').setAttribute("value", id);
}
function bookingSubmit(){
	var topic = document.getElementById('meetingTopic').value;
	document.getElementById('topic').setAttribute('value',topic);
	var form = document.getElementById('bookingForm');
	form.submit();
}
</script>

</body>
</html>