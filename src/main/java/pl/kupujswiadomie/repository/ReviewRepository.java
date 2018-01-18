package pl.kupujswiadomie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kupujswiadomie.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
