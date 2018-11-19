package com.FilmStoreAPI.CustomerData.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="country")
public class Country {
	
	//define data field with annotation
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_id")
	private Integer countryId;
	
	@Column(name="country")
	private String countryName;
	
	@Column(name="last_update")
	private Date countryLastUpdate;
	
	@OneToMany(	mappedBy = "cityCountry",
			    fetch = FetchType.LAZY,
				cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
			  )
	@JsonIgnore
	private List<City> cities = new ArrayList<City>();
	
	//define constructor
	public Country(String country_name, Date last_update) {
		super();
		this.countryName = country_name;
		this.countryLastUpdate = last_update;
	}

	public Country() {
		super();
	}

	
	//define getters and setters
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Date getCountryLastUpdate() {
		return countryLastUpdate;
	}

	public void setCountryLastUpdate(Date countryLastUpdate) {
		this.countryLastUpdate = countryLastUpdate;
	}
	

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public void addCity(City theCity)
	{
		if(cities == null)
		{
			cities = new ArrayList<City>();
		}
		cities.add(theCity);
		theCity.setCityCountry(this);
	}

	
	//define the ToString 
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", countryLastUpdate="
				+ countryLastUpdate + ", cities=" + cities + "]";
	}
	

}
