package com.FilmStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FilmStoreAPI.dao.FilmStoreDAO;
import com.FilmStoreAPI.entity.Address;
import com.FilmStoreAPI.entity.City;
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
		//List<Country> theCountries = filmStoreDAO.getCountries();
		
				//Hibernate.initialize(supplier.getIngredients());
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

	@Override
	@Transactional
	public List<City> getCities() {
		return filmStoreDAO.getCities();
	}

	@Override
	@Transactional
	public City getCity(Integer theCityId) {
		return filmStoreDAO.getCity(theCityId);
	}

	@Override
	@Transactional
	public void addCity(City theCity) {
		 filmStoreDAO.addCity(theCity);
	}

	@Override
	@Transactional
	public boolean isCityAlreadyExistedInCountry(String theCityName, Country theCountry) {
		return filmStoreDAO.isCityAlreadyExistedInCountry(theCityName, theCountry);
	}

	@Override
	@Transactional
	public void deleteCity(Integer theCityId) {
		filmStoreDAO.deleteCity(theCityId);
	}

	@Override
	@Transactional
	public List<Address> getAddresses() {
		return filmStoreDAO.getAddresses();
	}

	@Override
	@Transactional
	public Address getAddress(Integer theAddressId) {
		return filmStoreDAO.getAddress(theAddressId);
	}

	@Override
	@Transactional
	public List<City> getCitiesOfCountry(Country theCountry) {
		return filmStoreDAO.getCitiesOfCountry(theCountry);
	}

	@Override
	@Transactional
	public List<Address> getAddressesOfCity(City theCity) {
		return filmStoreDAO.getAddressesOfCity(theCity);
	}

	@Override
	@Transactional
	public void addAddress(Address theAddress) {
		filmStoreDAO.addAddress(theAddress);
		
	}

	@Override
	@Transactional
	public void deleteAddress(Integer theAddressId) {
		filmStoreDAO.deleteAddress(theAddressId);	
	}

}
