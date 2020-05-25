package com.neq.carrental.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neq.carrental.office.CarOffice;

public interface CarRepository extends JpaRepository<Car, Integer> {

	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.car_type = ?1")
	List<CarOffice> findCarByType(String type);

	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.brand = ?1")
	List<CarOffice> findCarByBrand(String brand);

	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.model = ?1")
	List<CarOffice> findCarByModel(String model);
	
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.production_year = ?1")
	List<CarOffice> findCarByYear(int year);
	
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND o.city = ?1")
	List<CarOffice> findCarByCity(String city);
	
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.car_id = ?1")
	CarOffice findCarByCarId(int carId);

	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id ORDER BY c.price ASC")
	List<CarOffice> findCarOfficeByPriceAsc();
	
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id ORDER BY c.price DESC")
	List<CarOffice> findCarOfficeByPriceDesc();
	
	
}
