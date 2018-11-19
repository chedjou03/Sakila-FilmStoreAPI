package com.FilmStoreAPI.dao;

import java.util.List;

import com.FilmStoreAPI.entity.Address;
import com.FilmStoreAPI.entity.City;
import com.FilmStoreAPI.entity.Country;

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

}