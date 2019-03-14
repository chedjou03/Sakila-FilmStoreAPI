package com.FilmStoreAPI.Entity.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film implements java.io.Serializable
{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Integer filmId;
	
	
	@Column(name = "title")
	private String filmTitle;
	
	
	@Column(name = "description")
	private String filmDescription;
	
	
	@Column(name = "release_year")
	private Integer filmReleaseYear;
	
	
	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "language_id")	
	private Language filmLanguage;
	
	
	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "original_language_id")	
	private Language filmOriginalLanguage;
	

	@Column(name = "special_features")
	private String filmSpecialFeature;
	
	
	@Column(name = "rental_duration")
	private Integer filmRentalDuration;
	
	
	@Column(name = "rental_rate")
	private Double filmRentralRate;
	
	
	@Column(name = "length")
	private Integer filmLength;
	
	
	@Column(name = "replacement_cost")
	private Double filmReplacementCost;
	
	
	@Column(name = "rating")
	private String filmRating;
	
	@Column(name = "last_update")
	private Date filmLastUpdate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.film", cascade=CascadeType.ALL)
	private List<FilmCategory> filmCategories = new ArrayList<FilmCategory>();

	
	
	public Film() {
		super();
	}

	public Film(Integer filmId, String filmTitle, String filmDescription, Integer filmReleaseYear,
			Language filmLanguage, Language filmOriginalLanguage, Integer filmRentalDuration, Double filmRentralRate,
			Integer filmLength, Double filmReplacementCost, String filmRating, String filmSpecialFeature,
			Date filmLastUpdate) {
		super();
		this.filmId = filmId;
		this.filmTitle = filmTitle;
		this.filmDescription = filmDescription;
		this.filmReleaseYear = filmReleaseYear;
		this.filmLanguage = filmLanguage;
		this.filmOriginalLanguage = filmOriginalLanguage;
		this.filmRentalDuration = filmRentalDuration;
		this.filmRentralRate = filmRentralRate;
		this.filmLength = filmLength;
		this.filmReplacementCost = filmReplacementCost;
		this.filmRating = filmRating;
		this.filmSpecialFeature = filmSpecialFeature;
		this.filmLastUpdate = filmLastUpdate;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public String getFilmDescription() {
		return filmDescription;
	}

	public void setFilmDescription(String filmDescription) {
		this.filmDescription = filmDescription;
	}

	public Integer getFilmReleaseYear() {
		return filmReleaseYear;
	}

	public void setFilmReleaseYear(Integer filmReleaseYear) {
		this.filmReleaseYear = filmReleaseYear;
	}

	public Language getFilmLanguage() {
		return filmLanguage;
	}

	public void setFilmLanguage(Language filmLanguage) {
		this.filmLanguage = filmLanguage;
	}

	public Language getFilmOriginalLanguage() {
		return filmOriginalLanguage;
	}

	public void setFilmOriginalLanguage(Language filmOriginalLanguage) {
		this.filmOriginalLanguage = filmOriginalLanguage;
	}

	public Integer getFilmRentalDuration() {
		return filmRentalDuration;
	}

	public void setFilmRentalDuration(Integer filmRentalDuration) {
		this.filmRentalDuration = filmRentalDuration;
	}

	public Double getFilmRentralRate() {
		return filmRentralRate;
	}

	public void setFilmRentralRate(Double filmRentralRate) {
		this.filmRentralRate = filmRentralRate;
	}

	public Integer getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(Integer filmLength) {
		this.filmLength = filmLength;
	}

	public Double getFilmReplacementCost() {
		return filmReplacementCost;
	}

	public void setFilmReplacementCost(Double filmReplacementCost) {
		this.filmReplacementCost = filmReplacementCost;
	}

	public String getFilmRating() {
		return filmRating;
	}

	public void setFilmRating(String filmRating) {
		this.filmRating = filmRating;
	}

	public String getFilmSpecialFeature() {
		return filmSpecialFeature;
	}

	public void setFilmSpecialFeature(String filmSpecialFeature) {
		this.filmSpecialFeature = filmSpecialFeature;
	}

	public Date getFilmLastUpdate() {
		return filmLastUpdate;
	}

	public void setFilmLastUpdate(Date filmLastUpdate) {
		this.filmLastUpdate = filmLastUpdate;
	}
	
	public List<FilmCategory> getFilmCategories() {
		return filmCategories;
	}

	public void setFilmCategories(List<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", filmTitle=" + filmTitle + ", filmDescription=" + filmDescription
				+ ", filmReleaseYear=" + filmReleaseYear + ", filmLanguage=" + filmLanguage + ", filmOriginalLanguage="
				+ filmOriginalLanguage + ", filmRentalDuration=" + filmRentalDuration + ", filmRentralRate="
				+ filmRentralRate + ", filmLength=" + filmLength + ", filmReplacementCost=" + filmReplacementCost
				+ ", filmRating=" + filmRating + ", filmSpecialFeature=" +filmSpecialFeature
				+ ", filmLastUpdate=" + filmLastUpdate + "]";
	}

	
	
	
}
