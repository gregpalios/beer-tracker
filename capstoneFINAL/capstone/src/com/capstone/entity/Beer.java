/*
 * Author: Gregory Palios
 */

package com.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beer")
public class Beer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="beer_id")
	private int beerId;
	
	@Column(name="name")
	private String beerName;
	
	@Column(name="brewery")
	private String brewery;
	
	@Column(name="type")
	private String type;
	
	@Column(name="abv")
	private String abv;
	
	@Column(name="serving_temperature")
	private String servingTemperature;
	
	@Column(name="first_brewed")
	private String firstBrewed;
	
	@Column(name="country")
	private String country;
	
	@Column(name="history")
	private String history;
	
	public Beer() {
		
	}

	public int getBeerId() {
		return beerId;
	}

	public void setBeerId(int beerId) {
		this.beerId = beerId;
	}

	public String getBeerName() {
		return beerName;
	}

	public String getBrewery() {
		return brewery;
	}

	public String getType() {
		return type;
	}

	public String getAbv() {
		return abv;
	}

	public String getServingTemperature() {
		return servingTemperature;
	}

	public String getFirstBrewed() {
		return firstBrewed;
	}

	public String getCountry() {
		return country;
	}

	public String getHistory() {
		return history;
	}

	@Override
	public String toString() {
		return "Beer [beerId=" + beerId + ", beerName=" + beerName + ", brewery=" + brewery + ", type=" + type
				+ ", abv=" + abv + ", servingTemperature=" + servingTemperature + ", firstBrewed=" + firstBrewed
				+ ", country=" + country + ", history=" + history + "]";
	}
}
