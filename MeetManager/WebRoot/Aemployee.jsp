<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.soft.meetmanager.model.Employee"%>
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
                       待审批员工
                </div>
                <table class="listtable">
                    <caption>我要审批的员工：</caption>
                    <tr class="listheader">
                        <th>员工姓名</th>
                        <th>联系方式</th>
                        <th>账号名</th>
                        <th>操作</th>
                    </tr>
                    <%List list=(List)request.getAttribute("listfor");
                    if(list != null){
                     for(int i=0;i<list.size();i++){
                       Employee emp=(Employee) list.get(i);     
                %>
                    <tr>
                        <td><%=emp.getEmployeename() %></td>
                        <td><%=emp.getPhone() %></td>
                       <td><%=emp.getUsername() %></td>
                        <td>
                            <a class="clickbutton" href="ShenpiServlet?empid=<%=emp.getEmployeeid()%>">批准</a>
                        </td>
                    </tr>
                    <%} }%>
                </table>
            </div>
        </div>
       
    </body>
</html>