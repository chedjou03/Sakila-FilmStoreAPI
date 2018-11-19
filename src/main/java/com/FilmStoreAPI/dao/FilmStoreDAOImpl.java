package com.FilmStoreAPI.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FilmStoreAPI.CustomerData.entity.Address;
import com.FilmStoreAPI.CustomerData.entity.City;
import com.FilmStoreAPI.CustomerData.entity.Country;

@Repository
public class FilmStoreDAOImpl implements FilmStoreDAO 
{
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Country> getCountries() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Country> theQuery = currentSession.createQuery("from Country order by countryName", Country.class);
		List<Country> countries = theQuery.getResultList();
		return countries;
		
	}

	@Override
	public Country getCountry(Integer theCountryId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Country theCountry = currentSession.get(Country.class, theCountryId);
		return theCountry;
	}

	@Override
	public void addCountry(Country theCountry) {
		Session currentSession = sessionFactory.getCurrentSession();
		theCountry.setCountryLastUpdate(new Date());
		currentSession.saveOrUpdate(theCountry);
		
	}

	@Override
	public Long getCountCountryByName(String theCountryName) {
		Long count = new Long(0);
		Session currentSession = sessionFactory.getCurrentSession();
		count =  (Long)currentSession.createQuery("select count(*) from Country where countryName = '"+theCountryName+"'").uniqueResult();
		return count;
	}

	@Override
	public void deleteCountry(Integer theCountryId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Country where countryId = :theCountryId");
		theQuery.setParameter("theCountryId", theCountryId);		
		theQuery.executeUpdate();
	}

	@Override
	public List<City> getCities() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<City> theQuery = currentSession.createQuery("from City ",City.class);
		List<City> cities = theQuery.getResultList();
		return cities;
	}

	@Override
	public City getCity(Integer theCityId) {
		Session currentSession = sessionFactory.getCurrentSession();
		City theCity = currentSession.get(City.class, theCityId);
		return theCity;
	}

	@Override
	public void addCity(City theCity) {
		Session currentSession = sessionFactory.getCurrentSession();
		theCity.setCityLastUpdate(new Date());
		currentSession.saveOrUpdate(theCity);
	}

	@Override
	public boolean isCityAlreadyExistedInCountry(String theCityName, Country theCountry) {
		boolean cityStatus = false;
		Session currentSession = sessionFactory.getCurrentSession();
		Query<City> theQuery = currentSession.createQuery("from City where cityName = :aCityName and cityCountry = :aCountry");
		theQuery.setParameter("aCityName", theCityName);
		theQuery.setParameter("aCountry", theCountry);
		List<City> tempCities = theQuery.getResultList();
		if(tempCities.size() > 0) 
		{
			cityStatus = true;
		}
		return cityStatus;
	}

	@Override
	public void deleteCity(Integer theCityId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from City where cityId = :aCityId");
		theQuery.setParameter("aCityId", theCityId);		
		theQuery.executeUpdate();
	}

	@Override
	public List<Address> getAddresses() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Address> theQuery = currentSession.createQuery("from Address", Address.class);
		List<Address> addresses = theQuery.getResultList();
		return addresses;
	}

	@Override
	public Address getAddress(Integer theAddressId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Address theAddress = currentSession.get(Address.class, theAddressId);
		return theAddress;
	}

	@Override
	public List<City> getCitiesOfCountry(Country theCountry) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<City> theQuery = currentSession.createQuery("from City where cityCountry = :aCountryId");
		theQuery.setParameter("aCountryId", theCountry);
		List<City> cities = theQuery.getResultList();
		return cities;
	}

	@Override
	public List<Address> getAddressesOfCity(City theCity) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Address> theQuery = currentSession.createQuery("from Address where addressCity = :aCity");
		theQuery.setParameter("aCity", theCity);
		List<Address> addresses = theQuery.getResultList();
		return addresses;
	}

	@Override
	public void addAddress(Address theAddress) {
		Session currentSession = sessionFactory.getCurrentSession();
		theAddress.setAddressLastUpdate(new Date());
		currentSession.saveOrUpdate(theAddress);	
	}

	@Override
	public void deleteAddress(Integer theAddressId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Address where addressId = :aAddressId");
		theQuery.setParameter("aAddressId", theAddressId);		
		theQuery.executeUpdate();
	}

}
