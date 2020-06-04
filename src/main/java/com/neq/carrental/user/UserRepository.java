package com.neq.carrental.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	/**
	 * metoda zwracajaca uzytkownika o podanej nazwie
	 * @param userName
	 * @return
	 */
	@Query(value = "SELECT u FROM User u WHERE u.user_name = ?1")
	Optional<User> findByUserName(String userName);
}
