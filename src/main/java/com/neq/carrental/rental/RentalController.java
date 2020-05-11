package com.neq.carrental.rental;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/rental")
public class RentalController {

	@Autowired
	private RentalRepository rentalRepository;

	@GetMapping(path = "/get")
	@ResponseBody
	public Iterable<Rental> getRental() {
		return rentalRepository.findAll();
	}

	@GetMapping(path = "/save")
	@ResponseBody
	public void saveRental() {

		Rental rental1 = new Rental();
		rental1.setCar_id(1);
		rental1.setCustomer_id(1);
		rental1.setPickup_city("warszawa");
		rental1.setReturn_city("warszawa");
		rental1.setRental_start_date(new Date(1590105600000l));
		rental1.setRental_finish_date(new Date(1590108600000l));

		rentalRepository.save(rental1);
	}

	@GetMapping(path = "/rentacar")
	public String rentACar(@RequestParam String id) {

		return "rent";
	}
}
