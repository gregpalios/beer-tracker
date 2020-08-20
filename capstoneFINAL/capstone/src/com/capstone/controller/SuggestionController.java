/*
 * Author: Gregory Palios
 */

package com.capstone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.entity.Suggestion;
import com.capstone.service.SuggestionService;

@Controller
@RequestMapping("/suggestions")
public class SuggestionController {
	
	//inject the suggestion service with autowired annotation
	@Autowired
	private SuggestionService suggestionService;
	
	//add an init binder to convert trim input strings
	//remove leading and trailing whitespace
	//resolve issue for validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/form")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Suggestion theSuggestion = new Suggestion();
		
		theModel.addAttribute("suggestion", theSuggestion);
		
		return "suggestion-form";
	}
	
	@PostMapping("/saveSuggestion")
	public String saveSuggestion(
			@Valid @ModelAttribute("suggestion") Suggestion theSuggestion,
			BindingResult theBindingResult) {
		
		//save the suggestion using the service
		if (theBindingResult.hasErrors()){
			return "suggestion-form";
		}
		else {
			suggestionService.saveSuggestion(theSuggestion);
			return "suggestion-confirmation";
		}
	}
}
