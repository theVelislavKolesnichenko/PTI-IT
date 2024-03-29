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
        <div class="grid-30 bg-yellow b-r-5 m-r-5 m-l-5 m-t-20">
            <img style="width: 100%;" src="public/images/<%= user.getImageName() %>" />
        </div>
        <form action="edit" method="post">
            <div class="left grid-60 b-r-5 m-r-5 m-l-5 m-t-20">
                <div class="right">
                    <input type="submit" value="Запиши">
                </div>
                <h2>Профилна информация</h2>
                <div class="">
                    <label>Име:</label>
                    <input type="text" name="name" placeholder="Име:" value="<%=user.getName()%>">
                </div>
                <div class="m-t-20">
                    <label>Работа:</label>
                    <input type="text" name="job" placeholder="Работа:" value="<%=user.getJobTitle()%>">
                </div>
                <div class="m-t-20">
                    <label>Описание:</label>
                    <textarea class="justify" name="info" placeholder="Описание:" rows="10">
                        <%=user.getInfo()%>
                    </textarea>
                </div>
            </div>

            <div class="m-r-5 m-l-5 m-t-20">
                <h2 class="m-t-20">Умения</h2>
                <div class="bg-white b-r-10 f-s-0 p-20">
                    <div class="grid-50 f-s-16 d-l-b left" style="vertical-align: top;">
                        <h3 class="m-l-30">Професионални</h3>
                        <%for(Skill skill : user.getSkills().getJobSkills()) {%>
                        <div class="m-t-20 m-l-30">
                            <label class="c-blue"><%=skill.getName()%></label>
                            <div class="m-t-10 bg-yellow" style="height: 5px; width: 100%">
                                <div class="bg-blue" style="height: 5px; width: <%=skill.getValue()%>%"></div>
                            </div>
                        </div>
                        <%} %>
                    </div>
                    <div class="grid-50 f-s-16 d-l-b left" style="vertical-align: top;">
                        <h3 class="m-l-30">Личностни</h3>
                        <%for(Skill skill : user.getSkills().getPersonSkills()) {%>
                        <div class="m-t-20 m-l-30">
                            <label class="c-blue"><%=skill.getName()%></label>
                            <div class="m-t-10 bg-yellow" style="height: 5px; width: 100%">
                                <div class="bg-blue" style="height: 5px; width: <%=skill.getValue()%>%"></div>
                            </div>
                        </div>
                        <%} %>
                    </div>
                </div>
            </div>

            <div class="m-r-5 m-l-5 m-t-20">
                <h2 class="m-t-20">Контакти</h2>
                <div class="bg-white b-r-10 f-s-0 p-20">
                    <div class="grid-50 f-s-16 d-l-b left">
                        <div class="m-l-30">
                            <label class="c-blue">Имейл</label>
                            <a class="d-b m-t-10 c-yellow" href="mailto:<%=user.getContact().getEmail()%>"><%=user.getContact().getEmail()%></a>
                        </div>
                        <div class="m-t-20 m-l-30">
                            <label class="c-blue">Телефон</label>
                            <a class="d-b m-t-10 c-yellow" href="tel:<%=user.getContact().getPhone()%>"><%=user.getContact().getPhone()%></a>
                        </div>
                    </div>

                    <div class="grid-50 f-s-16 d-l-b left">
                        <div class="m-l-30"]>
                            <label class="c-blue">Град</label>
                            <span class="d-b m-t-10 c-yellow"><%=user.getContact().getAddress().getCity()%></span>
                        </div>
                        <div class="m-t-20 m-l-30">
                            <label class="c-blue">Улица</label>
                            <span class="d-b m-t-10 c-yellow"><%=user.getContact().getAddress().getStreet()%></span>
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