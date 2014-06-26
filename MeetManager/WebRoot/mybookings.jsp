<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.soft.meetmanager.model.Meeting"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html";charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common03.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 我的预定
                </div>
                <table class="listtable">
                    <caption>我预定的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>操作</th>
                    </tr>
                    <%List list=(List)request.getAttribute("list");
                     for(int i=0;i<list.size();i++){
                       Meeting meeting=(Meeting) list.get(i);     
                %>
                    <tr>
                        <td><%=meeting.getMeetingname() %></td>
                        <td><%=meeting.getRoomname() %></td>
                        <td><%=meeting.getStarttime() %></td>
                        <td><%=meeting.getEndtime() %></td>
                        <td><%=meeting.getReservationtime() %></td>
                        <td><%=meeting.getMeetingid()%>
                            <a class="clickbutton" href="CancelServlet?mtid=<%=meeting.getMeetingid()%>">撤销</a>
                        </td>
                    </tr>
                    <%} %>
                </table>
            </div>
        </div>
       
    </body>
</html>