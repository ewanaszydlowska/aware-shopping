package pl.kupujswiadomie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProducer(Producer producer);
	
	Product findById(int id);

}
