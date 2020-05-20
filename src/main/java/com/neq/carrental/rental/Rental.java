package com.neq.carrental.rental;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rental {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rental_id;
	
	private int customer_id;
	
	private int car_id;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date rental_start_date;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date rental_finish_date;

	private String pickup_city;
	private String return_city;
	
	public Rental()
	{
		
	}
	
	public Rental(int customer_id, int car_id, String rental_start_date, String rental_finish_date,
			String pickup_city, String return_city) throws ParseException {
		
		this.customer_id = customer_id;
		this.car_id = car_id;
		
		DateFormat formatter;
		Date date_start;
		Date date_finish;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		date_start = formatter.parse(rental_start_date);
		date_finish = formatter.parse(rental_finish_date);
		this.rental_start_date = date_start;
		this.rental_finish_date = date_finish;
		this.pickup_city = pickup_city;
		this.return_city = return_city;
	}

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
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
