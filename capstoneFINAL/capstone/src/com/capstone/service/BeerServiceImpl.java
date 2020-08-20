/*
 * Author: Gregory Palios
 */

package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.dao.BeerDAO;
import com.capstone.entity.Beer;

@Service("beerService")
@Transactional (propagation=Propagation.SUPPORTS, readOnly=true)
public class BeerServiceImpl implements BeerService {

	//need to inject beer dao
	@Autowired
	private BeerDAO beerDAO;
	
	@Override
	public void addBeer(Beer beer) {
		beerDAO.addBeer(beer);
	}
	
	@Override
	@Transactional
	public List<Beer> getBeers() {
		return beerDAO.getBeers();
	}

	@Override
	@Transactional
	public Beer getBeer(int theId) {
		
		return beerDAO.getBeer(theId);
	}

	@Override
	@Transactional
	public List<Beer> searchBeers(String theSearchName) {
		
		return beerDAO.searchBeers(theSearchName);
	}

}
