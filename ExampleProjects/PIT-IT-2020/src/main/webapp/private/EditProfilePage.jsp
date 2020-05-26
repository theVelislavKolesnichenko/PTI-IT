<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bg.tu.varna.sit.beans.UserBean" %>
<%@ page import="bg.tu.varna.sit.beans.SkillBeen" %>
<%--<jsp:useBean id="user1" type="bg.tu.varna.sit.beans.UserBean" scope="session">
</jsp:useBean>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Success</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="js/main.js"></script>
</head>
<body>
	<jsp:include page="../shared/header.jsp"/>
<%
	UserBean user = (UserBean) session.getAttribute("user");
	//request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
%>
<div class="center">
		<div class="grid">
		<form class="user-info" enctype="application/x-www-form-urlencoded">
			<input type="hidden" name="id" value="<%=user.getId()%>"/>
			<div class="grid-30 bg-yellow b-r-5 m-r-5 m-l-5 m-t-20">
				<img style="width: 100%;" src="images/male.svg" />
			</div>
			<div class="left grid-60 b-r-5 m-r-5 m-l-5 m-t-20">
				<h2>Профилна информация</h2> <a href="user?id=<%=user.getId()%>">Покажи</a>
				<div class="right">
					<button type="button" onclick="postUserInfo()" style="with: auto">Запази</button>
				</div>
				<span id="user_info_message"></span>
				<div class="">
					<label>Име:</label> 
					<input type="text" value="<%=user.getName()%>" name="name" />
				</div>
				<div class="m-t-20">
					<label>Работа:</label> 
					<input type="text" value="<%=user.getJobTitle()%>" name="jobTitle" />			
				</div>
				<div class="m-t-20">
					<label>Описание:</label> 
					<textarea style="width: 100%" name="info"><%=user.getInfo()%></textarea>				
				</div>
			</div>
		</form>
		<form class="user-skill" enctype="application/x-www-form-urlencoded">
			<input type="hidden" name="id" value="<%=user.getId()%>"/>
			<div class="m-r-5 m-l-5 m-t-20">
				<h2 class="m-t-20">Умения</h2>
				<span id="user_skill_message"></span>
				<div class="right">
					<button type="button" onclick="postUserSkill()" style="with: auto">Запази</button>
				</div>
				<div class="bg-white b-r-10 f-s-0 p-20">
					<div class="grid-50 f-s-16 d-l-b left" style="vertical-align: top;">
						<h3 class="m-l-30">Професионални</h3>
						<%int index = 0;
						for(SkillBeen skill : user.getJobsSkills()) {%>
						<div class="m-t-20 m-l-30">
							<input type="text" value="<%=skill.getName()%>" name="jobSkill<%=index %>"/>
							<input type="range" min="0" max="100" step="10" value="<%=skill.getValue()%>" name="jobSkillValue<%=index %>"/>
						</div>
						<%index++;} %>
						</div>
						<div class="grid-50 f-s-16 d-l-b left" style="vertical-align: top;">
							<h3 class="m-l-30">Личностни</h3>
							<%index = 0;
							for(SkillBeen skill : user.getPersonSkills()) {%>
							<div class="m-t-20 m-l-30">
								<input type="text" value="<%=skill.getName()%>" name="personSkill<%=index %>"/>
								<input type="range" min="0" max="100" step="10" value="<%=skill.getValue()%>" name="personSkillValue<%=index %>"/>
							</div>
							<%index++;} %>	
						</div>
					</div>
				</div>
		</form>
		<form class="user-contact" enctype="application/x-www-form-urlencoded">
			<input type="hidden" name="id" value="<%=user.getId()%>"/>
			<div class="m-r-5 m-l-5 m-t-20">
				<h2 class="m-t-20">Контакти</h2>
				<div class="right">
					<button type="button" onclick="postUserContact()" style="with: auto">Запази</button>
				</div>
				<div class="bg-white b-r-10 f-s-0 p-20">
					<div class="grid-50 f-s-16 d-l-b left">
						<div class="m-l-30">
							<label class="c-blue">Имейл</label>
							<input type="email" name="username" value="<%=user.getUsername()%>" />
						</div>
						<div class="m-t-20 m-l-30">
							<label class="c-blue">Телефон</label>
							<input type="tel" name="phone" value="<%=user.getPhone()%>" />
						</div>					
					</div>

					<div class="grid-50 f-s-16 d-l-b left">
						<div class="m-l-30"]>
							<label class="c-blue">Град</label>
							<input type="text" name="city" value="<%=user.getAddress().getName()%>" />
						</div>
						<div class="m-t-20 m-l-30">
							<label class="c-blue">Улица</label>
							<input type="text" name="street" value="<%=user.getAddress().getName()%>" />					
						</div>					
					</div>
				
				</div>
			</div>
		</form>
		</div>
	</div>
	<jsp:include page="../shared/footer.jsp"/>
</body>
</html>