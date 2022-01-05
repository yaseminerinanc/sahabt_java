package com.example.demo.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.dao.business.InMemoryWorldDao;
import com.example.demo.entity.Country;

@RestController
@RequestScope
// http://localhost:8200/world/api/v1/
@CrossOrigin("*")
public class WorldRestController {
	
	private InMemoryWorldDao memoWorldDao;

	public WorldRestController(InMemoryWorldDao memoWorldDao) {
	
		this.memoWorldDao = memoWorldDao;
	}
	
	@GetMapping(value="/continents")
	public Collection<String> getContinents(){
		
		return memoWorldDao.getAllContinents();
		
		
	}
	
	
	@GetMapping(value="/countries")
	public Collection<Country> getCountries(@RequestParam String continent){
		
		return memoWorldDao.findCountriesByContinent(continent);
		
	}

}
