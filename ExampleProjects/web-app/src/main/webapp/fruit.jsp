<%@page import="bg.tu_varna.sit.web_app.modes.Fruit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Fruit fruit = (Fruit) request.getAttribute("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruit page</title>
</head>
<body>

<form action="fruit" method="post" class="extraction_fruit" >
<input type="hidden" name="name" value="<%=fruit.getName() %>">
<table>
	<tr>
		<td>Fruit</td>
		<td>Type</td>
		<td>Count</td>
	</tr>
	<tr>
		<td><%=fruit.getName() %></td>
		<td><%=fruit.getType() %></td>
		<td><input id="count" type="number" name="count" value="<%= fruit.getCount() %>" ></td>
	</tr>
	</table>
	<input type="submit" value="Submit">
</form>

</body>
</html>