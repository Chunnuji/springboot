package com.example.demo;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.Country;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.services.CountryService;

@SpringBootTest(classes= {MakitoUnitTest.class})
public class MakitoUnitTest {
	
	@Mock
	CountryRepository countryRepo;
	
	@InjectMocks
	CountryService countryService;
	
	public List<Country> countryList;
	
	@Test
	@Order(1)
	public void test_getAllCountries() {
		List<Country> countryList = new ArrayList<Country>();
		countryList.add(new Country(1,"India","New Delhi"));
		countryList.add(new Country(2,"Nepal","Kathmandu"));
		
		when(countryRepo.findAll()).thenReturn(countryList);
		assertEquals(2,countryService.getCountries().size());
	}

	private boolean assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		if (i==size) {
			return true;
		}
		return false;
	}


}
