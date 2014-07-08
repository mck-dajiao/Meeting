<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List,com.dajiao.model.Meeting,com.dajiao.model.Department"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@include file="header.jsp" %>
<%@include file="adminNavbar.html" %>
<%@include file="header2.jsp" %>

<body onload="navload(3);">

<main class="container" role="main">

	<div class="container jumbotron">
				
        <table class="table text-center" id="table">


            <thead>
                <tr>
                    <th class="text-center">部门编号</th>
                    <th class="text-center">部门名称</th>
                    <th class="text-center">操作</th>
                </tr>
            </thead>
            <tbody>
            	<%
            		List<Department> departmentList = (List<Department>)request.getAttribute("departmentList");
            		if(departmentList != null){
            			for(int i = 0; i<departmentList.size(); i++){
            				Department department = departmentList.get(i);
            	%>
                <tr id="tr<%=i%>">
                    <td><%=department.getId() %></td>
                    <td><%=department.getName() %></td>
                    <td class="text-center">
						<a href="#" class="btn btn-default" onclick="deleteDep('<%=i%>', '<%=department.getId()%>')">删除</a>
                    </td>
                </tr>
               	<%
            			}
            		}
            	%>
            </tbody>
        </table>
		    <div class="text-right" >
        <a href="#new" class="btn btn-primary btn-sm"  data-toggle="modal" ><h3>添加部门</h3></a>
    </div>
    <div class="text-right" >
        <a href="#new" class="btn btn-primary btn-sm" onclick="document.getElementById('deleteForm').submit();"><h3>完成</h3></a>
    </div>
    </div>
</main>

	<!-- 添加对话框开始 -->
    <div id="new" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title text-center">新部门信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="post" action="AdDepartmentServlet?new=1">
                        <div class="form-group">
                            <label for="username" class="control-label col-md-3">部门编号：</label>
                            <div class="col-md-9">
                                <input type="text" name="departmentId" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="control-label col-md-3">部门名称：</label>
                            <div class="col-md-9">
                                <input type="text" name="name" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-2 text-center">
                                <button type="submit" class="btn btn-default" >确认</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- 添加对话框结束 -->
	
	<form id="deleteForm" method="post" action="AdDepartmentServlet?delete=1">
	</form>


<%@include file="footer.html" %>
<script type="text/javascript">
titleLoad("部门管理");

function deleteDep(index, departmentId){
	document.getElementById('table').children[1].removeChild(document.getElementById('tr'+index));
	var deleteForm = document.getElementById('deleteForm');
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "departmentId");
	input.setAttribute("value", departmentId);
	
	deleteForm.appendChild(input);
}
</script>

		

</body>
</html>