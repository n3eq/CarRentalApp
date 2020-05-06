package com.neq.carrental.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/cars")
public class CarController {

	@Autowired
	private CarRepository carRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addCar(@RequestParam String type, @RequestParam String brand,
			@RequestParam String model, @RequestParam int price) {

		Car c = new Car();
		c.setCar_type(type);
		c.setBrand(brand);
		c.setModel(model);
		c.setPrice(price);

		carRepository.save(c);

		return "Saved";
	}

	@GetMapping(path = "/get")
	public @ResponseBody Iterable<Car> getAllCars() {
		return carRepository.findAll();
	}

	@GetMapping(path = "/get/type")
	public @ResponseBody Iterable<Car> getCarsByType() {
		List<Car> cars = carRepository.findCarByType("family");
		return cars;
	}

	@GetMapping(path = "/get/brand")
	public @ResponseBody Iterable<Car> getCarsByBrand() {
		List<Car> cars = carRepository.findCarByBrand("audi");
		return cars;
	}

	@GetMapping(path = "/get/model")
	public @ResponseBody Iterable<Car> getCarsByModel() {
		List<Car> cars = carRepository.findCarByModel("rs7");
		return cars;
	}

	@GetMapping(path = "/get/price")
	public @ResponseBody Iterable<Car> getCarsByPrice() {
		List<Car> cars = carRepository.findCarByPrice(2200);
		return cars;
	}
}
