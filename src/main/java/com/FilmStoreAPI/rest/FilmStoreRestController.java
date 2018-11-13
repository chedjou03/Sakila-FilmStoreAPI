package com.FilmStoreAPI.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FilmStoreAPI.entity.Country;
import com.FilmStoreAPI.error.EntityNotFoundException;
import com.FilmStoreAPI.service.FilmStoreService;

@RestController
@RequestMapping("/api")
public class FilmStoreRestController 
{

	//inject the filmStoreService
	@Autowired
	FilmStoreService filmStoreService;
	
	//add the mapping for GET /countries - get List of country
	@GetMapping("/countries")
	public List<Country> getCountries()
	{
		return filmStoreService.getCountries();
	}
	
	//add the mapping for GET /countries/{theCountryId} - get a single country
	@GetMapping("/countries/{theCountryId}")
	public Country getCountry(@PathVariable Integer theCountryId)
	{
		Country theCountry = filmStoreService.getCountry(theCountryId);
		if(theCountry == null)
		{
			throw new EntityNotFoundException("NO Country with Id: "+theCountryId);
		}
		return theCountry;
	}
	
	//return the number of occurrence of the country with the name passed in parameter
	public Long getCountCountryByName(String theCountryName)
	{
		Long count = filmStoreService.getCountCountryByName(theCountryName);
		return count;
	}
	
	
	//add the mapping for POST /countries - create a new Country 
	@PostMapping("/countries")
	public Country addCountry(@RequestBody Country theCountry)
	{	
		if(getCountCountryByName(theCountry.getCountryName()).intValue() > 1)//country with that name already exist
		{
			throw new EntityNotFoundException("Country with name "+theCountry.getCountryName()+" already exist");
		}
		//theCountry.setCountryId(0);
		filmStoreService.addCountry(theCountry);
		return theCountry;
	}
	
	//add the mapping to PUT /countries - update a country
	@PutMapping("/countries")
	public Country updateCustomer(@RequestBody Country theCountry)
	{	
		filmStoreService.addCountry(theCountry);
		return theCountry;
	}
	
	//add the mapping to DELETE /countries/{theCountryId} - detele a Country
	@DeleteMapping("/countries/{theCountryId}")
	public String deleteCountry(@PathVariable Integer theCountryId)
		{
			Country theCountry = filmStoreService.getCountry(theCountryId);
			if(theCountry == null)
			{
				throw new EntityNotFoundException("the Country Id:"+theCountryId+" not Found");
			}
			filmStoreService.deleteCountry(theCountryId);
			return "Deleted Country id:"+theCountryId;
		}
	
}
