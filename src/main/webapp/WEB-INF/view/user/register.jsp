<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/main_menu.jspf"%>

<p>.</p>
<p>^</p>
<h3>Zarejestruj się, aby móc korzystać z wszystkich dostępnych funkcji!</h3>
<form:form method="post" modelAttribute="user">
	<p>
		Nazwa użytkownika:
		<form:input type="text" path="username" />
		<form:errors path="username" />
	</p>
	<p>
		Adres e-mail:
		<form:input type="text" path="email" />
		<form:errors path="email" />
	</p>
	<p>
		Hasło:
		<form:input type="password" path="password" />
		<form:errors path="password" />
	</p>
	<p>
		Akceptuję <a href="rules" target="_blank">regulamin:</a>
		<form:checkbox path="accepted" />
		<form:errors path="accepted" />
	</p>
	<p>
		<input value="Zatwierdź" type="submit" />
	</p>

</form:form>

<%@ include file="../jspf/footer.jspf"%>
