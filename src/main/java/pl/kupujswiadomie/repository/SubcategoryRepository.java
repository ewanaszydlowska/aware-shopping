package pl.kupujswiadomie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.kupujswiadomie.entity.Category;
import pl.kupujswiadomie.entity.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {

	Subcategory findById(int id);
	
	List<Subcategory> findByCategory(Category category);
	
	@Query(value = "select * from subcategory where category_id=1;", nativeQuery = true)
	List<Subcategory> findByCategoryId();

}
