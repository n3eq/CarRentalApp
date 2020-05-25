package com.neq.carrental.office;

public class CarOffice {
	
	private int car_id;
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

	private int office_id;
	private String car_type;
	private String brand;
	private String model;
	private int production_year;
	private short horsepower;
	private byte seats;
	private int price;
	
	private String city;

	public CarOffice(int car_id, int office_id, String car_type, String brand, String model, int production_year, short horsepower, byte seats,
			int price, String city) {
		
		this.car_id = car_id;
		this.office_id = office_id;
		this.car_type = car_type;
		this.brand = brand;
		this.model = model;
		this.production_year = production_year;
		this.horsepower = horsepower;
		this.seats = seats;
		this.price = price;
		this.city = city;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
