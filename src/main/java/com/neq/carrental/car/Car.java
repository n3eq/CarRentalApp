package com.neq.carrental.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int car_id;

	private int office_id;
	private String carType;
	private String brand;
	private String model;
	private int production_year;
	private short horsepower;
	private byte seats;
	private int price;

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getOffice_id() {
		return office_id;
	}

	public void setOffice_id(int office_id) {
		this.office_id = office_id;
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

	public int getProduction_year() {
		return production_year;
	}

	public void setProduction_year(int production_year) {
		this.production_year = production_year;
	}

	public short getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(short horsepower) {
		this.horsepower = horsepower;
	}

	public byte getSeats() {
		return seats;
	}

	public void setSeats(byte seats) {
		this.seats = seats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

}
