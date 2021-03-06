<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/main_menu.jspf"%>

<!-- Page Content -->
<div class="container">
	<div class="row">
		<%@ include file="../jspf/categories.jspf"%>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<h3>Zaloguj się:</h3>
			<form:form method="post" modelAttribute="loginData">
				<p>
					Nazwa użytkownika:
					<form:input type="text" path="username" />
					<form:errors path="username" />
				</p>
				<p>
					Hasło:
					<form:input type="password" path="password" />
					<form:errors path="password" />
				</p>

				<p>
					<input value="Zatwierdź" type="submit" />
				</p>

			</form:form>
			<p class="error">${message}</p>
			
		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->

<%@ include file="../jspf/footer.jspf"%>
