/*
 * Author: Gregory Palios
 */

package com.capstone.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// javax.validation.constraints is taken from jar files downloaded from hibernate.org/validator
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="suggestion")
public class Suggestion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="suggestion_id")
	private int id;
	
	@NotNull(message="Please enter a beer name")
	@Size(min=1, message="beer name is required")
	@Column(name="beer_name")
	private String beer;
	
	@Column(name="brewery")
	private String brewery;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="date", nullable = false, updatable = false)
	private Date date;
	
	@NotNull(message="Please enter a valid email")
	@Size(min=1, message=" email is required")
    @Email(regexp = ".+@.+\\..+|")
	@Column(name="email")
	private String email;
	
	public Suggestion() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeer() {
		return beer;
	}

	public void setBeer(String beer) {
		this.beer = beer;
	}

	public String getBrewery() {
		return brewery;
	}

	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Suggestion [id=" + id + ", beer=" + beer + ", brewery=" + brewery + ", date=" + date + ", email="
				+ email + "]";
	}
}
