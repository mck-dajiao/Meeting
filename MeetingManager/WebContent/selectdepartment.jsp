<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.soft.meetmanager.model.Department"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
 <link rel="stylesheet" href="styles/common03.css"/>
</head>
    <body>
    
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                   <%List list=(List)request.getAttribute("list"); 
                   for(int i=0;i<list.size();i++){
                      Department depm=(Department)list.get(i); %>
                       <tr>
                        <td><%=depm.getDepartmentid() %></td>
                        <td><%=depm.getDepartmentname() %></td>
                        <td>
                            <a class="clickbutton" href="#">编辑</a>
                            <a class="clickbutton" href="#">删除</a>
                        </td>
                    </tr>
                  <% }
                   %>
                    </tr>
                </table>
            </div>
        </div>
        
    </body>
</html>