<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>æ æ é¢ææ¡£</title>
<link rel="stylesheet" type="text/css" href="styles/common02.css"/>
</head>

<body>
             <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="NotificationsServlet?empid=123" target="main">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybookings.jsp" target="main">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="mymeetings.jsp" target="main" >我的会议</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="departments.jsp"  target="main">部门管理</a></li>
                        <li class="sidebar-menuitem"><a href="" target="main">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="searchemployees"" target="main">搜索员工</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="addmeetingroom.jsp" target="main">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a href="/MeetManager/SelectMeetingServlet?methodCode=selectmeet"target="main">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="BookMeetingServlet"target="main">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.jsp"target="main">搜索会议</a></li>
                    </ul>
                </div>
            </div>


</body>
</html>
