<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List,com.dajiao.model.Meeting"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@include file="header.jsp" %>
<%@include file="navbar.html" %>
<%@include file="header2.jsp" %>

<body onload="navload(2);">

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
                </tr>
            </thead>
            <tbody>
            <%
            	List<Meeting> meetingList = (List<Meeting>)request.getAttribute("meetingList");
            	if(meetingList != null){
            		for(int i = 0;i<meetingList.size();i++){
            			Meeting meeting = meetingList.get(i);
            %>

                <tr>
                    <td><%=meeting.getTopic() %></td>
                    <td><%=meeting.getRoomname() %></td>
                    <td><%=meeting.getStarttime() %></td>
                    <td><%=meeting.getEndtime() %></td>
                    <td><%=meeting.getDetail() %></td>
                </tr>
             <%
            			
            		}
            	}
             %>
            </tbody>
        </table>

    </div>

</main>

<%@include file="footer.html" %>
<script type="text/javascript">
titleLoad("我的会议");
</script>

</body>
</html>