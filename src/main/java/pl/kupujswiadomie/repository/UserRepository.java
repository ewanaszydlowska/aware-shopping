package pl.kupujswiadomie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kupujswiadomie.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findOneByUsername(String email);
}
