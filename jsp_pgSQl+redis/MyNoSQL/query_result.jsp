<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find results</title>
</head>
<body>
	<h3>The ID you want to query  <font color=red><%=request.getAttribute("Id") %></font>  
	<br/>
	And the relevant results of this student</h3>
	<table border="1" style="width:200px; high:140px; padding-left: 10px; padding-right: 10px;">
		<%
			Map<String, Object> map = null;
			map = (HashMap<String, Object>)request.getAttribute("scoreMap");
			for(Map.Entry<String, Object> entry: map.entrySet()){
		%>
			<tr>
				<td><%= entry.getKey() %></td>
				<td><%= entry.getValue()%></td>
			</tr>
		<%
			}
		%>
		<% response.setHeader("refresh", "5;URL=index.jsp");%>
	</table>
</body>
</html>
