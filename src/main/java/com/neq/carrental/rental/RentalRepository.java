package com.neq.carrental.rental;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental, Integer> {
	
	@Query(value = "SELECT r FROM Rental r WHERE r.customer_id = ?1")
	List<Rental> getRentalsByUserId(int userId);
	
	@Query(value = "SELECT NEW com.neq.carrental.rental.CarAndRental"
			+ "(c.brand, c.model, r.rental_start_date, r.rental_finish_date, r.pickup_city, r.return_city)"
			+ "FROM Car c, Rental r WHERE r.car_id = c.car_id AND r.customer_id = ?1")
	List<CarAndRental> getMyRentalsInfo(int userId);
}
