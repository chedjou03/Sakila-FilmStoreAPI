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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city")
public class City 
{
	//define data fields with annotation
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Integer cityId;
	
	@Column(name = "city")
	private String cityName;
	
	@Column(name = "last_update")
	private Date cityLastUpdate;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "country_id")
	//@JsonIgnore
	private Country cityCountry;
	
	@OneToMany(	mappedBy = "addressCity",
		    fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
		  )
	@JsonIgnore
	private List<Address> addresses = new ArrayList<Address>();
	
	//define constructors
	public City(Integer cityId, String cityName, Date cityLastUpdate, Country country) 
	{
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityLastUpdate = cityLastUpdate;
		this.cityCountry = country;
	}


	//define setters and getters
	public City() {}


	public Integer getCityId() {
		return cityId;
	}


	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public Date getCityLastUpdate() {
		return cityLastUpdate;
	}


	public void setCityLastUpdate(Date cityLastUpdate) {
		this.cityLastUpdate = cityLastUpdate;
	}


	public Country getCityCountry() {
		return cityCountry;
	}


	public void setCityCountry(Country cityCountry) {
		this.cityCountry = cityCountry;
	}


	//define ToString method
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", cityLastUpdate=" + cityLastUpdate+ "]";
	}
	
}
