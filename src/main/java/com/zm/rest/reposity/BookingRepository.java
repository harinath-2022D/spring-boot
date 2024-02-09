package com.zm.rest.reposity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zm.rest.entity.Ticket;

@Repository
public class BookingRepository {
	
	private Map<String , Ticket> map = new HashMap<>();
	List<Ticket> ticketList = new ArrayList<>();
	
	public boolean save(Ticket ticket) {
		map.put(ticket.getTicketId(), ticket);
//		ticketList.add(ticket);
		System.out.println("new Ticket added : " + ticket.getTicketId());
		return true;
	}
	
	public Ticket findById(String id) {
		Ticket ticket =  map.get(id);
//		Ticket ticket = ticketList.stream().filter(tic -> tic.equals(id)).findAny().orElse(null);
		return ticket;
	}
}
