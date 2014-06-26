<%@ page language="java" import="com.soft.meetmanager.model.MeetingRoom" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%MeetingRoom mt = (MeetingRoom)request.getAttribute("roomdetail"); %>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html";charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
     <form action="UpdateMeetroomServlet" method="post">
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 修改会议室信息
                </div>
                <form>
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <input id="roomnumber" name="roomcode" type="text" value="${roomdetail.roomcode}" maxlength="10"/>
                              	<input type="hidden" name="roomid" value="${roomdetail.roomid }" />
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input  name="roomname" type="text" value="${roomdetail.roomname}" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input  name="roomcapacity" type="text" value="${roomdetail.capacity}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                                <td>
                                 <%if(mt.getStatus().equals("使用中")){ %>
                                 <div>
                                    <input type="radio"  id="status1" name="status"value="空闲"/><label for="status">空闲</label>
                                    <input type="radio"  id="status2"  checked="checked"  name="status"value="使用中" /><label for="status" value="0">使用中</label>
                                    <input type="radio" id="status3" name="status"/><label for="status" >已删除</label>
                                    </div>
                                    <%} %>
                                    <%if(mt.getStatus().equals("空闲")){ %>
                                    <div>
                                    <input type="radio"  id="status1" name="status" checked="checked" value="空闲"/><label for="status">空闲</label>
                                    <input type="radio"  id="status2" name="status"value="使用中"/><label for="status" >使用中</label>
                                    <input type="radio" id="status3" name="status"value="已删除"/><label for="status" value="已删除">已删除</label>
                                    </div>
                                    <%} %>
                                     <%if(mt.getStatus().equals("已删除")){ %>
                                    <div>
                                    <input type="radio"  id="status1" name="status" value="空闲"/><label for="status">空闲</label>
                                    <input type="radio"  id="status2" name="status" value="使用中"/><label for="status" value="0">使用中</label>
                                    <input type="radio" id="status3"  checked="checked" value="已删除" name="status"/><label for="status" value="-1">已删除</label>
                                    </div><%} %>
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea id="description" name="description" maxlength="200" rows="5" cols="60"  >${roomdetail.description}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" class="clickbutton"/>
                                    <input type="button" class="clickbutton" value="返回"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        </form>
    </body>
</html>