/*
 * Author: Gregory Palios
 */

package com.capstone.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Rating;

@Repository
public class RatingDAOImpl implements RatingDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Rating> getRatings() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Rating> theQuery = currentSession.createQuery("from Rating order by beer", Rating.class);
		
		//execute query and get result list
		List<Rating> ratings = theQuery.getResultList();
		
		//return the results	
		return ratings;
	}

	@Override
	public void saveRating(Rating theRating) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the rating to db
		currentSession.saveOrUpdate(theRating);
		
	}

	@Override
	public Rating getRating(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve/read from database using the primary key
		Rating theRating = currentSession.get(Rating.class, theId);
		
		return theRating;
	}

	@Override
	public void deleteRating(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Rating where rating_id=:ratingId");
		
		theQuery.setParameter("ratingId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
    public List<Rating> searchRatings(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for rating ... case insensitive
            theQuery = currentSession.createQuery("from Rating where lower(beer) like :theName", Rating.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all ratings
            theQuery =currentSession.createQuery("from Rating", Rating.class);            
        }
        
        // execute query and get result list
        List<Rating> ratings = theQuery.getResultList();
                
        // return the results        
        return ratings;
        
    }

}
