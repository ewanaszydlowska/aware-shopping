package pl.kupujswiadomie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kupujswiadomie.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {

	Producer findById(int parseInt);

}
