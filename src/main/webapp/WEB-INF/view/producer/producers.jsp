<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../jspf/header.jspf"%>
	<%@ include file="../jspf/main_menu.jspf"%>

	<a href="http://localhost:8080/Aware_shopping/producer/add">Dodaj producenta</a>
	<ul>Producenci</ul>
	<c:forEach items="${availableProducers}" var="producer">
			<li><a href="http://localhost:8080/Aware_shopping/producer/${producer.id}">${producer.name}</a></li>
		</c:forEach>	

	<%@ include file="../jspf/footer.jspf"%>


</body>
</html>