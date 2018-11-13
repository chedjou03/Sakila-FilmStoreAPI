package com.FilmStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FilmStoreAPI.dao.FilmStoreDAO;
import com.FilmStoreAPI.entity.Country;

@Service
public class FilmStoreServiceImpl implements FilmStoreService 
{
	//inject the FilmStoreDAO
	@Autowired
	FilmStoreDAO filmStoreDAO;

	@Override
	@Transactional
	public List<Country> getCountries() 
	{	
		return filmStoreDAO.getCountries();
	}

	@Override
	@Transactional
	public Country getCountry(Integer theCountryId) 
	{
		return filmStoreDAO.getCountry(theCountryId);
	}

	@Override
	@Transactional
	public void addCountry(Country theCountry) {
		filmStoreDAO.addCountry(theCountry);
		
	}

	@Override
	@Transactional
	public Long getCountCountryByName(String theCountryName) {
		return filmStoreDAO.getCountCountryByName(theCountryName);
	}

	@Override
	@Transactional
	public void deleteCountry(Integer theCountryId) {
		filmStoreDAO.deleteCountry(theCountryId);
		
	}

}
