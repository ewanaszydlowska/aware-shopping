package pl.kupujswiadomie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.kupujswiadomie.entity.Product;
import pl.kupujswiadomie.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {

	Store findById(int parseInt);

	@Query(value = "select * from store join store_product on store.id=stores_id where products_id=?;", nativeQuery = true)
	List<Store> findAllByProductId(int productId);

}
