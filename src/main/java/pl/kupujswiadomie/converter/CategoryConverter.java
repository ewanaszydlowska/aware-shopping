package pl.kupujswiadomie.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.kupujswiadomie.entity.Category;
import pl.kupujswiadomie.repository.CategoryRepository;

public class CategoryConverter implements Converter<String, Category>{

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public Category convert(String source) {
		Category category = this.categoryRepo.findById(Integer.parseInt(source));
		return category;
	}

}
