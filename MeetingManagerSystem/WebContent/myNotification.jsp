<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.sql.Timestamp,java.util.List,com.dajiao.model.Notification"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
	String str=(String)request.getAttribute("notinum"); 
	int notinum=Integer.parseInt(str);
%>

</head>
<%@include file="header.jsp" %>
<%@include file="navbar.html" %>
<%@include file="header2.jsp" %>

<body onload="navload(0);">


<div class="panel-group" id="accordion">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h2 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" onclick="badgeDispose(event)" >
         <h3>会议邀请<span class="badge" id="inviteBadge"></span></h3>
        </a>
      </h2>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in">
      <div class="panel-body">
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
             List<Notification> list=(List<Notification>)request.getAttribute("notifyList");
             if(list!=null){
                	for(int i=0;i<list.size();i++){
                    	Notification notify = (Notification)list.get(i);
             %>
                <tr>
                    <td><%=notify.getTopic() %></td>
                    <td><%=notify.getMeetingRoom() %></td>
                    <td><%=notify.getStarttime().toString() %></td>
                    <td><%=notify.getEndtime().toString() %></td>
                    <td><%=notify.getDetail() %></td>
                    <td class="text-center">
                        <a href="#" class="btn btn-default">同意</a>
						<a href="#" class="btn btn-default" onclick="return confirm('确实要忽略该会议吗？');">忽略</a>
                    </td>
                </tr>
               <%
               		} 
                	
             	}
               %>
            </tbody>
        </table>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h2 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
         <h3>会议变更<span class="badge" id="changeBadge" ></span></h3>
        </a>
      </h2>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse">
      <div class="panel-body">
	  <table class="table">
            <thead>
                <tr>
                    <th>会议主题</th>
                    <th>会议室</th>
                    <th>起始时间</th>
					<th>结束时间</th>
                    <th>变更说明</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>软件学院实习相关事项</td>
                    <td>第一会议室</td>
                    <td>12:00</td>
                    <td>13:30</td>
                    <td>院长到时要上厕所</td>
                </tr>
				<tr>
                    <td>毕业晚会</td>
                    <td>第二会议室</td>
                    <td>12:00</td>
                    <td>13:30</td>
                    <td>师兄要把妹，太忙了</td>
                </tr>
            </tbody>
        </table>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h2 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
        <h3>会议总结<span class="badge" id="summaryBadge" ></span></h3>
        </a>
      </h2>
    </div>
    <div id="collapseThree" class="panel-collapse collapse">
      <div class="panel-body">
	  <table class="table">
            <thead>
                <tr>
                    <th>会议主题</th>
                    <th>总结人</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>软件学院实习相关事项</td>
                    <td>程序员</td>
                    <td class="text-center">
                        <a href="#" class="btn btn-default">查看</a>
                    </td>
                </tr>
				<tr>
                    <td>毕业晚会</td>
                    <td>校长</td>
					<td class="text-center">
                        <a href="#" class="btn btn-default">查看</a>
                    </td>
                </tr>
            </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

</main>


<%@include file="footer.html" %>
<script type="text/javascript">
var noti='<%=notinum%>';
addNotify(noti);
titleLoad("查看通知");
</script>

</body>

</html>