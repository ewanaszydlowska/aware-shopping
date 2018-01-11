package pl.kupujswiadomie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.kupujswiadomie.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {

	Producer findById(int parseInt);

	@Query(value = "SELECT * FROM producer ORDER BY name ASC", nativeQuery = true)
	List<Producer> findAllByNameAsc();

}
