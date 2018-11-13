package com.FilmStoreAPI.dao;

import java.util.List;

import com.FilmStoreAPI.entity.Country;

public interface FilmStoreDAO 
{

	List<Country> getCountries();

	Country getCountry(Integer theCountryId);

	void addCountry(Country theCountry);

	Long getCountCountryByName(String theCountryName);

	void deleteCountry(Integer theCountryId);

}
