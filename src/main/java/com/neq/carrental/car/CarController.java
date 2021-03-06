package com.neq.carrental.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neq.carrental.office.CarOffice;

/**
 * klasa kontrolera odbierająca zapytania użytkownika
 * i wysyłająca odpowiedzi na dane żądanie - związane z samochodami
 */
@Controller
@RequestMapping(path = "/cars")
public class CarController {

	@Autowired
	private CarRepository carRepository;

	private Iterable<CarOffice> cars;
	
	/**
	 * @param sortMethod parametr określający jaka metoda ma być zastosowana do sortowania danych o samochodach
	 * @return strona jsp "car" listująca samochody dostępne w bazie
	 */
	@GetMapping(path = "/get")
	public String getCars(@RequestParam(defaultValue = "ASC", required = false) String sortMethod, ModelMap model) {
		
		if(sortMethod.equals("ASC"))
			cars = carRepository.findCarOfficeByPriceAsc();
		else
			
			cars = carRepository.findCarOfficeByPriceDesc();
		
		model.addAttribute("cars", cars);
		
		return "car";
	}

	/**
	 * 
	 * @param type parametr określający jaki typ samochodu ma zostać odnaleziony w bazie
	 * @param modelMap
	 * @return  strona jsp "car" listująca samochody dostępne w bazie
	 */
	@GetMapping(path = "/get", params = "type")
	public String getCarsByType(@RequestParam String type, ModelMap modelMap) {

		cars = carRepository.findCarByType(type);
		modelMap.addAttribute("cars", cars);
		return "car";
	}

	/**
	 * 
	 * @param brand parametr określający jaka marka samochodu ma zostać odnaleziona w bazie 
	 * @return strona jsp "car" listująca samochody dostępne w bazie
	 */
	@GetMapping(path = "/get", params = "brand")
	public String getCarsByBrand(@RequestParam String brand, ModelMap modelMap) {

		cars = carRepository.findCarByBrand(brand);
		modelMap.addAttribute("cars", cars);
		return "car";
	}
	
	/**
	 * 
	 * @param model parametr określający jaki model samochodu ma zostać odnaleziony w bazie
	 * @return strona jsp "car" listująca samochody dostępne w bazie 
	 */
	@GetMapping(path = "/get", params = "model")
	public String getCarsByModel(@RequestParam String model, ModelMap modelMap) {

		cars = carRepository.findCarByModel(model);
		modelMap.addAttribute("cars", cars);
		return "car";
	}
	
	/**
	 * 
	 * @param year parametr określający jaki rok produkcji samochodu ma zostać odnaleziony w bazie
	 * @return strona jsp "car" listująca samochody dostępne w bazie
	 */
	@GetMapping(path = "/get", params = "year")
	public String getCarsByYear(@RequestParam int year, ModelMap modelMap) {

		cars = carRepository.findCarByYear(year);
		modelMap.addAttribute("cars", cars);
		return "car";
	}
	
	/**
	 * 
	 * @param city parametr określający z jakiego miasta ma pochodzić samochód 
	 * @return strona jsp "car" listująca samochody dostępne w bazie
	 */
	@GetMapping(path = "/get", params = "city")
	public String getCarsByCity(@RequestParam String city, ModelMap modelMap) {

		cars = carRepository.findCarByCity(city);
		modelMap.addAttribute("cars", cars);
		return "car";
	}

}
