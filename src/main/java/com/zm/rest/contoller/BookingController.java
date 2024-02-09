package com.zm.rest.contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zm.rest.entity.Passenger;
import com.zm.rest.entity.Ticket;
import com.zm.rest.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/irctc")
public class BookingController {

	@Autowired
	private BookingService bookingSerive;

	@PostMapping(value = "/book/ticket",
//			produces = { MediaType.APPLICATION_XML_VALUE }
			produces = { "application/json" , "application/xml"}
	        )
	public ResponseEntity<?> bookNewTicket(@Valid @RequestBody Passenger passenger) {

		Ticket ticket = bookingSerive.bookNewTicket(passenger);
		Map<String, Object> resp = new HashMap<>();
		resp.put("data", ticket);
		
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	@GetMapping("/search/ticket/{pnr}")
	public ResponseEntity<?> getTicketDetails(@PathVariable String pnr) {

		Ticket ticket = bookingSerive.getBookDetails(pnr);
		Map<String, Object> resp = new HashMap<>();
		if (ticket == null) {
			resp.put("message", "NO TICKET FOUND WITH PNR " + pnr);
			return new ResponseEntity("NO TICKET FOUND WITH PNR " + pnr, HttpStatus.BAD_REQUEST);
		} else {
			resp.put("data", ticket);
			return new ResponseEntity<>(ticket, HttpStatus.OK);
		}

	}
}
