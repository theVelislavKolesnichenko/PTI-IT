<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sit.tu_varna.bg.models.User" %>
<%@ page import="sit.tu_varna.bg.models.Skill" %>
<!DOCTYPE html>
<html>
<jsp:include page="../shared/head.jsp"/>
<body>
<jsp:include page="../shared/header.jsp"/>

<%
    User user = (User) request.getAttribute("user");
%>

<div class="center">
    <div class="grid">
        <form id="user-item-form"
<%--              onsubmit="editUserInfo(event)" --%>
              class="user-info" enctype="application/x-www-form-urlencoded">
            <div class="grid-30 bg-yellow b-r-5 m-r-5 m-l-5 m-t-20">
                <img style="width: 100%;" src="public/images/<%= user.getImageName() %>" />
            </div>

            <div class="left grid-60 b-r-5 m-r-5 m-l-5 m-t-20">
                <h2>Профилна информация</h2>
                <div class="right">
                    <button type="button"
                            onclick="postUserInfo()"
                            style="with: auto">Запази</button>
                </div>
                <span class="c-red" id="user_info_message"></span>
                <div class="">
                    <label>Име:</label>
                    <input type="text" name="name" placeholder="Име:" value="<%=user.getName()%>">
                </div>
                <div class="m-t-20">
                    <label>Работа:</label>
                    <input type="text" name="jobTitle" placeholder="Работа:" value="<%=user.getJobTitle()%>">
                </div>
                <div class="m-t-20">
                    <label>Описание:</label>
                    <textarea class="justify" name="info" placeholder="Описание:" rows="10">
                        <%=user.getInfo()%>
                    </textarea>
                </div>
            </div>
        </form>
        <form class="user-skill" enctype="application/x-www-form-urlencoded">
            <div class="m-r-5 m-l-5 m-t-20">
                <h2 class="m-t-20">Умения</h2>
                <span class="c-red" id="user_skill_message"></span>
                <div class="right">
                    <button type="button" onclick="postUserSkills()" style="with: auto">Запази</button>
                </div>
                <div class="bg-white b-r-10 f-s-0 p-20">
                    <div class="grid-50 f-s-16 d-l-b left" style="vertical-align: top;">
                        <h3 class="m-l-30">Професионални</h3>
                        <%for(Skill skill : user.getSkills().getJobSkills()) {%>
                        <div class="m-t-20 m-l-30">
                            <label class="c-blue"><%=skill.getName()%></label>
                            <input type="range" min="0" max="100" step="10"
                                   value="<%=skill.getValue()%>" name="<%=skill.getName()%>"/>
                        </div>
                        <%} %>
                    </div>
                    <div class="grid-50 f-s-16 d-l-b left" style="vertical-align: top;">
                        <h3 class="m-l-30">Личностни</h3>
                        <%for(Skill skill : user.getSkills().getPersonSkills()) {%>
                        <div class="m-t-20 m-l-30">
                            <label class="c-blue"><%=skill.getName()%></label>
                            <input type="range" min="0" max="100" step="10" value="<%=skill.getValue()%>" name="<%=skill.getName()%>"/>
                        </div>
                        <%} %>
                    </div>
                </div>
            </div>
        </form>
        <form id="user-contact-form" class="user-contact" enctype="application/x-www-form-urlencoded">
            <div class="m-r-5 m-l-5 m-t-20">
                <h2 class="m-t-20">Контакти</h2>
                <div class="right">
                    <button type="button" onclick="postUserContact()" style="with: auto">Запази</button>
                </div>
                <div class="bg-white b-r-10 f-s-0 p-20">
                    <div class="grid-50 f-s-16 d-l-b left">
                        <div class="m-l-30">
                            <label class="c-blue">Имейл</label>
                            <input type="email" name="email" value="<%=user.getContact().getEmail()%>" />
                        </div>
                        <div class="m-t-20 m-l-30">
                            <label class="c-blue">Телефон</label>
                            <input type="text" value="<%=user.getContact().getPhone()%>" name="phone">
                        </div>
                    </div>

                    <div class="grid-50 f-s-16 d-l-b left">
                        <div class="m-l-30"]>
                            <label class="c-blue">Град</label>
                            <input type="text" name="address" value="<%=user.getContact().getAddress().getCity()%>"/>
                        </div>
                        <div class="m-t-20 m-l-30">
                            <label class="c-blue">Улица</label>
                            <input type="text" name="street" value="<%=user.getContact().getAddress().getStreet()%>" />
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