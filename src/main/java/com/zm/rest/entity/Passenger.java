package com.zm.rest.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Passenger {
	
	@NotBlank(message = "provide passenger name")
	private String passengerName;
	
	@NotNull(message = "dateOfJourney should be selected")
	private LocalDate dateOfJourney;
	
	@NotNull(message = "provide 5 digit train number")
	private Integer trainNum;
	
	@NotBlank
	@Size(min = 3, max = 20, message = "invalid fromStation")
	private String fromStation;

	@NotBlank
	@Size(min = 3, max = 20, message = "invalid toStation")
	private String toStation;
}
