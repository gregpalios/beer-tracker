/*
 * Author: Gregory Palios
 */

package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.dao.SuggestionDAO;
import com.capstone.entity.Suggestion;

@Service
public class SuggestionServiceImpl implements SuggestionService {

	//need to inject suggestion dao
	@Autowired
	private SuggestionDAO suggestionDAO;
	
	@Override
	@Transactional
	public List<Suggestion> getSuggestions() {
		return suggestionDAO.getSuggestions();
	}

	@Override
	@Transactional
	public void saveSuggestion(Suggestion theSuggestion) {
		
		suggestionDAO.saveSuggestion(theSuggestion);
		
	}

	@Override
	@Transactional
	public Suggestion getSuggestion(int theId) {
		
		return suggestionDAO.getSuggestion(theId);
	}

	@Override
	@Transactional
	public void deleteSuggestion(int theId) {
		
		suggestionDAO.deleteSuggestion(theId);
	}

	@Override
	@Transactional
	public List<Suggestion> searchSuggestions(String theSearchName) {
		
		return suggestionDAO.searchSuggestions(theSearchName);
	}

}
