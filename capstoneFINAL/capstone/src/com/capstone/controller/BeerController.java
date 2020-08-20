/*
 * Author: Gregory Palios
 */

package com.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.entity.Beer;
import com.capstone.service.BeerService;

@Controller
@RequestMapping("/beers")
public class BeerController {
	
	//need to inject beer service with autowired annotation
	@Autowired
	private BeerService beerService;
	
	@GetMapping("/list")
	public String listBeers(Model theModel) {
		
		//get beers from the service
		List<Beer> theBeers = beerService.getBeers();
		
		//add the beers to the model
		theModel.addAttribute("beers", theBeers);
		
		return "list-beers";
	}
	
	@GetMapping("/details")
	public String beerDetails(@RequestParam("beerId") int theId,
									Model theModel) {
		
		//get the beer from the service
		Beer theBeer = beerService.getBeer(theId);
		
		//set the beer as a model attribute to pre-populate the form
		theModel.addAttribute("beer", theBeer);
		
		//send over to the form
		return "beer-details";
	}
	
	@GetMapping("/search")
    public String searchBeers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search beers from the service
        List<Beer> theBeers = beerService.searchBeers(theSearchName);
                
        // add the beers to the model
        theModel.addAttribute("beers", theBeers);

        return "list-beers";        
    }

}
