
$(function() {

	var baseUrl = 'http://localhost:8080/Aware_shopping/product/show/';
	var category = $('.category');

	category.on('change', function() {
		var catId = category.val();
		$.getJSON({
			url : baseUrl + catId
		}).done(
				function(subcategories) {
					console.log(subcategories);
					var subcats = $('.subcategory');
					subcats.empty();

					subcategories.forEach(function(subcategory) {
						subcats.append('<option value=' + subcategory.id + '>'
								+ subcategory.name + '</option>');
					})

				}).fail(function(xhr, status, error) {
			console.log(xhr, status, error);
		});
	});
});
