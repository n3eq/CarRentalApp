package com.neq.carrental.rental;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
	
	@Query(value = "SELECT r FROM Rental r WHERE r.user_id = ?1")
	List<Rental> getRentalsByUserId(int userId);
	
	/**
	 * metoda zwracająca informacje o wypożyczeniach dokonanych przez klienta o podanym identyfikatorze
	 * @param userId parametr określający identyfikator użytkownika
	 * @return
	 */
	@Query(value = "SELECT NEW com.neq.carrental.rental.CarAndRental"
			+ "(c.car_id, c.brand, c.model, r.rental_start_date, r.rental_finish_date, r.pickup_city, r.return_city)"
			+ "FROM Car c, Rental r WHERE r.car_id = c.car_id AND r.user_id = ?1")
	List<CarAndRental> getMyRentalsInfo(int userId);
	
	/**
	 * metoda zwracająca liczbe wypożyczeń dokonanych przez klienta o podanym identifikatorze
	 * @param userId parametr określający identyfikator użytkownika
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM Rental r WHERE r.user_id = ?1")
	long getAmountOfRentalsByUserId(int userId);
	
	/**
	 * metoda usuwajaca samochod o podanym identyfikatorze
	 * @param carId parametr określający identifikator samochodu
	 */
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Rental r WHERE r.car_id = ?1")
	void deleteRentalById(int carId);
}
