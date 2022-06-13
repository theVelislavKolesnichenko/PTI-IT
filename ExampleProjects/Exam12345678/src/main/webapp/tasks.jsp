<%@ page import="models.Task" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String message = (String) request.getAttribute("message");
    Set<Task> taskSet = (Set<Task>) request.getAttribute("tasks");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <% if (message != null) { %>
        <% if (message.equals("massage_1")) { %>
            Изтекло време за запис! Опитайте отново
        <% } else { %>
            Неоторизиран достъп, презаредете страницата
            <a href="<% request.getContextPath(); %>">Презареди</a>
        <% } %>
    <% } %>
</div>

<form action="<% request.getContextPath(); %>" method="post">
    <input type="text" name="title" value="Task 1" />
    <br/>
    <textarea name="description">
        Task 1 Description
    </textarea>
    <br/>
    <input type="date" name="day" value="2022-06-13" />
    <br/>
    <input type="submit" value="Save" />
</form>

<table>
    <tr>
        <td>Title</td>
        <td>Description</td>
        <td>Date</td>
    </tr>

    <% for (Task task : taskSet) { %>
        <tr>
            <td><%= task.getTitle() %></td>
            <td><%= task.getDescription() %></td>
            <td><%= task.getDate() %></td>
        </tr>
    <% } %>

</table>

</body>
</html>
