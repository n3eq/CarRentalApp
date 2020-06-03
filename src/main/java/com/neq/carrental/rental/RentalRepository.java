package com.neq.carrental.rental;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
	
	@Query(value = "SELECT r FROM Rental r WHERE r.customer_id = ?1")
	List<Rental> getRentalsByUserId(int userId);
	
	@Query(value = "SELECT NEW com.neq.carrental.rental.CarAndRental"
			+ "(c.car_id, c.brand, c.model, r.rental_start_date, r.rental_finish_date, r.pickup_city, r.return_city)"
			+ "FROM Car c, Rental r WHERE r.car_id = c.car_id AND r.customer_id = ?1")
	List<CarAndRental> getMyRentalsInfo(int userId);
	
	@Query(value = "SELECT COUNT(*) FROM Rental r WHERE r.customer_id = ?1")
	long getAmountOfRentalsByUserId(int userId);
	
	@Query(value = "DELETE FROM Rental r WHERE r.car_id = ?1")
	void deleteRentalById(int carId);
}
