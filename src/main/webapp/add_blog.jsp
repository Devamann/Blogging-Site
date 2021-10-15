<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //http 1.1
	response.setHeader("Pragma", "no-cache"); //http1.0
	response.setHeader("Expires", "0"); //proxies
	%>
	<%
	String isvalid = (String) session.getAttribute("Valid");
	if (isvalid == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	%>
	<form action="Add_blog" method="post">
		<input type="text" name="Heading">
		<textarea rows="4" cols="" name="Body"></textarea>
		<input type="submit" value="Add it">
	</form>
	<a href="Log_out">Log-out</a>
</body>

</html>