/*
 * Author: Gregory Palios
 */

package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.dao.BeerDAO;
import com.capstone.dao.RatingDAO;
import com.capstone.entity.Beer;
import com.capstone.entity.Rating;

@Service
public class RatingServiceImpl implements RatingService {

	//need to inject rating and beer daos
	@Autowired
	private RatingDAO ratingDAO;
	
	@Autowired
	private BeerDAO beerDAO;
	
	@Override
	@Transactional
	public List<Rating> getRatings() {
		return ratingDAO.getRatings();
	}

	@Override
	@Transactional
	public void saveRating(Rating theRating) {
		
		//Make sure to use the correct session
		Beer beer = beerDAO.getBeer(theRating.getBeer().getBeerId());
		theRating.setBeer(beer);
		
		ratingDAO.saveRating(theRating);
		
	}

	@Override
	@Transactional
	public Rating getRating(int theId) {
		
		return ratingDAO.getRating(theId);
	}

	@Override
	@Transactional
	public void deleteRating(int theId) {
		
		ratingDAO.deleteRating(theId);
	}

	@Override
	@Transactional
	public List<Rating> searchRatings(String theSearchName) {
		
		return ratingDAO.searchRatings(theSearchName);
	}

}
