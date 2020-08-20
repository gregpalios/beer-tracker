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

import com.capstone.entity.Suggestion;

@Repository
public class SuggestionDAOImpl implements SuggestionDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Suggestion> getSuggestions() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Suggestion> theQuery = currentSession.createQuery("from Suggestion order by beer_name", Suggestion.class);
		
		//execute query and get result list
		List<Suggestion> suggestions = theQuery.getResultList();
		
		//return the results	
		return suggestions;
	}

	@Override
	public void saveSuggestion(Suggestion theSuggestion) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the suggestion to db
		currentSession.saveOrUpdate(theSuggestion);
		
	}

	@Override
	public Suggestion getSuggestion(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve/read from database using the primary key
		Suggestion theSuggestion = currentSession.get(Suggestion.class, theId);
		
		return theSuggestion;
	}

	@Override
	public void deleteSuggestion(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Suggestion where suggestion_id=:suggestionId");
		
		theQuery.setParameter("suggestionId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
    public List<Suggestion> searchSuggestions(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery = currentSession.createQuery("from Suggestion where lower(beer_name) like :theName", Suggestion.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all suggestions
            theQuery =currentSession.createQuery("from Suggestion", Suggestion.class);            
        }
        
        // execute query and get result list
        List<Suggestion> suggestions = theQuery.getResultList();
                
        // return the results        
        return suggestions;
        
    }

}
