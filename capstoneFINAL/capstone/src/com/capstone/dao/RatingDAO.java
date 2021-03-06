/*
 * Author: Gregory Palios
 */

package com.capstone.dao;

import java.util.List;

import com.capstone.entity.Rating;

public interface RatingDAO {

	public List<Rating> getRatings();

	public void saveRating(Rating theRating);

	public Rating getRating(int theId);

	public void deleteRating(int theId);

	public List<Rating> searchRatings(String theSearchName);
}
