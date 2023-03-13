package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Country;
import com.example.demo.controllers.AddResponse;
import com.example.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepo;
	
	public List<Country> getCountries() {
		return countryRepo.findAll();
	}

	public Country getCountryById(int id) {
		return countryRepo.findById(id).get();
	}
	
	public Country getCountryByName(String countryName) {
		List<Country> countryList = countryRepo.findAll();
		
		Country country=null;
		
		for(Country c: countryList) {
			if (c.getCountryName().equals(countryName))
				country=c;
		}
		
		return country;
	}
	
	public Country addCountry(Country country) {
		country.setId(getMaxId());
		
		countryRepo.save(country);
		return country;
	}
	
	public int getMaxId() {
		return countryRepo.findAll().size()+1;
	}
	
	public Country updateCountry(Country country) {
		
		countryRepo.save(country);
		return country;
		
	}
	
	public AddResponse deleteCountry(int id) {
		countryRepo.deleteById(id);
		AddResponse deleteMsg = new AddResponse();
		deleteMsg.setId(id);
		deleteMsg.setMsg("Deleted Record.....");
		return deleteMsg;
		
	}

}
