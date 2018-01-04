package pl.kupujswiadomie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kupujswiadomie.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findById(Integer id);
}
