package com.FilmStoreAPI.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	//define the ToString 
	@Override
	public String toString() {
		return "Country [country_id=" + countryId + ", country_name=" + countryName + ", last_update=" + countryLastUpdate
				+ "]";
	}

}
