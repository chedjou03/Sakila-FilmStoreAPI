package com.FilmStoreAPI.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;

@Entity
@Table(name = "address")
public class Address {
	
	//define data field and annotation 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;
	
	@Column(name = "address")
	private String addressName;
	
	@Column(name = "address2")
	private String addressName2;
	
	@Column(name = "district")
	private String addressDistrict;
	
	@Column(name = "postal_code")
	private String addressPostalCode;
	
	@Column(name = "phone")
	private String addressPhoneNumber;
	
	@Column(name = "last_update")
	private Date addressLastUpdate;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "city_id")
	private City addressCity;
	

	//define constructors
	public Address() {
		super();
	}
	public Address(Integer addressId, String addressName, String addressName2, String addressDistrict,
			String addressPostalCode, String addressPhoneNumber, Date addressLastUpdate, 
			City addressCity) {
		super();
		this.addressId = addressId;
		this.addressName = addressName;
		this.addressName2 = addressName2;
		this.addressDistrict = addressDistrict;
		this.addressPostalCode = addressPostalCode;
		this.addressPhoneNumber = addressPhoneNumber;
		this.addressLastUpdate = addressLastUpdate;
		this.addressCity = addressCity;
	}
	
	
	//define getters and setters
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressName2() {
		return addressName2;
	}
	public void setAddressName2(String addressName2) {
		this.addressName2 = addressName2;
	}
	public String getAddressDistrict() {
		return addressDistrict;
	}
	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}
	public String getAddressPostalCode() {
		return addressPostalCode;
	}
	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}
	public String getAddressPhoneNumber() {
		return addressPhoneNumber;
	}
	public void setAddressPhoneNumber(String addressPhoneNumber) {
		this.addressPhoneNumber = addressPhoneNumber;
	}
	public Date getAddressLastUpdate() {
		return addressLastUpdate;
	}
	public void setAddressLastUpdate(Date addressLastUpdate) {
		this.addressLastUpdate = addressLastUpdate;
	}
	
	public City getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(City addressCity) {
		this.addressCity = addressCity;
	}
	
	//define ToString method
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressName=" + addressName + ", addressName2=" + addressName2
				+ ", addressDistrict=" + addressDistrict + ", addressPostalCode=" + addressPostalCode
				+ ", addressPhoneNumber=" + addressPhoneNumber + ", addressLastUpdate=" + addressLastUpdate+ "]";
	}
	
}
