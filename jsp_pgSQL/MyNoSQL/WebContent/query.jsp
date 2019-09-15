<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Query page</title>
</head>
<body>
	<h3>Please enter the id of the grade you want to query:</h3>
	<div>
		<form action="Query" method="post">
			<input type="test" name="Id" required />
			<button type="submit" >  ok  </button>
			<button type="reset" > canel</button>
		</form>
	</div>
</body>
</html>