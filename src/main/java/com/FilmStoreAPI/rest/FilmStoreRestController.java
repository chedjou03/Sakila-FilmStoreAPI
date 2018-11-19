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

import com.FilmStoreAPI.entity.Address;
import com.FilmStoreAPI.entity.City;
import com.FilmStoreAPI.entity.Country;
import com.FilmStoreAPI.error.EntityAlreadyExistedException;
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
	
	
	
	//add the mapping for GET /cities - get List of cities
	@GetMapping("/cities")
	public List<City> getCities()
	{
		return filmStoreService.getCities();
	}
	
	//add mapping for GET  /cities/{theCityId} - get a single city
	@GetMapping("/cities/{theCityId}")
	public City getCity(@PathVariable Integer theCityId)
	{		
	    City theCity = filmStoreService.getCity(theCityId);
	    if(theCity == null)
	    {
	    	throw new EntityNotFoundException("No City with ID: "+theCityId);
	    }
		return theCity;
	}
	
	//add mapping  for POST /cities - create a new city
	@PostMapping("/cities")
	public City addCity(@RequestBody City theCity)
	{
		if(isCityAlreadyExistedInCountry(theCity.getCityName(),theCity.getCityCountry()))
		{
			throw new EntityAlreadyExistedException("City "+theCity.getCityName()+" already existed in country "+theCity.getCityCountry().getCountryName());
		}
		filmStoreService.addCity(theCity);
		return theCity;
	}

	
	private boolean isCityAlreadyExistedInCountry(String theCityName, Country theCountry) {
		return filmStoreService.isCityAlreadyExistedInCountry(theCityName,theCountry);
	}
	
	//add the mapping to PUT /cities - update a city
	@PutMapping("/cities")
	public City updateCity(@RequestBody City theCity)
	{	
		filmStoreService.addCity(theCity);
		return theCity;
	}
	
	//add mapping for DELETE /cities/{theCityId} - delete a city
	@DeleteMapping("/cities/{theCityId}")
	public String deleteCity(@PathVariable Integer theCityId)
	{
		filmStoreService.deleteCity(theCityId);
		return "Deleted City id:"+theCityId;
	}
	
	//add mapping for GET /citiesOfCountry/{theCountryId}
	@GetMapping("/citiesOfCountry/{theCountryId}")
	public List<City> getCitiesOfCountry(@PathVariable Integer theCountryId)
	{
		Country theCountry = filmStoreService.getCountry(theCountryId);
		if(theCountry == null)
		{
			throw new EntityNotFoundException("NO Country with Id: "+theCountryId);
		}
		return filmStoreService.getCitiesOfCountry(theCountry);
	}
	
	//add mapping for GET /addresses - get all the address
	@GetMapping("/addresses")
	public List<Address> getAddresses()
	{
		return filmStoreService.getAddresses();
	}
	
	//add mapping for GET /addresses/{theAddressId} - get  single address
	@GetMapping("/addresses/{theAddressId}")
	public Address getAddress(@PathVariable Integer theAddressId)
	{
		Address theAddress = filmStoreService.getAddress(theAddressId);
		if(theAddress == null)
		{
			throw new EntityNotFoundException("No Address with Id: "+theAddressId);
		}
		return theAddress;
	}
	
	//add mapping for GET /addressesOfCity/{theCityId} - get list of address of a city
	@GetMapping("/addressesOfCity/{theCityId}")
	public List<Address> getAddressesOfCity(@PathVariable Integer theCityId)
	{
		City theCity = getCity(theCityId);
		if(theCity == null)
		{
			throw new EntityNotFoundException("No City with ID: "+theCityId);
		}
		List<Address> addresses = filmStoreService.getAddressesOfCity(theCity);
		return addresses;	
	}
	
	//add mapping for POST /addresses - create  a new address
	@PostMapping("/addresses")
	public Address addAddress(@RequestBody Address theAddress)
	{
		filmStoreService.addAddress(theAddress);
		return theAddress;
	}
	
	//add mapping for PUT /addresses - update an address
	@PutMapping("/addresses")
	public Address updateAddress(@RequestBody Address theAddress)
	{
		filmStoreService.addAddress(theAddress);
		return theAddress;
	}
	
	//add mapping for DELETE /addresses/{theAddressId} - delete an address
	@DeleteMapping("/addresses/{theAddressId}")
	public String deleteAddress(@PathVariable Integer theAddressId)
	{
		Address theAddress = filmStoreService.getAddress(theAddressId);
		if(theAddress == null)
		{
			throw new EntityNotFoundException("No Address with Id: "+theAddressId);
		}
		filmStoreService.deleteAddress(theAddressId);
		return "Deleted Address id:"+theAddressId;
	}
}
