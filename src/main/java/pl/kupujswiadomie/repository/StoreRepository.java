package pl.kupujswiadomie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kupujswiadomie.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {

}
