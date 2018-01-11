package pl.kupujswiadomie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.kupujswiadomie.entity.Category;
import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.entity.Product;
import pl.kupujswiadomie.entity.Subcategory;
import pl.kupujswiadomie.entity.User;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProducer(Producer producer);
	
	Product findById(int id);

	@Query(value = "SELECT * FROM product ORDER BY created DESC LIMIT 9", nativeQuery = true)
	List<Product> findAllByCreated();
	
	List<Product> findAllByCreatedBy(User createdBy);

	List<Product> findByCategory(Category category);

	List<Product> findBySubcategory(Subcategory subcategory);
	
	@Query(value = "SELECT * FROM product ORDER BY name ASC", nativeQuery = true)
	List<Product> findAllByNameAsc();
}
