<%@ page language="java" import="com.soft.meetmanager.model.Employee" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%List list =(List)request.getAttribute("listfy"); 
Integer pageSum = (Integer)request.getAttribute("pagesum");
Integer pageNow = (Integer)request.getAttribute("pagenow");
Integer listSum = (Integer)request.getAttribute("listsum");
String username = (String)request.getAttribute("usernamek");
String empname = (String)request.getAttribute("empnamek");
%>
 
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
       <form action="SearchemployeeServlet" method="post">
            <div class="page-content">
                <div class="content-nav"> 
                    p会议预定 &gt; 搜索员工 
                </div>
                 <input type="hidden" value="1" name="pageNow" />
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                        
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" id="employeename" name="employeename1"maxlength="20"/>
                                </td>
                                <td>账号名：</td>
                                <td>
                                    <input type="text" id="accountname" name="username1"maxlength="20"/>
                                </td>
                                <!--  
                                <td>状态：</td>
                                <td>
                                    <input type="radio" id="status" name="status1" value="已审批" checked="checked"/><label>已审批</label>
                                    <input type="radio" id="status" name="status1" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status1" value="-1"/><label>已关闭</label>
                                </td>-->
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table></form>
	<%if(list != null){ %>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number"><%=listSum %></span>条结果，
                            分成<span class="info-number"><%=pageSum %></span>页显示，
                            当前第<span class="info-number"><%=pageNow %></span>页
                        </div>
                        <div class="header-nav">
                        	<a href="SearchemployeeServlet?pageNow=1&username1=<%=username%>&employeename1=<%=empname%>">首页</a>
                        	<%if(pageNow != 1){ %>
                        	<a href="SearchemployeeServlet?pageNow=<%=pageNow-1%>&username1=<%=username%>&employeename1=<%=empname%>">上页</a>
                        	<%} %>
                        	<%if(pageNow != pageSum){ %>
                        	<a href="SearchemployeeServlet?pageNow=<%=pageNow+1%>&username1=<%=username%>&employeename1=<%=empname%>">下页</a>
                        	<%} %>
                        	<a href="SearchemployeeServlet?pageNow=<%=pageSum%>&username1=<%=username%>&employeename1=<%=empname%>">末页</a>
                          
                            跳到第<input type="text" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" value="跳转"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <%
                    if(list!=null){
                     for(int i=0;i<list.size();i++){
                       Employee emp=(Employee) list.get(i);     
                %>
                    <tr>
                        <td><%=emp.getEmployeename()%></td>
                        <td>tomcat</td>
                        <td><%=emp.getPhone() %></td>
                        <td><%=emp.getEmail()%></td>
                        <td>
                            <a class="clickbutton" href="#">关闭账号</a>
                        </td>
                    </tr>  
                    <% 
                    
                   } }}%>  
                </table>
            </div>
       
        
    </body>
</html>