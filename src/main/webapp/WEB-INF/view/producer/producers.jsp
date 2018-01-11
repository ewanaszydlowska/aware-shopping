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

		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<p>${message}</p>
			<h3>
				<a href="http://localhost:8080/Aware_shopping/producer/add">Dodaj
					producenta</a>
			</h3>
			<h1>Producenci</h1>

			<div class="row">

				<c:forEach items="${availableProducersAsc}" var="producer">

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="http://localhost:8080/Aware_shopping/producer/${producer.id}"><img class="card-img-top"
								src="${pageContext.request.contextPath}/resources/uploads/producers/${producer.fileUrl}" 
								alt="image-of-${producer.name}" /></a>
							<div class="card-body">
								<h4 class="card-title">
									<a
										href="http://localhost:8080/Aware_shopping/producer/${producer.id}">${producer.name}</a>
								</h4>
								<h5>...</h5>
								<p class="card-text">${product.description}</p>
							</div>
							<div class="card-footer">
								<small class="text-muted"></small>
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
		







