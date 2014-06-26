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
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
       
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > <a href="notifications">最新通知</a>
                </div>
                <table class="listtable">
                    <caption>
                        未来7天我要参加的会议:
                    </caption>
                    <tr class="listheader">
                        <th style="width:300px">会议名称</th>
                        <th>会议室</th>
                        <th>起始时间</th>
                        <th>结束时间</th>
                        <th style="width:100px">操作</th>
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
                        <td>
                            <a class="clickbutton" href="meetingdetails.jsp">查看详情</a>
                        </td>
                    </tr>
                    <%} %>
                </table>
                
            </div>
        </div>
        
    </body>
</html>