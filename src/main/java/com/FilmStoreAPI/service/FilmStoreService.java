package com.FilmStoreAPI.service;

import java.util.List;

import com.FilmStoreAPI.entity.Country;

public interface FilmStoreService {

	List<Country> getCountries();

	Country getCountry(Integer theCountryId);

	void addCountry(Country theCountry);

	Long getCountCountryByName(String theCountryName);

	void deleteCountry(Integer theCountryId);

}
