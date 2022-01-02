package com.example.exercises;


import java.util.stream.Stream;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;


import static java.util.Comparator.comparing;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise6 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Sort the countries by number of their cities in descending order 
		Stream<Country> countries	= countryDao.findAllCountries()
					.stream()
					.sorted(
							comparing(country -> country.getCities().size()));
					
		countries.toList().forEach(c -> System.out.printf("%20s : %3\n ",c.getName()));
	}

}
