package com.FilmStoreAPI.Entity.Inventory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer categoryId;
	
	@Column(name = "name")
	private String categoryName;
	
	@Column(name = "last_update")
	private Date categoryLastUpdate;
	
	
	public Category(Integer categoryId, String categoryName, Date categoryLastUpdate) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryLastUpdate = categoryLastUpdate;
	}
	
	public Category() {	}
	
	
	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Date getCategoryLastUpdate() {
		return categoryLastUpdate;
	}


	public void setCategoryLastUpdate(Date categoryLastUpdate) {
		this.categoryLastUpdate = categoryLastUpdate;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryLastUpdate="
				+ categoryLastUpdate + "]";
	}


}
