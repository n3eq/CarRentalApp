package com.neq.carrental.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	List<Car> cars;

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
	public String getAllCars(ModelMap modelMap) {

		cars = carRepository.findAll();
		modelMap.addAttribute("cars", cars);
		return "car";
	}

	@GetMapping(path = "/get", params = "sortMethod")
	public String getAllCars(@RequestParam(defaultValue = "priceASC", required = false) String sortMethod,
			ModelMap modelMap) {

		String parameterOfSort = "";
		String wayOfSort = "";
		char c;

		for (int i = 0; i < sortMethod.length(); i++) {
			c = sortMethod.charAt(i);
			if (c >= 64 && c <= 90)
				wayOfSort += c;
			else if (c >= 97 && c <= 122)
				parameterOfSort += c;
		}

		Sort.Direction sortType = Sort.Direction.valueOf(wayOfSort);

		cars = carRepository.findAll(Sort.by(sortType, parameterOfSort));
		modelMap.addAttribute("cars", cars);
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

}
