<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Correct operation</title>
</head>
<body>
	<h1><%=request.getAttribute("successMessage") %></h1>
	<a href="index.jsp" >back to main interface</a>
</body>
</html>