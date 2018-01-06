package pl.kupujswiadomie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kupujswiadomie.entity.Category;
import pl.kupujswiadomie.entity.Subcategory;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findById(Integer id);
	
	List<Subcategory> findSubcategoriesById(int id);
}
