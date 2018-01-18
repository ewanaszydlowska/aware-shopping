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

			<h3>
				<a href="http://localhost:8080/Aware_shopping/product/add">Dodaj
					nowy produkt</a>
			</h3>


			<div class="card mt-4">
				<img class="card-img-top img-fluid"
					src="${pageContext.request.contextPath}/resources/uploads/products/${product.fileUrl}"
					alt="image-of-${product.name}" />
				<div class="card-body">
					<p>
						Kategoria: <a
							href="http://localhost:8080/Aware_shopping/category/${product.category.id}">${product.category.name}</a>
						- <a
							href="http://localhost:8080/Aware_shopping/subcategory/${product.subcategory.id}">${product.subcategory.name}</a>
					</p>
					<h3 class="card-title">${product.name}</h3>
					<h4>
						<a
							href="http://localhost:8080/Aware_shopping/producer/${product.producer.id}">
							${product.producer.name} </a>
					</h4>
					<c:choose>
						<c:when
							test="${product.producingInPL==true && product.comingFromPL==true}">
							<h5 class="important">W 100% polski produkt</h5>
						</c:when>
						<c:otherwise>
							<h5>Produkowany w Polsce</h5>
						</c:otherwise>
					</c:choose>

					<p class="card-text">${product.description}</p>
					<div class="card-header">Gdzie można dostać ${product.name}:</div>
					<div class="card-body">
						<c:forEach items="${stores}" var="store">
							<p>${store.name}</p>
						</c:forEach>
					</div>
					<div class="card-header">Dodany przez:
						${product.createdBy.username}</div>
					<div class="card-body">
						<c:choose>
							<c:when
								test="${sessionScope.user.username==product.createdBy.username || sessionScope.user.admin==true}">
								<a
									href="http://localhost:8080/Aware_shopping/product/edit/${product.id}">Edytuj
									produkt</a>
								<a
									href="http://localhost:8080/Aware_shopping/product/delete/${product.id}">Usuń
									produkt</a>
							</c:when>
						</c:choose>
					</div>


				</div>
			</div>
			<!-- /.card -->
			<div class="card card-outline-secondary my-4">
				<div class="card-header">Opinie na temat produktu:</div>
				<div class="card-body">

					<c:choose>
						<c:when test="${productReviews==null}">
							<p>Nie dodano jeszcze żadnych komantarzy na temat tego
								produktu, możesz być pierwszy!</p>
						</c:when>
						<c:otherwise>
							<c:forEach items="${productReviews}" var="review">
								<p>${review.text}</p>
								<small class="text-muted">Opublikowano przez
									${review.user.username} o ${review.created}</small>
								<hr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					<a href="#" class="btn btn-success">Zostaw komentarz</a>
				</div>


			</div>
			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>
<!-- /.container -->


<%@ include file="../jspf/footer.jspf"%>
