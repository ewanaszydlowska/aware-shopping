package pl.kupujswiadomie.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.kupujswiadomie.entity.Store;
import pl.kupujswiadomie.repository.StoreRepository;

public class StoreConverter implements Converter<String, Store>{

	@Autowired
	private StoreRepository storeRepo;
	
	@Override
	public Store convert(String source) {
		Store store = this.storeRepo.findById(Integer.parseInt(source));
		return store;
	}

}
