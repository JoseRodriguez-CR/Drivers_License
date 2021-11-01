package com.joserodriguez.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity 
@Table( name = "licenses" )
public class License {
	
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String number;
	private Date experationDate;
	private String state;
	
	@Column( updatable = false )
	private Date createdAt;
	private Date updatedAt;
	
	@OneToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "person_id"    )
	private Person person;
	
	//Constructor
	public License() {
		
	}

	//Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExperationDate() {
		return experationDate;
	}

	public void setExperationDate(Date experationDate) {
		this.experationDate = experationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	//runs the method right before the object is created
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	//runs a method when the object is modified
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	
}
