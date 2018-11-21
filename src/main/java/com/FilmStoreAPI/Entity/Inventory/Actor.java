package com.FilmStoreAPI.Entity.Inventory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	private Integer actorId;
	
	@Column(name = "first_name")
	private String actorFirstName;
	
	@Column(name = "last_name")
	private String actorLastName;
	
	@Column(name = "last_update")
	private Date actorLastUpdate;
	
	public Actor() {
		super();
	}
	
	public Actor(Integer actorId, String actorFirstName, String actorLastName, Date actorLastUpdate) {
		super();
		this.actorId = actorId;
		this.actorFirstName = actorFirstName;
		this.actorLastName = actorLastName;
		this.actorLastUpdate = actorLastUpdate;
	}
	
	public Integer getActorId() {
		return actorId;
	}
	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}
	public String getActorFirstName() {
		return actorFirstName;
	}
	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}
	public String getActorLastName() {
		return actorLastName;
	}
	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
	}
	public Date getActorLastUpdate() {
		return actorLastUpdate;
	}
	public void setActorLastUpdate(Date actorLastUpdate) {
		this.actorLastUpdate = actorLastUpdate;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorFirstName=" + actorFirstName + ", actorLastName=" + actorLastName
				+ ", actorLastUpdate=" + actorLastUpdate + "]";
	}
	

}
