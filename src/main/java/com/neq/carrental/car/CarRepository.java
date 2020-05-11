package com.neq.carrental.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Integer> {

	@Query(value = "SELECT c FROM Car c WHERE c.carType = ?1")
	List<Car> findCarByType(String type);

	@Query(value = "SELECT c FROM Car c WHERE c.brand = ?1")
	List<Car> findCarByBrand(String brand);

	@Query(value = "SELECT c FROM Car c WHERE c.model = ?1")
	List<Car> findCarByModel(String model);

	@Query(value = "SELECT c FROM Car c WHERE c.price = ?1")
	List<Car> findCarByPrice(int price);

}
