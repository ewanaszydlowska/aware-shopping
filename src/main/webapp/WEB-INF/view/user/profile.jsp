<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/main_menu.jspf"%>
<h3>Profil użytkownika ${user.username}</h3>
<p>Adres e-mail: ${user.email}</p>
<p>Produkty dodane przez użytkownika:</p>
<c:forEach items="${products}" var="product">
	<li><a
		href="http://localhost:8080/Aware_shopping/product/${product.id}">${product.name}</a></li>
</c:forEach>

<p>
	<a
		href="http://localhost:8080/Aware_shopping/edituser/${user.username}">Edytuj
		hasło</a>
</p>
<%@ include file="../jspf/footer.jspf"%>
