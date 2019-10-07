<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome to insert the student's information</title>
</head>
<body>
<h3>Please enter your course and exam status</h3>
	<form method="post" action="insert">
	<table border="1" style="width:200px; high:140px">
				<tr>
					<td>ID:</td>
					<td><input type="text" name="id" placeholder="your ID" required /></td>
				</tr>
				<tr>
					<td>name:</td>
					<td><input type="text" name="name" placeholder="your name" required/></td>
				</tr>
				<tr>
					<td>
					<select id="course1" name="course1">
						<option value="math">math</option>
						<option value="eng">eng</option>
						<option value="sport">sport</option>
						<option value="chinese">chinese</option>
					</select></td>
					<td><input type="text" name="course1_score" placeholder="your course1'score" required/></td>
				</tr>
				<tr> 
					<td><select id="course2" name="course2">
						<option value="math">math</option>
						<option value="eng">eng</option>
						<option value="sport">sport</option>
						<option value="chinese">chinese</option>
					</select></td>
					<td><input type="text" name="course2_score" placeholder="your course2'score" required/></td>
				</tr>
			</table>
			<button type="submit"> ok  </button>	
			<button type="reset" >canel</button>
		</table>
	</form>
</body>
</html>