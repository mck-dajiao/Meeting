<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
    <head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>

    <body>
	<%@include file="02.jsp" %>
    
    
            <div class="page-content">
                <div class="content-nav">
                    登录
                </div>
                <form action="LoginServlet" method="post">
                    <fieldset>
                        <legend>登录信息</legend>
                    
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>账号名:</td>
                                <td>
                                    <input id="accountname" name="usename"type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td>
                                    <input id="new" name="pwd" type="password" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="登录" class="clickbutton" onclick="window.location.href='notifiactions.html';"/>
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                                     <input type="button" value="注册" class="clickbutton" onclick="window.location.href='register.jsp';"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        
        
    </body>
</html>