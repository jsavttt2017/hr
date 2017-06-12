<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#sendBut").on("click",function(){
    			var msgValue = $("#msg").val();
    			$.post("EchoServlet",{"msg": msgValue,"eid":100},function(data){
    				$("#contentDiv").append("<p>姓名:" + data.members[0].name + ", 年龄：" + data.members[0].age + "<p>")},"json");
    		});
    	});
    </script>
  </head>
  
  <body>
    <div>
    	<input type="text" name="msg" id="msg">
    	<input type="button" id="sendBut" value="提交">
    </div>
    <div id="contentDiv"></div>
  </body>
</html>
