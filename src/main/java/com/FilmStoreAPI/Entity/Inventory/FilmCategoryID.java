package com.FilmStoreAPI.Entity.Inventory;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class FilmCategoryID implements java.io.Serializable {
	
	@ManyToOne
	private Film film;
	
	@ManyToOne
	private Category category;
	
	
	public FilmCategoryID() {
		super();
	}

	public FilmCategoryID(Film film, Category category) {
		super();
		this.film = film;
		this.category = category;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "FimlCategoryID [film=" + film + ", category=" + category + "]";
	}
	
	
	public boolean equals(Object obj) 
	{
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        FilmCategoryID that = (FilmCategoryID) obj;

        if (film != null ? !film.equals(that.film) : that.film != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null)
            return false;

        return true;
    }
	
	public int hashCode() 
	{
        int result;
        result = (film != null ? film.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
	
	

}
