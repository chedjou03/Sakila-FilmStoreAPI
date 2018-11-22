package com.FilmStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FilmStoreAPI.Entity.CustomerData.Address;
import com.FilmStoreAPI.Entity.CustomerData.City;
import com.FilmStoreAPI.Entity.CustomerData.Country;
import com.FilmStoreAPI.Entity.Inventory.Actor;
import com.FilmStoreAPI.Entity.Inventory.Category;
import com.FilmStoreAPI.Entity.Inventory.Film;
import com.FilmStoreAPI.Entity.Inventory.Language;
import com.FilmStoreAPI.dao.FilmStoreDAO;

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

	@Override
	@Transactional
	public List<Actor> getActors() {
		return filmStoreDAO.getActors();
	}

	@Override
	@Transactional
	public Actor getActor(Integer theActorId) {
		return filmStoreDAO.getActor(theActorId);
	}

	@Override
	@Transactional
	public boolean actorWithLastNameAndFirstNameAlreadyExisted(String actorFirstName, String actorLastName) {
		return filmStoreDAO.actorWithLastNameAndFirstNameAlreadyExisted( actorFirstName,  actorLastName);
	}

	@Override
	@Transactional
	public void addActor(Actor theActor) {
		filmStoreDAO.addActor(theActor);
	}

	@Override
	@Transactional
	public void deleteActor(Integer theActorId) {
		filmStoreDAO.deleteActor(theActorId);	
	}

	@Override
	@Transactional
	public List<Category> getCategories() {
		return filmStoreDAO.getCategories();
	}

	@Override
	@Transactional
	public Category getCategory(Integer theCategoryId) {
		return filmStoreDAO.getCategory(theCategoryId);
	}

	@Override
	@Transactional
	public void addCategory(Category theCategory) {
		filmStoreDAO.addCategory(theCategory);
	}

	@Override
	@Transactional
	public boolean isCategoryWithThisNameAlreadyExisted(String theCategoryName) {
		return filmStoreDAO.isCategoryWithThisNameAlreadyExisted(theCategoryName);
	}

	@Override
	@Transactional
	public void deleteCategory(Integer theCategoryId) {
		filmStoreDAO.deleteCategory(theCategoryId);	
	}

	@Override
	@Transactional
	public List<Language> getLanguages() {
		return filmStoreDAO.getLanguages();
	}

	@Override
	@Transactional
	public Language getLanguage(Integer theLanguageId) {
		return filmStoreDAO.getLanguage(theLanguageId);
	}

	@Override
	@Transactional
	public void addLanguage(Language theLanguage) {
		filmStoreDAO.addLanguage(theLanguage);
		
	}

	@Override
	@Transactional
	public boolean isLanguageNameAlreadyExisted(String theLanguageName) {
		return filmStoreDAO.isLanguageNameAlreadyExisted(theLanguageName);
	}

	@Override
	@Transactional
	public void deleteLanguage(Integer theLanguageId) {
		filmStoreDAO.deleteLanguage(theLanguageId);		
	}

	@Override
	@Transactional
	public List<Film> getFlims() {
		return filmStoreDAO.getFlims();
	}

	@Override
	@Transactional
	public Film getFilm(Integer theFilmId) {
		return filmStoreDAO.getFilm(theFilmId);
	}

	@Override
	@Transactional
	public void addFilm(Film theFilm) {
		filmStoreDAO.addFilm(theFilm);
	}

	@Override
	@Transactional
	public boolean isFilmWithTitleAlreadyReleaseThisYear(String theFilmTitle, Integer theFilmReleaseYear) {
		return filmStoreDAO.isFilmWithTitleAlreadyReleaseThisYear(theFilmTitle, theFilmReleaseYear);
	}

	@Override
	@Transactional
	public void deleteFilm(Integer theFilmId) {
		filmStoreDAO.deleteFilm(theFilmId);
	}

}
