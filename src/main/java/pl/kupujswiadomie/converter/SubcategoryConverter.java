package pl.kupujswiadomie.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.kupujswiadomie.entity.Subcategory;
import pl.kupujswiadomie.repository.SubcategoryRepository;

public class SubcategoryConverter implements Converter<String, Subcategory>{

	@Autowired
	private SubcategoryRepository subcategoryRepo;
	
	@Override
	public Subcategory convert(String source) {
		Subcategory subcategory = this.subcategoryRepo.findById(Integer.parseInt(source));
		return subcategory;
	}

}
