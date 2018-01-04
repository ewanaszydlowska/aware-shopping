package pl.kupujswiadomie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kupujswiadomie.entity.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {

	Subcategory findById(int id);

}
