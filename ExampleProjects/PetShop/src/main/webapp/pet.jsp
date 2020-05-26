<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bg.tu_varna.sit.petshop.models.Pet" %>
    <%
    	Pet pet = (Pet) request.getAttribute("pet");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<h1>Pet Shop</h1>
		<form action="pet" method="post">
		<input type="hidden" name="name" value="<%=pet.getName() %>">
			<table>
				<tr>
					<td>Pet</td>
					<td>Type</td>
					<td>Cout</td>
				</tr>
				<tr>
					<td><%=pet.getName() %></td>
					<td><%=pet.getType() %></td>
					<td>
						<input type="number" name="count" value="<%=pet.getCount() %>">
					</td>
				</tr>
			</table>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>