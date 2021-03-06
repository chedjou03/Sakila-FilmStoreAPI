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

import com.FilmStoreAPI.Entity.CustomerData.Address;
import com.FilmStoreAPI.Entity.CustomerData.City;
import com.FilmStoreAPI.Entity.CustomerData.Country;
import com.FilmStoreAPI.Entity.Inventory.Actor;
import com.FilmStoreAPI.Entity.Inventory.Category;
import com.FilmStoreAPI.Entity.Inventory.Film;
import com.FilmStoreAPI.Entity.Inventory.Language;
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
	
	//add mapping for GET /actors - get all the actors
	@GetMapping("/actors")
	public List<Actor> getActors()
	{			
		return filmStoreService.getActors();
	}
	
	//add mapping for GET  /actors/{theActorId} - get a single Actor
	@GetMapping("/actors/{theActorId}")
	public Actor getActor(@PathVariable Integer theActorId)
	{		
		Actor theActor = filmStoreService.getActor(theActorId);
		if(theActor == null)
		{
		   	throw new EntityNotFoundException("No Actor with ID: "+theActorId);
	    }
		return theActor;
	}
	
	//add the mapping for POST /actors - create a new Actor 
	@PostMapping("/actors")
	public Actor addActor(@RequestBody Actor theActor)
	{	
		if(actorWithLastNameAndFirstNameAlreadyExisted(theActor.getActorFirstName(),theActor.getActorLastName()))
		{
			throw new EntityNotFoundException("Actor with name "+theActor.getActorFirstName()+" "+theActor.getActorLastName()+" already exist");
		}
		filmStoreService.addActor(theActor);
		return theActor;
	}

	//tell us if an actor with actorFirstName and actorLastName alreafy existed
	private boolean actorWithLastNameAndFirstNameAlreadyExisted(String actorFirstName, String actorLastName) {
		return filmStoreService.actorWithLastNameAndFirstNameAlreadyExisted( actorFirstName,  actorLastName);
	}
	
	//add the mapping for PUT /actors - update an actor
	@PutMapping("/actors")
	public Actor updateActor(@RequestBody Actor theActor)
	{
		filmStoreService.addActor(theActor);
		return theActor;
	}
	
	//add the mapping for DELETE /actors/{theActorId} - delete an actor
	@DeleteMapping("/actors/{theActorId}")
	public String deleteActor(@PathVariable Integer theActorId)
	{
		filmStoreService.deleteActor(theActorId);
		return "Deleted Actor id:"+theActorId;
	}
	
	//add mapping for GET /categories - get all the categories
	@GetMapping("/categories")
	public List<Category> getCategories()
	{			
		return filmStoreService.getCategories();
	}
	
	//add mapping for GET  /categories/{theCategoriesId} - get a single category
	@GetMapping("/categories/{theCategoryId}")
	public Category getCategory(@PathVariable Integer theCategoryId)
	{		
		Category theCategory = filmStoreService.getCategory(theCategoryId);
		if(theCategory == null)
		{
			 throw new EntityNotFoundException("No Category with ID: "+theCategoryId);
		}
		return theCategory;
	}
	
	//add the mapping for POST /categories - create a new categories 
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category theCategory)
	{	
		if(isCategoryWithThisNameAlreadyExisted(theCategory.getCategoryName()))
		{
			throw new EntityNotFoundException("Category with name "+theCategory.getCategoryName()+" already exist");
		}
		filmStoreService.addCategory(theCategory);
		return theCategory;
	}

	private boolean isCategoryWithThisNameAlreadyExisted(String theCategoryName) {
		return filmStoreService.isCategoryWithThisNameAlreadyExisted(theCategoryName);
	}
	
	//add the mapping for PUT /categories - update a category
	@PutMapping("/categories")
	public Category updateCategory(@RequestBody Category theCategory)
	{
		filmStoreService.addCategory(theCategory);
		return theCategory;
	}
	
	//add the mapping for DELETE /categories/{theCategoriesId} - delete a category
	@DeleteMapping("/categories/{theCategoryId}")
	public String deleteCategory(@PathVariable Integer theCategoryId)
	{
		filmStoreService.deleteCategory(theCategoryId);
		return "Deleted Categeory id:"+theCategoryId;
	}
	
	//add mapping for GET /languages - get all the language
	@GetMapping("/languages")
	public List<Language> getLanguages()
	{			
		return filmStoreService.getLanguages();
	}
	
	//add mapping for GET  /categories/{theCategoriesId} - get a single category
	@GetMapping("/languages/{theLanguageId}")
	public Language getLanguage(@PathVariable Integer theLanguageId)
	{		
		Language theLanguage = filmStoreService.getLanguage(theLanguageId);
		if(theLanguage == null)
		{
			 throw new EntityNotFoundException("No Language with ID: "+theLanguageId);
		}
		return theLanguage;
	}
	
	//add mapping for POST/languages - create a new language
	@PostMapping("/languages")
	public Language addLanguage(@RequestBody Language theLanguage)
	{
		if(isLanguageNameAlreadyExisted(theLanguage.getLanguageName()))
		{
			throw new EntityAlreadyExistedException("Language "+theLanguage.getLanguageName()+" already existed");
		}
		filmStoreService.addLanguage(theLanguage);
		return theLanguage;
	}

	private boolean isLanguageNameAlreadyExisted(String theLanguageName) {
		return filmStoreService.isLanguageNameAlreadyExisted(theLanguageName);
	}
	
	//add mapping for PUT/languages - update a language
	@PutMapping("/languages")
	public Language updateLanguage(@RequestBody Language theLanguage)
	{
		filmStoreService.addLanguage(theLanguage);
		return theLanguage;
	}
	
	//add the mapping for DELETE /language/{theLanguageId} - delete a Language
	@DeleteMapping("/languages/{theLanguageId}")
	public String deleteLanguage(@PathVariable Integer theLanguageId)
	{
		filmStoreService.deleteLanguage(theLanguageId);
		return "Deleted Language id:"+theLanguageId;
	}
	
	//add mapping for GET /films - get all the films
	@GetMapping("/films")
	public List<Film> getFlims()
	{			
		return filmStoreService.getFlims();
	}
	
	//add mapping for GET  /films/{theFilmId} - get a single film
	@GetMapping("/films/{theFilmId}")
	public Film getFilm(@PathVariable Integer theFilmId)
	{		
		Film theFilm = filmStoreService.getFilm(theFilmId);
		if(theFilm == null)
		{
			throw new EntityNotFoundException("No Film with ID: "+theFilmId);
		}
		return theFilm;
	}
	
	//add mapping for POST/films - create a new film
	@PostMapping("/films")
	public Film addFilm(@RequestBody Film theFilm)
	{
		if(isFilmWithTitleAlreadyReleaseThisYear(theFilm.getFilmTitle(),theFilm.getFilmReleaseYear()))
		{
			throw new EntityAlreadyExistedException("Film with title "+theFilm.getFilmTitle()+" was already released in "+theFilm.getFilmReleaseYear());
		}
		filmStoreService.addFilm(theFilm);
		return theFilm;
	}

	private boolean isFilmWithTitleAlreadyReleaseThisYear(String theFilmTitle, Integer theFilmReleaseYear) 
	{
		return filmStoreService.isFilmWithTitleAlreadyReleaseThisYear(theFilmTitle,theFilmReleaseYear);
	}
	
	//add mapping for PUT/films - update a film
	@PutMapping("/films")
	public Film updateFilm(@RequestBody Film theFilm)
	{
		filmStoreService.addFilm(theFilm);
		return theFilm;
	}
	
	//add the mapping for DELETE /films/{theFilmId} - delete a film
	@DeleteMapping("/films/{theFilmId}")
	public String deleteFilm(@PathVariable Integer theFilmId)
	{
		filmStoreService.deleteFilm(theFilmId);
		return "Deleted Film id:"+theFilmId;
	}
}
