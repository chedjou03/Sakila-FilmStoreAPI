package com.FilmStoreAPI.dao;

import java.util.List;

import com.FilmStoreAPI.Entity.CustomerData.Address;
import com.FilmStoreAPI.Entity.CustomerData.City;
import com.FilmStoreAPI.Entity.CustomerData.Country;
import com.FilmStoreAPI.Entity.Inventory.Actor;
import com.FilmStoreAPI.Entity.Inventory.Category;
import com.FilmStoreAPI.Entity.Inventory.Language;

public interface FilmStoreDAO 
{

	List<Country> getCountries();

	Country getCountry(Integer theCountryId);

	void addCountry(Country theCountry);

	Long getCountCountryByName(String theCountryName);

	void deleteCountry(Integer theCountryId);

	List<City> getCities();

	City getCity(Integer theCityId);

	void addCity(City theCity);

	boolean isCityAlreadyExistedInCountry(String theCityName, Country theCountry);

	void deleteCity(Integer theCityId);

	List<Address> getAddresses();

	Address getAddress(Integer theAddressId);

	List<City> getCitiesOfCountry(Country theCountry);

	List<Address> getAddressesOfCity(City theCity);

	void addAddress(Address theAddress);

	void deleteAddress(Integer theAddressId);

	List<Actor> getActors();

	Actor getActor(Integer theActorId);

	boolean actorWithLastNameAndFirstNameAlreadyExisted(String actorFirstName, String actorLastName);

	void addActor(Actor theActor);

	void deleteActor(Integer theActorId);

	List<Category> getCategories();

	Category getCategory(Integer theCategoryId);

	boolean isCategoryWithThisNameAlreadyExisted(String theCategoryName);

	void addCategory(Category theCategory);

	void deleteCategory(Integer theCategoryId);

	List<Language> getLanguages();

	Language getLanguage(Integer theLanguageId);

	void addLanguage(Language theLanguage);

	boolean isLanguageNameAlreadyExisted(String theLanguageName);

	void deleteLanguage(Integer theLanguageId);

}
