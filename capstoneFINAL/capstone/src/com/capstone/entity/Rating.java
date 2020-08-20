/*
 * Author: Gregory Palios
 */

package com.capstone.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//javax.validation.constraints is taken from jar files downloaded from hibernate.org/validator
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="ratings")
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rating_id")
	private int id;
	
	//Reference: https://www.dineshonjava.com/spring-crud-example-using-one-to-one/
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="beer_id")
	private Beer beer;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="date", nullable = false, updatable = false)
	private Date date;
	
	@NotNull(message="Please enter a rating from 1-5")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=5, message="must be less than or equal to 5")
	@Column(name="rating")
	private int rating;
	
	@Column(name="tasting_notes")
	private String tastingNotes;
	
	public Rating() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Beer getBeer() {
		return beer;
	}

	public void setBeer(Beer beer) {
		this.beer = beer;
	}	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTastingNotes() {
		return tastingNotes;
	}

	public void setTastingNotes(String tastingNotes) {
		this.tastingNotes = tastingNotes;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", beer=" + beer + ", date=" + date + ", rating=" + rating + ", tastingNotes=" + tastingNotes + "]";
	}
}
