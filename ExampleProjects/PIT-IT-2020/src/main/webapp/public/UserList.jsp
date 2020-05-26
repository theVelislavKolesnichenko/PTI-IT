<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bg.tu.varna.sit.beans.UserBean" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="bg.tu.varna.sit.repositories.Repository" %>
<!DOCTYPE html>
<html>
<jsp:include page="../shared/head.jsp"/>
<body>
	<jsp:include page="../shared/header.jsp"/>
	<%
		Repository repo = Repository.getInstance();
	%>
	<div class="p-20 c-blue">
		<table>
		  <tr>
		    <th>Потребител</th>
		    <th>Работа</th>
		    <th>Информация</th>
		  </tr>
		  <%for(UserBean user : repo.getUsers()){ %>
		  <tr>
		    <td><a href="user?id=<%= user.getId() %>"><%= user.getName() %></а></td>
		    <td><%= user.getJobTitle() %></td>
		    <td><%= user.getInfo() %></td>
		  </tr>
		  <%} %>
		</table>
	</div>
	<jsp:include page="../shared/footer.jsp"/>
</body>
</html>