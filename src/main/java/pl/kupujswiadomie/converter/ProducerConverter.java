package pl.kupujswiadomie.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.kupujswiadomie.entity.Category;
import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.repository.CategoryRepository;
import pl.kupujswiadomie.repository.ProducerRepository;

public class ProducerConverter implements Converter<String, Producer>{

	@Autowired
	private ProducerRepository producerRepo;
	
	@Override
	public Producer convert(String source) {
		Producer producer = this.producerRepo.findById(Integer.parseInt(source));
		return producer;
	}

}
