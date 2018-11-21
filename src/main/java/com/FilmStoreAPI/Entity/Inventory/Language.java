package com.FilmStoreAPI.Entity.Inventory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private Integer languageId;
	
	@Column(name = "name")
	private String languageName;
	
	@Column(name = "last_update")
	private Date languageLastUpdate;
	
	
	public Language() {
		super();
	}


	public Language(Integer languageId, String languageName, Date languageLastUpdate) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
		this.languageLastUpdate = languageLastUpdate;
	}


	public Integer getLanguageId() {
		return languageId;
	}


	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}


	public String getLanguageName() {
		return languageName;
	}


	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}


	public Date getLanguageLastUpdate() {
		return languageLastUpdate;
	}


	public void setLanguageLastUpdate(Date languageLastUpdate) {
		this.languageLastUpdate = languageLastUpdate;
	}


	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", languageName=" + languageName + ", languageLastUpdate="
				+ languageLastUpdate + "]";
	}
	
}
