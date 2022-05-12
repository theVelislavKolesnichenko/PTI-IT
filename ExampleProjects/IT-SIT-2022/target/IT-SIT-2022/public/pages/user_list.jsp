<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sit.tu_varna.bg.models.User" %>
<%@ page import="sit.tu_varna.bg.repositories.Repository" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<jsp:include page="../shared/head.jsp"/>
<body>
<jsp:include page="../shared/header.jsp"/>
<%
    //Repository repo = Repository.getInstance();
    //Set<User> users = repo.getUsers();

    Set<User> users = (Set<User>) request.getAttribute("users");

%>
<div class="p-20 c-blue">
    <table>
        <tr>
            <th>Потребител</th>
            <th>Работа</th>
            <th>Информация</th>
        </tr>
        <%for(User user : users){ %>
        <tr>
            <td><a href="user?username=<%= user.getLogin().getUsername() %>"><%= user.getName() %></а></td>
            <td><%= user.getJobTitle() %></td>
            <td><%= user.getInfo() %></td>
        </tr>
        <%} %>
    </table>
</div>
<jsp:include page="../shared/footer.jsp"/>
</body>
</html>