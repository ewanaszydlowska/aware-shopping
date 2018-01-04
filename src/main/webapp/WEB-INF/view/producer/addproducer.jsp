<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add user</title>
</head>
<body>
	<%@ include file="../jspf/header.jspf"%>
	<%@ include file="../jspf/main_menu.jspf"%>
	Stwórz nowego producenta:
	<form:form method="post" modelAttribute="producer">
		<p>
			Nazwa:
			<form:input type="text" path="name" />
			<form:errors path="name" />
		</p>
		<p>
			Opis:
			<form:input type="textarea" path="description" />
			<form:errors path="description" />
		</p>
		<p>
			Produkuje w Polsce:
			<form:checkbox path="producingInPL" />
			<form:errors path="producingInPL" />
		</p>
		<p>
			Pochodzi z Polski:
			<form:checkbox path="comingFromPL" />
			<form:errors path="comingFromPL" />
		</p>
		<p>
			<input type="submit" />
		</p>


	</form:form>
	<%@ include file="../jspf/footer.jspf"%>
</body>
</html>