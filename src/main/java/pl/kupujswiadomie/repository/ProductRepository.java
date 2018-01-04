package pl.kupujswiadomie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kupujswiadomie.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
