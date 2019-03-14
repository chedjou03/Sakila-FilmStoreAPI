package com.FilmStoreAPI.Entity.Inventory;

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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.category", cascade=CascadeType.ALL)
	private List<FilmCategory> filmCategories = new ArrayList<FilmCategory>();
	
	
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
	

	public List<FilmCategory> getFilmCategories() {
		return filmCategories;
	}

	public void setFilmCategories(List<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryLastUpdate="
				+ categoryLastUpdate + "]";
	}


}
