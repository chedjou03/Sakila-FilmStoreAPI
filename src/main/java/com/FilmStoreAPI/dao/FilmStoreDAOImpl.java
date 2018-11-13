package com.FilmStoreAPI.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FilmStoreAPI.entity.Country;

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
		Query theQuery = currentSession.createQuery("delete from Country where countryId=:theCountryId");
		theQuery.setParameter("theCountryId", theCountryId);		
		theQuery.executeUpdate();
	}

}
