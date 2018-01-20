package pl.kupujswiadomie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.kupujswiadomie.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query(value = "SELECT * FROM review WHERE product_id = ? ORDER BY created DESC", nativeQuery = true)
	List<Review> findAllByProductId(int id);

}
