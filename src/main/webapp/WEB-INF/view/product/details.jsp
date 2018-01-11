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

		<div class="col-lg-3">
			<p>.</p>
			<p>^</p>
			<h1 class="my-4">Kupuj świadomie:</h1>
			<%@ include file="../jspf/categories.jspf"%>
		</div>

		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<p>.</p>
			<p>^</p>
			<a href="http://localhost:8080/Aware_shopping/product/add">Dodaj
				nowy produkt</a>

			<div class="card mt-4">
				<img class="card-img-top img-fluid"
					src="${pageContext.request.contextPath}/resources/uploads/products/${product.fileUrl}" alt="image-of-${product.name}" />
				<div class="card-body">
					<p>
						Kategoria: <a
							href="http://localhost:8080/Aware_shopping/category/${product.category.id}">${product.category.name}</a>
						- <a
							href="http://localhost:8080/Aware_shopping/subcategory/${product.subcategory.id}">${product.subcategory.name}</a>
					</p>
					<h3 class="card-title">${product.name}</h3>
					<h4> <a href="http://localhost:8080/Aware_shopping/producer/${product.producer.id}">
					${product.producer.name} </a></h4>
					<h4>Produkt polskiego producenta:</h4>
					<h4>Produkowany w Polsce:</h4>
					<p class="card-text">${product.description}</p>
					<div class="card-header">Gdzie można dostać ${product.name}:</div>
					<div class="card-body">
						<c:forEach items="${stores}" var="store">
							${store.name}
						</c:forEach>
					</div>
					<div class="card-header">Dodany przez:
						${product.createdBy.username}</div>
					<div class="card-body">
						<c:choose>
							<c:when
								test="${sessionScope.user.username==product.createdBy.username}">
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
				<div class="card-header">Product Reviews</div>
				<div class="card-body">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Omnis et enim aperiam inventore, similique necessitatibus neque
						non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
						Sequi mollitia, necessitatibus quae sint natus.</p>
					<small class="text-muted">Posted by Anonymous on 3/1/17</small>
					<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Omnis et enim aperiam inventore, similique necessitatibus neque
								non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
								Sequi mollitia, necessitatibus quae sint natus.</p>
							<small class="text-muted">Posted by Anonymous on 3/1/17</small>
							<hr>
								<a href="#" class="btn btn-success">Leave a Review</a>
				</div>
			</div>
			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>
<!-- /.container -->


<%@ include file="../jspf/footer.jspf"%>
