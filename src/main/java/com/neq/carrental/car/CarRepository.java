package com.neq.carrental.car;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.neq.carrental.office.CarOffice;

public interface CarRepository extends JpaRepository<Car, Integer> {

	/**
	 * metoda która wyszukuje w bazie samochody o podanym typie samochodu
	 */
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.car_type = ?1")
	List<CarOffice> findCarByType(String type);

	/**
	 * metoda która wyszukuje w bazie samochody o podanej marce samochodu
	 */
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.brand = ?1")
	List<CarOffice> findCarByBrand(String brand);

	/**
	 * metoda która wyszukuje w bazie samochody o podanym modelu samochodu
	 */
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.model = ?1")
	List<CarOffice> findCarByModel(String model);
	
	/**
	 * metoda która wyszukuje w bazie samochodu o podanym roku produkcji
	 */
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.production_year = ?1")
	List<CarOffice> findCarByYear(int year);
		
	/**
	 * metoda która wyszukuje w bazie samochody względem ich miast dostępu
	 */
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND o.city = ?1")
	List<CarOffice> findCarByCity(String city);
	
	/**
	 * metoda która wyszukuje samochód w bazie po identyfikatorze
	 */
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.car_id = ?1")
	CarOffice findCarByCarId(int carId);

	/**
	 * metoda która wyszukuje w bazie samochody względem cen rosnąco
	 */
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.avaliable >= 1 ORDER BY c.price ASC")
	List<CarOffice> findCarOfficeByPriceAsc();
	
	/**
	 * metoda która wyszukuje w bazie samochody względem cen malejąco
	 */
	@Query(value = "SELECT NEW com.neq.carrental.office.CarOffice"
			+ "(c.car_id, c.office_id, c.car_type, c.brand, c.model, c.production_year, c.horsepower, c.seats, c.price, o.city)"
			+ "FROM Office o, Car c WHERE c.office_id = o.office_id AND c.avaliable >= 1 ORDER BY c.price DESC")
	List<CarOffice> findCarOfficeByPriceDesc();
	
	/**
	 * metoda która ustawia dostępność samochodu w bazie danych na wartość mniejszą o 1
	 */
	@Modifying
	@Transactional
	@Query(value = "UPDATE car SET car.avaliable = car.avaliable - 1 WHERE car.car_id = ?1", nativeQuery = true)
	void subtractCarAvaliable(int carId);
	
	/**
	 * metoda która ustawia dostępność samochodu w bazie danych na wartość większą o 1
	 */
	@Modifying
	@Transactional
	@Query(value = "UPDATE car SET car.avaliable = car.avaliable + 1 WHERE car.car_id = ?1", nativeQuery = true)
	void addCarAvaliable(int carId);
	
}
