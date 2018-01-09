<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

	<%@ include file="../jspf/header.jspf"%>
	<%@ include file="../jspf/main_menu.jspf"%>
	Stwórz nowy produkt:
	<form:form method="post" modelAttribute="product">
		<p>
			Nazwa:
			<form:input type="text" path="name" />
			<form:errors path="name" />
		</p>
		<p>
			Kategoria:
			<form:select type="text" path="category" class="category">
				<form:options items="${availableCategories}" itemValue="id"
					itemLabel="name" />
			</form:select>
			<form:errors path="category" />
		</p>
		<p>
			Subkategoria:
			<form:select type="text" path="subcategory" class="subcategory">
				<form:options items="${ByFirstCategory}" itemValue="id"
					itemLabel="name" />
			</form:select>
			<form:errors path="subcategory" />
		</p>
		<p>
			Opis:
			<form:input type="textarea" path="description" />
			<form:errors path="description" />
		</p>
		<p>
			Produkowany w Polsce:
			<form:checkbox path="producingInPL" />
			<form:errors path="producingInPL" />
		</p>
		<p>
			Polski producent:
			<form:checkbox path="comingFromPL" />
			<form:errors path="comingFromPL" />
		</p>

		<p>
			Producent:
			<form:select type="text" path="producer">
				<form:options items="${availableProducers}" itemValue="id"
					itemLabel="name" />
			</form:select>
			<form:errors path="producer" />
		</p>
			Gdzie można go dostać:
			<form:select type="text" path="stores">
				<form:options items="${availableStores}" itemValue="id"
					itemLabel="name" multiple="true" />
			</form:select>
			<form:errors path="stores" />
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form:form>

	<%@ include file="../jspf/footer.jspf"%>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
		crossorigin="anonymous"></script>
	
	<script src="<c:url value='/resources/js/app.js' />" > </script>

