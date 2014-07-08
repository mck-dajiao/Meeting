<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List,com.dajiao.model.MeetingRoom"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@include file="header.jsp" %>
<%@include file="adminNavbar.html" %>
<%@include file="header2.jsp" %>

<body onload="navload(4);">

<main class="container" role="main">

    <!-- 搜索表单开始 -->
	<div class="container jumbotron">
        <form method="post" action="AdSearchRoomServlet?search=1">
            <div class="form-inline">
				<label class="control-label">会议室状态</label>
                <div class="form-group">
					<select class="form-control" name="status">
						<option value="close">关闭</option>
						<option value="open" seleted>启用</option>
					</select>
				</div>
				
                <div class="form-group col-md-offset-1">
                    <button type="submit" class="btn btn-primary">查询</button>
                </div>
            </div>
        </form>
    </div>
    <!-- 搜索表单结束 -->

	<!-- 查询结果开始 -->
    <div class="container text-center jumbotron">
        <table class="table table-striped table-bordered" id="table">
            <thead>
                <tr>
                    <th class="text-center">会议室编号</th>
                    <th class="text-center">会议室名称</th>
                    <th class="text-center">容纳人数</th>
                    <th class="text-center">当前状态</th>
					<th class="text-center">操作</th>
                </tr>
            </thead>
            <tbody>
            <%
            	List<MeetingRoom> roomList = (List<MeetingRoom>)request.getAttribute("roomList");
            	if(roomList != null){
            		for(int i = 0;i<roomList.size();i++){
            			MeetingRoom room = roomList.get(i);
            %>

                <tr id="tr<%=i%>">
                    <td><%=room.getId() %></td>
                    <td><%=room.getName() %></td>
                    <td><%=room.getTotal() %></td>
                    <td><%=room.getStatus() %></td>
                    <td class="text-center">
						<a href="#modify" class="btn btn-default" data-toggle="modal" onclick="addInfo('<%=i%>')">修改</a>
						<a href="#" class="btn btn-default" onclick="deleteRoom('<%=i%>', '<%=room.getId()%>')">删除</a>
                    </td>
                </tr>
             <%
            			
            		}
            	}
             %>
            </tbody>
        </table>
    </div>
	<!-- 查询结果结束 -->
	
	<!-- 添加修改对话框开始 -->
    <div id="modify" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title text-center">会议室信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="post" action="AdSearchRoomServlet?modify=1">
                        <div class="form-group">
                            <label for="username" class="control-label col-md-3">会议室编号：</label>
                            <div class="col-md-9">
                                <input type="text" name="roomId" id="roomId" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="control-label col-md-3">会议室名称：</label>
                            <div class="col-md-9">
                                <input type="text" name="name" id="name" class="form-control" />
                            </div>
                        </div>
						<div class="form-group">
                            <label for="password" class="control-label col-md-3">容纳人数：</label>
                            <div class="col-md-9">
                                <input type="text" name="capacity" id="capacity" class="form-control" />
                            </div>
                        </div>
						<div class="form-group">
                            <label for="password" class="control-label col-md-3">当前状态：</label>
                            <div class="col-md-9">
                                <input type="text" name="status" id="status" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-2 text-center">
                                <button type="submit" class="btn btn-default">确认</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- 添加修改对话框结束 -->
    
    <div class="text-right" >
        <a href="#new" class="btn btn-primary btn-sm" onclick="document.getElementById('deleteForm').submit();"><h3>完成</h3></a>
    </div>
</main>
<form id="deleteForm" method="post" action="AdSearchRoomServlet?delete=1">
</form>

<%@include file="footer.html" %>
<script type="text/javascript">
titleLoad("会议室管理");

function deleteRoom(index, roomId){
	document.getElementById('table').children[1].removeChild(document.getElementById('tr'+index));
	var deleteForm = document.getElementById('deleteForm');
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "roomId");
	input.setAttribute("value", roomId);
	
	deleteForm.appendChild(input);
}

function addInfo(index){
	var trElement = document.getElementById('tr'+index);
	document.getElementById('roomId').setAttribute('value', trElement.children[0].innerText);
	document.getElementById('name').setAttribute('value', trElement.children[1].innerText);
	document.getElementById('capacity').setAttribute('value', trElement.children[2].innerText);
	document.getElementById('status').setAttribute('value', trElement.children[3].innerText);
}

</script>

</body>
</html>