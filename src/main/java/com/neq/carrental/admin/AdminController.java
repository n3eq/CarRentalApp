package com.neq.carrental.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neq.carrental.car.Car;
import com.neq.carrental.car.CarRepository;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

	@Autowired
	private CarRepository carRepository;
	
		@GetMapping(path = "")
		public String getAdminPage()
		{
			return "admin";
		}
		
		@GetMapping(path="/addcar")
		public String getAddCarPage(ModelMap model)
		{
			model.addAttribute("car", new Car(1,"sport","audi","rs5",2020,(short)200,(byte)5,1000,(byte)1));
			return "addcar";
		}
	
		@RequestMapping(value = "/addcar", method = RequestMethod.POST)
		public String  addCar(Car car)
		{	
			carRepository.save(car);
				
			return "redirect:/admin";
		}
		
		@GetMapping(path = "/deletecar")
		public String addCar(@RequestParam int carId) {

			carRepository.deleteById(carId);

			return "redirect:/admin";
		}
}
