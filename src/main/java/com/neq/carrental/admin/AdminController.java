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

/**
 * klasa kontrolera odbierająca zapytania użytkownika
 * i wysyłająca odpowiedzi na dane żądanie
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {

	@Autowired
	private CarRepository carRepository;
	
		/**
		 * 
		 * @return strona jsp "admin" która zawiera informacje dotyczące panelu administratora
		 */
		@GetMapping(path = "")
		public String getAdminPage()
		{
			return "admin";
		}
		
		/**
		 * metoda inicjuje nowy model jakim jest samochód z domyślnymi wartościami i przekierowywuje na dany widok
		 * @return strona jsp "addcar" która zawiera formularz do wypełnienia w celu dodania samochodu do bazy danych
		 */
		@GetMapping(path="/addcar")
		public String getAddCarPage(ModelMap model)
		{
			model.addAttribute("car", new Car(1,"sport","audi","rs5",2020,(short)200,(byte)5,1000,(byte)1));
			return "addcar";
		}
		
		/**
		 * metoda dodaje do bazy danych podany jako parametr samochód 
		 * @param car model samochód
		 * @return przekierowanie do strony startowej administratora
		 */
		@RequestMapping(value = "/addcar", method = RequestMethod.POST)
		public String  addCar(ModelMap model, Car car)
		{	
			carRepository.save(car);
			
			String alert = "Dodano samochod."; 
			model.addAttribute("alert", alert);
				
			return "redirect:/admin";
		}
		
		/**
		 * metoda usuwa z bazy danych samochod o podanym identyfikatorze
		 * @param carId numer identyfikacyjny samochodu do usunięcia
		 * @return przekierowanie do strony startowej administratora
		 */
		@GetMapping(path = "/deletecar")
		public String addCar(ModelMap model, @RequestParam int carId) {

			carRepository.deleteById(carId);
			
			String alert = "Usunieto samochod o id =" + carId + ".";
			model.addAttribute("alert", alert);

			return "redirect:/admin";
		}
}
