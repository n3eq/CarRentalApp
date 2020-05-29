package com.neq.carrental.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neq.carrental.car.Car;
import com.neq.carrental.car.CarRepository;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

	@Autowired
	private CarRepository carRepository;
	
		@GetMapping(path = "")
		public String getAdminPage(ModelMap model)
		{
			model.addAttribute("car", new Car(1,"sport","audi","rs5",2020,(short)200,(byte)5,1000,(byte)1));
			return "admin";
		}
	
		/*@GetMapping(path = "/addcar")
		public @ResponseBody String addCar(@RequestParam int officeId, @RequestParam String type,
				@RequestParam String brand, @RequestParam String model, @RequestParam int price, @RequestParam short year,
				@RequestParam short horsepower, @RequestParam byte seats) {*/

		/*	Car c = new Car();
			c.setOffice_id(officeId);
			c.setCarType(type);
			c.setBrand(brand);
			c.setModel(model);
			c.setProduction_year(year);
			c.setHorsepower(horsepower);
			c.setSeats(seats);
			c.setPrice(price);

			carRepository.save(c);*/

		@RequestMapping(value = "/addcar", method = RequestMethod.POST)
		public String addCar(Car car)
		{	
			carRepository.save(car);
			
			return "redirect:/admin";
		}
		
		@PostMapping(path = "/deletecar")
		public @ResponseBody String addCar(int carId) {

			carRepository.deleteById(carId);

			return "Saved";
		}
}
