package com.neq.carrental.rental;

import java.util.Date;

public class CarAndRental {
	
	private int car_id;
	private String brand;
	private String model;

	private Date rental_start_date;

	private Date rental_finish_date;
	
	private String pickup_city;
	private String return_city;
	
	public CarAndRental(int car_id, String brand, String model, Date rental_start_date, Date rental_finish_date,
			String pickup_city, String return_city) {
		
		this.car_id = car_id;
		this.brand = brand;
		this.model = model;
		this.rental_start_date = rental_start_date;
		this.rental_finish_date = rental_finish_date;
		this.pickup_city = pickup_city;
		this.return_city = return_city;
	}
	
	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Date getRental_start_date() {
		return rental_start_date;
	}
	public void setRental_start_date(Date rental_start_date) {
		this.rental_start_date = rental_start_date;
	}
	public Date getRental_finish_date() {
		return rental_finish_date;
	}
	public void setRental_finish_date(Date rental_finish_date) {
		this.rental_finish_date = rental_finish_date;
	}
	public String getPickup_city() {
		return pickup_city;
	}
	public void setPickup_city(String pickup_city) {
		this.pickup_city = pickup_city;
	}
	public String getReturn_city() {
		return return_city;
	}
	public void setReturn_city(String return_city) {
		this.return_city = return_city;
	}
	
	
}
