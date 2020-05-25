package com.neq.carrental.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neq.carrental.office.CarOffice;

@Controller
@RequestMapping(path = "/cars")
public class CarController {

	@Autowired
	private CarRepository carRepository;

	Iterable<CarOffice> cars;

	@PostMapping(path = "/add")
	public @ResponseBody String addCar(@RequestParam int officeId, @RequestParam String type,
			@RequestParam String brand, @RequestParam String model, @RequestParam int price, @RequestParam short year,
			@RequestParam short horsepower, @RequestParam byte seats) {

		Car c = new Car();
		c.setOffice_id(officeId);
		c.setCarType(type);
		c.setBrand(brand);
		c.setModel(model);
		c.setProduction_year(year);
		c.setHorsepower(horsepower);
		c.setSeats(seats);
		c.setPrice(price);

		carRepository.save(c);

		return "Saved";
	}

	@GetMapping(path = "/get")
	public String getCars(@RequestParam(defaultValue = "ASC", required = false) String sortMethod, ModelMap model) {
		
		if(sortMethod.equals("ASC"))
			cars = carRepository.findCarOfficeByPriceAsc();
		else
			
			cars = carRepository.findCarOfficeByPriceDesc();
		
		model.addAttribute("cars", cars);
		
		return "car";
	}

	@GetMapping(path = "/get", params = "type")
	public String getCarsByType(@RequestParam String type, ModelMap modelMap) {

		cars = carRepository.findCarByType(type);
		modelMap.addAttribute("cars", cars);
		return "car";
	}

	@GetMapping(path = "/get", params = "brand")
	public String getCarsByBrand(@RequestParam String brand, ModelMap modelMap) {

		cars = carRepository.findCarByBrand(brand);
		modelMap.addAttribute("cars", cars);
		return "car";
	}

	@GetMapping(path = "/get", params = "model")
	public String getCarsByModel(@RequestParam String model, ModelMap modelMap) {

		cars = carRepository.findCarByModel(model);
		modelMap.addAttribute("cars", cars);
		return "car";
	}
	
	@GetMapping(path = "/get", params = "year")
	public String getCarsByYear(@RequestParam int year, ModelMap modelMap) {

		cars = carRepository.findCarByYear(year);
		modelMap.addAttribute("cars", cars);
		return "car";
	}
	
	@GetMapping(path = "/get", params = "city")
	public String getCarsByCity(@RequestParam String city, ModelMap modelMap) {

		cars = carRepository.findCarByCity(city);
		modelMap.addAttribute("cars", cars);
		return "car";
	}

}
