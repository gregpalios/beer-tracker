/*
 * Author: Gregory Palios
 */

package com.capstone.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.entity.Beer;
import com.capstone.entity.Rating;
import com.capstone.service.BeerService;
import com.capstone.service.RatingService;

@Controller
@RequestMapping("/ratings")
public class RatingController {
	
	//need to inject rating and beer services
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private BeerService beerService;
	
	//add an init binder to convert trim input strings
	//remove leading and trailing whitespace
	//resolve issue for validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/list")
	public String listRatings(Model theModel) {
		
		//get ratings and beers from the service
		List<Rating> theRatings = ratingService.getRatings();
		List<Beer> theBeers = beerService.getBeers();
		
		//add the ratings and beers to the model
		theModel.addAttribute("ratings", theRatings);
		theModel.addAttribute("beers", theBeers);
		
		return "list-ratings";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Rating theRating = new Rating();
		List<Beer> theBeers = beerService.getBeers();
		
		theModel.addAttribute("rating", theRating);
		theModel.addAttribute("beers", theBeers);
		
		return "rating-form";
	}
	
	@PostMapping("/saveRating")
	public String saveRating(
			@Valid @ModelAttribute("rating") Rating theRating,
			BindingResult theBindingResult) {
		
		//save the rating using our service
		if (theBindingResult.hasErrors()){
			return "rating-form";
		}
		else {
			ratingService.saveRating(theRating);
			return "redirect:/ratings/list";
		}
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ratingId") int theId,
									Model theModel) {
		
		//get the rating and beer from the service
		Rating theRating = ratingService.getRating(theId);
		List<Beer> theBeers = beerService.getBeers();
		
		//set the rating and beer as a model attribute to pre-populate the form
		theModel.addAttribute("rating", theRating);
		theModel.addAttribute("beers", theBeers);
		
		//send over to our form
		return "rating-form";
	}
	
	@GetMapping("/delete")
	public String deleteRating(@RequestParam("ratingId") int theId) {
		
		//delete the rating
		ratingService.deleteRating(theId);
		
		//send over to our form
		return "redirect:/ratings/list";
	}
	
	@GetMapping("/search")
    public String searchRatings(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search ratings from the service
        List<Rating> theRatings = ratingService.searchRatings(theSearchName);
                
        // add the ratings to the model
        theModel.addAttribute("ratings", theRatings);

        return "list-ratings";        
    }

}
