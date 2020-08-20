/*
 * Author: Gregory Palios
 */

package com.capstone.service;

import java.util.List;

import com.capstone.entity.Suggestion;

public interface SuggestionService {

	public List<Suggestion> getSuggestions();

	public void saveSuggestion(Suggestion theSuggestion);

	public Suggestion getSuggestion(int theId);

	public void deleteSuggestion(int theId);

	public List<Suggestion> searchSuggestions(String theSearchName);
}
