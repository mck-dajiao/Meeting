<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List,com.dajiao.model.Meeting,com.dajiao.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@include file="header.jsp" %>
<%@include file="adminNavbar.html" %>
<%@include file="header2.jsp" %>

<body onload="navload(1);">

<main class="container" role="main">
	<div class="container jumbotron">
        <table class="table text-center" id="table">
            <thead>
                <tr>
                    <th class="text-center">姓名</th>
                    <th class="text-center">编号</th>
                    <th class="text-center">部门</th>
					<th class="text-center">暗号</th>
                </tr>
            </thead>
            <tbody>
            <%
            	List<User> userList = (List<User>)request.getAttribute("userList");
            	if(userList != null){
            		for(int i = 0; i<userList.size(); i++){
            			User user = userList.get(i);
            %>

                <tr id="tr<%=i%>">
                    <td><%=user.getName() %></td>
                    <td><%=user.getId() %></td>
					<td><%=user.getDepartment() %></td>
					<td><%=user.getAnhao() %></td>
                    <td class="text-center">
                        <a href="#" class="btn btn-default" onclick="doAction(<%=i%>,'<%=user.getaccount() %>','agree');">通过</a>
						<a href="#" class="btn btn-default" onclick="doAction(<%=i%>,'<%=user.getaccount() %>','disagree');">拒绝</a>
                    </td>
                </tr>
            <%
            		}
            	}
            %>
            </tbody>
        </table>
    </div>
    <div style="float: right; padding: 5px">
		<a href="#" class="btn btn-primary btn-sm"
			onclick="document.getElementById('submitForm').submit();">完成</a>
	</div>
    
    <!-- 隐藏提交表单 -->
    <form id="submitForm" method="post" action="AdApprovalServlet?submit=1">
    </form>
</main>


<%@include file="footer.html" %>
<script type="text/javascript">
titleLoad("注册审批");
function doAction(index, userAccount, name){
	document.getElementById('table').children[1].removeChild(document.getElementById('tr'+index));
	var submitForm = document.getElementById('submitForm');
	var input = document.createElement("input");
	var id = submitForm.childElementCount + 1;
	input.setAttribute("type", "hidden");
	input.setAttribute("name", name);
	input.setAttribute("value", userAccount);
	
	submitForm.appendChild(input);
}

</script>

</body>
</html>