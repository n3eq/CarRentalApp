package com.neq.carrental.rental;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental, Integer> {
	
	@Query(value = "SELECT r FROM Rental r WHERE r.customer_id = ?1")
	public List<Rental> getRentalsByUserId(int userId);
	
}
