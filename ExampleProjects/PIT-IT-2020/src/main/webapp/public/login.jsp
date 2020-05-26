<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../shared/head.jsp"/>
<body>
	<jsp:include page="../shared/header.jsp"/>
	<div class="center">
	    <h1>Влезте в системата</h1>
	    <div class="bg-yellow b-radius-5 p-20 m-t-20 grid">
			<form action="LoginServlet" method="post">
			
				<div class="m-t-20">
					<label class="block" for="username">Потребителско име:</label>
					<input class="m-t-10" id="username" type="text" name="username" placeholder="Въведете имейл адрес">
				</div>
				
				<div class="m-t-20">
					<label class="block" for="password">Парола:</label>
					<input class="m-t-10" id="password" type="password" name="password" placeholder="Въведете парола поне с 8 символа">
				</div>
			     
			    <input class="m-t-20" type="submit" value="Вход">
			</form>
		</div>
	</div>
</body>
</html>