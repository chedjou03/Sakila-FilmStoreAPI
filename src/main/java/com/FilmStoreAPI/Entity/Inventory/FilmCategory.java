package com.FilmStoreAPI.Entity.Inventory;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "film_category")
@AssociationOverrides({
		@AssociationOverride(name = "pk.film", joinColumns = @JoinColumn(name = "film_id")),
		@AssociationOverride(name = "pk.category", joinColumns = @JoinColumn(name = "category_id")) })
public class FilmCategory 
{
	@EmbeddedId
	private FilmCategoryID pk = new FilmCategoryID();
		
	@Temporal(TemporalType.DATE)
	@Column(name = "last_update", nullable = false, length = 10)
	private Date filmCategoryLastUpdate;

	
	
	public FilmCategoryID getPk() {
		return pk;
	}

	public void setPk(FilmCategoryID pk) {
		this.pk = pk;
	}

	public Date getFilmCategoryLastUpdate() {
		return filmCategoryLastUpdate;
	}

	public void setFilmCategoryLastUpdate(Date filmCategoryLastUpdate) {
		this.filmCategoryLastUpdate = filmCategoryLastUpdate;
	}
	
	@Transient
	public Film getFilm()
	{
		return pk.getFilm();
	}
	
	public void setFilm(Film theFilm)
	{
		pk.setFilm(theFilm);
	}
	
	@Transient
	public Category getCategory()
	{
		return pk.getCategory();
	}
	
	public void setCategory(Category theCategory)
	{
		pk.setCategory(theCategory);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FilmCategory that = (FilmCategory) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	

}
