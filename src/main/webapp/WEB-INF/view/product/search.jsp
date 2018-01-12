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
			<a href="http://localhost:8080/Aware_shopping/product/add">Dodaj
				produkt</a>
			<h3>Efekty wyszukiwania "${search}"</h3>

			<div class="row">

				<c:forEach items="${searchResult}" var="product">

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="http://localhost:8080/Aware_shopping/product/${product.id}"><img class="card-img-top"
								src="${pageContext.request.contextPath}/resources/uploads/products/${product.fileUrl}"
								alt="image-of-${product.name}" /></a>
							<div class="card-body">
								<h4 class="card-title">
									<a
										href="http://localhost:8080/Aware_shopping/product/${product.id}">${product.name}</a>
								</h4>
								<h5>${product.producer.name}</h5>
							</div>
							<div class="card-footer">
								<small class="text-muted">Kod kreskowy:</small>
							</div>
						</div>
					</div>

				</c:forEach>

			</div>
			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->

<%@ include file="../jspf/footer.jspf"%>