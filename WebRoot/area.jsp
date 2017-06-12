<%@page import="cn.mldn.service.Factory.ServiceFactory"%>
<%@page import="cn.mldn.vo.Area"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>级联菜单</title>
    <script type="text/javascript" src="js/area.js"></script>
  </head>
  <body>
  <div>
  		省份：<select id="aid">
  		<option value="0">====== 请选择所在省份 ======</option>
	  <%
	  	List<Area> all = (List<Area>) request.getAttribute("allAreas");
	  	Iterator<Area> iter = all.iterator();
	  	while(iter.hasNext()){
	  		Area vo = iter.next();
	  %>
	  	<option value="<%=vo.getAid()%>"><%=vo.getTitle()%></option>
	  <%
	  	}
	  %>
    </select>
          城市：<select id="apid">
    		<option value="0">====== 请选择所在城市 ======</option>
    	</select>
  </div>
  </body>
</html>
