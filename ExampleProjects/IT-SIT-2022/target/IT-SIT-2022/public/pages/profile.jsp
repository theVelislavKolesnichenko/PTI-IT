<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<jsp:include page="../shared/head.jsp"/>
<body>
<jsp:include page="../shared/header.jsp"/>

<div class="center">

  <%if(request.getAttribute("message") == null) {%>
  <div>
    <h2>Добър ден с ТУ Варна</h2>
    <form action="cookie" method="post">
      <input type="submit" value="затвори"/>
    </form>
  </div>
  <%} %>

  <div class="grid">
    <div class="grid-30 bg-yellow b-r-5 m-r-5 m-l-5 m-t-20">
      <img style="width: 100%;" src="images/male.svg" />
    </div>
    <div class="left grid-60 b-r-5 m-r-5 m-l-5 m-t-20">
<%--      <%if(user.getId() == sessionUser.getId()) {%>--%>
<%--      <div class="right">--%>
<%--        <a href="user?id=<%=user.getId()%>&action=edit" class="button">Редактиране</a>--%>
<%--      </div>--%>
<%--      <%} %>--%>
      <h2>Профилна информация</h2>
      <div class="">
        <label>Име:</label>
        <span>Name></span>
      </div>
      <div class="m-t-20">
        <label>Работа:</label>
        <span>JobTitle</span>
      </div>
      <div class="m-t-20">
        <label>Описание:</label>
        <span class="justify">Info</span>
      </div>
    </div>
<%--    <div class="m-r-5 m-l-5 m-t-20">--%>
<%--      <h2 class="m-t-20">Умения</h2>--%>
<%--      <div class="bg-white b-r-10 f-s-0 p-20">--%>
<%--        <div class="grid-50 f-s-16 d-l-b left" style="vertical-align: top;">--%>
<%--          <h3 class="m-l-30">Професионални</h3>--%>
<%--          <%for(SkillBeen skill : user.getJobsSkills()) {%>--%>
<%--          <div class="m-t-20 m-l-30">--%>
<%--            <label class="c-blue"><%=skill.getName()%></label>--%>
<%--            <div class="m-t-10 bg-yellow" style="height: 5px; width: 100%">--%>
<%--              <div class="bg-blue" style="height: 5px; width: <%=skill.getValue()%>%"></div>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--          <%} %>--%>
<%--        </div>--%>
<%--        <div class="grid-50 f-s-16 d-l-b left" style="vertical-align: top;">--%>
<%--          <h3 class="m-l-30">Личностни</h3>--%>
<%--          <%for(SkillBeen skill : user.getPersonSkills()) {%>--%>
<%--          <div class="m-t-20 m-l-30">--%>
<%--            <label class="c-blue"><%=skill.getName()%></label>--%>
<%--            <div class="m-t-10 bg-yellow" style="height: 5px; width: 100%">--%>
<%--              <div class="bg-blue" style="height: 5px; width: <%=skill.getValue()%>%"></div>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--          <%} %>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--    <div class="m-r-5 m-l-5 m-t-20">--%>
<%--      <h2 class="m-t-20">Контакти</h2>--%>
<%--      <div class="bg-white b-r-10 f-s-0 p-20">--%>
<%--        <div class="grid-50 f-s-16 d-l-b left">--%>
<%--          <div class="m-l-30">--%>
<%--            <label class="c-blue">Имейл</label>--%>
<%--            <a class="d-b m-t-10 c-yellow" href="mailto:<%=user.getUsername()%>"><%=user.getUsername()%></a>--%>
<%--          </div>--%>
<%--          <div class="m-t-20 m-l-30">--%>
<%--            <label class="c-blue">Телефон</label>--%>
<%--            <a class="d-b m-t-10 c-yellow" href="tel:<%=user.getPhone()%>"><%=user.getPhone()%></a>--%>
<%--          </div>--%>
<%--        </div>--%>

<%--        <div class="grid-50 f-s-16 d-l-b left">--%>
<%--          <div class="m-l-30"]>--%>
<%--            <label class="c-blue">Град</label>--%>
<%--            <span class="d-b m-t-10 c-yellow"><%=user.getAddress().getName()%></span>--%>
<%--          </div>--%>
<%--          <div class="m-t-20 m-l-30">--%>
<%--            <label class="c-blue">Улица</label>--%>
<%--            <span class="d-b m-t-10 c-yellow"><%=user.getAddress().getStreet()%></span>--%>
<%--          </div>--%>
<%--        </div>--%>

<%--      </div>--%>
<%--    </div>--%>
  </div>
</div>
<jsp:include page="../shared/footer.jsp"/>
</body>
</html>