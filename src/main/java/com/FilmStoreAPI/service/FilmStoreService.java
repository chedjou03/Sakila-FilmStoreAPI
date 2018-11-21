package com.FilmStoreAPI.service;

import java.util.List;

import com.FilmStoreAPI.Entity.CustomerData.Address;
import com.FilmStoreAPI.Entity.CustomerData.City;
import com.FilmStoreAPI.Entity.CustomerData.Country;
import com.FilmStoreAPI.Entity.Inventory.Actor;

public interface FilmStoreService {

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

}
