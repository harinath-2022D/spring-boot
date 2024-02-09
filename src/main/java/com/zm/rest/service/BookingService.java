package com.zm.rest.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.rest.entity.Passenger;
import com.zm.rest.entity.Ticket;
import com.zm.rest.reposity.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepo;

	public Ticket bookNewTicket(Passenger passenger) {
		LocalDate currDate = LocalDate.now();
		
		String ticketId = UUID.randomUUID().toString().substring(0,5);
		
		List<String> ticketStatusList = Arrays.asList("CNF", "W/L", "GNWL", "RAC");
		
		
		String ticketStatus = ticketStatusList.get(new Random().nextInt(ticketStatusList.size()));
		
//		Ticket ticket = Ticket.builder()
//				.dateOfBooking(currDate)
//				.dateOfJourney(passenger.getDateOfJourney())
//				.trainNum(passenger.getTrainNum())
//				.fromStation(passenger.getFromStation())
//				.toStation(passenger.getToStation())
//				.ticketId(ticketId)
//				.status(ticketStatus)
//				.fare(100.0d)
//				.passengerName(passenger.getPassengerName())
//				.build();
		
		Ticket ticket = new Ticket();
		ticket.setDateOfBooking(currDate);
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setFare(100.0);
		ticket.setTicketId(ticketId);
		ticket.setFromStation(passenger.getFromStation());
		ticket.setToStation(passenger.getToStation());
		ticket.setTrainNum(passenger.getTrainNum());
		ticket.setPassengerName(passenger.getPassengerName());
		ticket.setStatus(ticketStatus);
		
		bookingRepo.save(ticket);
		
		return ticket;
	}

	public Ticket getBookDetails(String pnr) {
		Ticket ticket = bookingRepo.findById(pnr);
		
		return ticket;
	}
	
	
}
