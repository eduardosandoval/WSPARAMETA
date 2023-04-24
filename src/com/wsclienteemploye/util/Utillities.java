package com.wsclienteemploye.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Utillities {
	
    //Method to calculate time
	public String validAge(String date) {
		String result = "";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			LocalDate fechaNac = LocalDate.parse(date, fmt);
			LocalDate ahora = LocalDate.now();
			Period periodo = Period.between(fechaNac, ahora);
			result = "AGE- " + periodo.getYears() + "Months- " + periodo.getMonths() + "Days- " + periodo.getDays();
		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;

	}
}
