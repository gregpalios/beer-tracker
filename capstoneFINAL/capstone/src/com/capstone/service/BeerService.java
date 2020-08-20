/*
 * Author: Gregory Palios
 */

package com.capstone.service;

import java.util.List;

import com.capstone.entity.Beer;

public interface BeerService {
	
	public void addBeer(Beer beer);
	
	public List<Beer> getBeers();

	public Beer getBeer(int theId);

	public List<Beer> searchBeers(String theSearchName);
	
}
