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
			<div class="card mt-4">

				<div class="card-header">Dodaj produkt</div>
				<div class="card-body">
					<form:form method="post" modelAttribute="product"
						enctype="multipart/form-data">
						<p>
							Nazwa:
							<form:input type="text" path="name" />
							<form:errors path="name" />
						</p>
						<p>
							Kategoria:
							<form:select type="text" path="category" class="categoryList">
								<form:options items="${availableCategories}" itemValue="id"
									itemLabel="name" />
							</form:select>
							<form:errors path="category" />
						</p>
						<p>
							Subkategoria:
							<form:select type="text" path="subcategory"
								class="subcategoryList">
								<form:options items="${byFirstCategory}" itemValue="id"
									itemLabel="name" />
							</form:select>
							<form:errors path="subcategory" />
						</p>
						<p>
							Zdjęcie: (format .jpg lub .jpeg)
							<form:input type="file" path="fileUrl" name="file" />
							<form:errors path="description" />
							${errorMessage}
						</p>
						<p>
							Opis: <span> <form:textarea path="description" /> <form:errors
									path="description" />
							</span>
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
						<p>
							Punkty, w których produkt jest dostępny: <span>
						</p>
						<form:select type="text" path="stores">
							<form:options items="${availableStores}" itemValue="id"
								itemLabel="name" multiple="true" />
						</form:select>
						<form:errors path="stores" />
						</span>
						</p>
						<p>
							<input type="submit" value="Dodaj" />
						</p>
					</form:form>
				</div>

			</div>
			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>
<!-- /.container -->

<%@ include file="../jspf/footer.jspf"%>