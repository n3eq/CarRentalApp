package com.neq.carrental.rental;

import java.text.ParseException;
import java.util.List;

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
	
	/**
	 * @return strona jsp z widokiem wszystkich wypożyczeń dokonanych przez użytkownika
	 */
	@GetMapping(path = "/myrentals")
	public String getMyRentals(ModelMap model)
	{
		Authentication authentication = userAuthentication.getAuthentication();
		MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
			
		List<CarAndRental> rentals = rentalRepository.getMyRentalsInfo(userDetails.getUserId());
		
		model.addAttribute("rentals", rentals);
		
		return "myrentals";
	}
	
	/**
	 * 
	 * @param id prarametr określający identyfikator samochodu
	 * @param city parametr określający miasto w którm samochód się znajduje
	 * @return strona jsp główna strona wypożyczeń
	 */
	@GetMapping(path = "/rentacar")
	public String rentACar(@RequestParam String id, @RequestParam String city, ModelMap model) {
		
		model.addAttribute("carId", id);
		model.addAttribute("city", city);
		return "rental";
	}
	
	/**
	 * metoda do zapisywania w bazie informacji na temat wypożczenia
	 * @param carId parametr określający identifikator samochodu
	 * @param rental_start parametr określający date początkową wypożyczenia
	 * @param rental_finish parametr określający date zakończenia wypożyczenia
	 * @param city_return paramter określający miasto zwrotu samochodu
	 * @throws ParseException
	 */
	@GetMapping(path = "/saverental")
	public String saveRent(@RequestParam int carId, @RequestParam String rental_start, 
			@RequestParam String rental_finish, @RequestParam String city_return, ModelMap model) throws ParseException {
		
		
		Authentication authentication = userAuthentication.getAuthentication();
		MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
		
		if(rentalRepository.getAmountOfRentalsByUserId(myUserDetails.getUserId()) >= 2)
		{
			String alert = "ALERT - nie mozna wypozyczyc wiecej niz 2 samochody naraz na jednego klienta, twoje zadanie nie zostalo zrealizowane.";
			model.addAttribute("alert", alert);
			return "redirect:/cars/get";
		}
			
		
		carRepository.subtractCarAvaliable(carId);
		
		String city_pickup = carRepository.findCarByCarId(carId).getCity();
		
		Rental rent = new Rental(myUserDetails.getUserId(), carId, rental_start, rental_finish, city_pickup, city_return);	
		rentalRepository.save(rent);
		
		String alert = "Samochod zostal dodany do twojej listy.";
		model.addAttribute("alert", alert);
		
		return "redirect:/cars/get";
	}
	
	/**
	 * metoda do anulowania wypożyczenia
	 * @param carId parametr określający identyfikator samochodu
	 * @return
	 */
	@GetMapping(path = "/cancel")
	public String cancelRent(@RequestParam int carId){
		
		rentalRepository.deleteRentalById(carId);
		
		carRepository.addCarAvaliable(carId);
		
		return "redirect:/rental/myrentals";
	}
}
