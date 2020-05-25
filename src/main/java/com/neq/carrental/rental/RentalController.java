package com.neq.carrental.rental;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neq.carrental.car.CarRepository;
import com.neq.carrental.user.IUserAuthentication;
import com.neq.carrental.user.MyUserDetails;

@Controller
@RequestMapping(path = "/rental")
public class RentalController {

	@Autowired
	private RentalRepository rentalRepository;
	
	@Autowired
	private IUserAuthentication userAuthentication;

	@Autowired
	private CarRepository carRepository;
	
	@GetMapping(path = "/get")
	@ResponseBody
	public Iterable<Rental> getRental() {
		return rentalRepository.findAll();
	}
	
	@GetMapping(path = "/myrentals")
	public String getMyRentals(ModelMap model)
	{
		Authentication authentication = userAuthentication.getAuthentication();
		MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
		
		Iterable<Rental> rentals = rentalRepository.getRentalsByUserId(userDetails.getUserId());
		
		model.addAttribute("rentals", rentals);
		
		return "myrentals";
	}
	
	@GetMapping(path = "/rentacar")
	public String rentACar(@RequestParam String id, @RequestParam String city, ModelMap model) {
		
		model.addAttribute("carId", id);
		model.addAttribute("city", city);
		return "rental";
	}
	
	@GetMapping(path = "/saverental")
	public String saveRent(@RequestParam int carId, @RequestParam String rental_start, 
			@RequestParam String rental_finish, @RequestParam String city_return) throws ParseException {
		
		
		Authentication authentication = userAuthentication.getAuthentication();
		MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
		
		String city_pickup = carRepository.findCarByCarId(carId).getCity();
		
		Rental rent = new Rental(myUserDetails.getUserId(), carId, rental_start, rental_finish, city_pickup, city_return);	
		rentalRepository.save(rent);

		return "redirect:/cars/get";
	}
}
