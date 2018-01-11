package pl.kupujswiadomie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.entity.Product;
import pl.kupujswiadomie.entity.User;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProducer(Producer producer);
	
	Product findById(int id);

	@Query(value = "SELECT * FROM product ORDER BY created DESC LIMIT 9", nativeQuery = true)
	List<Product> findAllByCreated();
	
	List<Product> findAllByCreatedBy(User createdBy);

	@Query(value = "SELECT * FROM product WHERE category_id = ? ORDER BY name ASC", nativeQuery = true)
	List<Product> findByCategory(int id);

	@Query(value = "SELECT * FROM product WHERE subcategory_id = ? ORDER BY name ASC", nativeQuery = true)
	List<Product> findBySubcategory(int id);
	
	@Query(value = "SELECT * FROM product ORDER BY name ASC", nativeQuery = true)
	List<Product> findAllByNameAsc();
	
	@Query(value = "SELECT p FROM Product p WHERE p.name LIKE %:search%")
	List<Product> findByGivenString(@Param("search") String search);
}
