
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.soft.meetmanager.model.MeetingRoom"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html";charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common03.css"/>
    </head>
    <body>
        
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 查看会议室
                </div>
            
                <table class="listtable">
                    <caption>所有会议室:</caption>
                    <tr class="listheader">
                        <th>门牌编号</th>
                        <th>会议室名称</th>
                        <th>容纳人数</th>
                        <th>当前状态</th>
                        <th>操作</th>
                    </tr>
                     <%   List list=(List)request.getAttribute("list");
                     for(int i=0;i<list.size();i++){
                       MeetingRoom meetingroom=(MeetingRoom) list.get(i);     
                %>
                    <tr>
                    <td><%=meetingroom.getRoomcode()%></td>
                    <td><%=meetingroom.getRoomname() %></td>
                    <td><%=meetingroom.getCapacity() %></td>
                    <td><%=meetingroom.getStatus() %></td>
                    <td>
                      <a class="clickbutton" href="MeetingDetailServlet?roomcode=<%=meetingroom.getRoomcode()%>">查看详情</a>
                    <%} %></td>
                    </tr>
                </table>
         
            </div>
        </div>
       
    </body>
</html>