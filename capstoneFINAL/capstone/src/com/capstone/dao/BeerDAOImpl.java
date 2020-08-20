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

import com.capstone.entity.Beer;

@Repository
public class BeerDAOImpl implements BeerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBeer(Beer beer) {
	 sessionFactory.getCurrentSession().saveOrUpdate(beer);
	}
	
	@Override
	public List<Beer> getBeers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Beer> theQuery = currentSession.createQuery("from Beer order by name", Beer.class);
		
		//execute query and get result list
		List<Beer> beers = theQuery.getResultList();
		
		//return the results	
		return beers;
	}

	@Override
	public Beer getBeer(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve/read from database using the primary key
		Beer theBeer = currentSession.get(Beer.class, theId);
		
		return theBeer;
	}

	@Override
    public List<Beer> searchBeers(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery = currentSession.createQuery("from Beer where lower(name) like :theName or lower(brewery) like :theName", Beer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            //theSearchName is empty ... so just get all beers
            theQuery = currentSession.createQuery("from Beer", Beer.class);            
        }
        
        // execute query and get result list
        List<Beer> beers = theQuery.getResultList();
                
        // return the results        
        return beers;
        
    }
	
}
