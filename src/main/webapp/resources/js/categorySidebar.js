$(function() {

	var subcategory = $('.subcategory');
	subcategory.addClass('hidden');
	$('.category').on('click', function() {
		$(this).next('div').toggleClass('hidden');
	})
});