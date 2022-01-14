package org.springframework.samples.petclinic.feeding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feeding")
public class FeedingController {
    
	
	@Autowired
	private FeedingService fs;
	
	@Autowired
	private PetService ps;
	
	private static final String VIEWS_FEEDING_CREATE_OR_UPDATE_FORM = "feedings/createOrUpdateFeedingForm";
	
	@GetMapping(path="/create")
	public String initCreationForm(ModelMap modelMap) {
		String view = VIEWS_FEEDING_CREATE_OR_UPDATE_FORM;
		modelMap.addAttribute("feeding", new Feeding());
		modelMap.addAttribute("feedingTypes", fs.getAllFeedingTypes());
		modelMap.addAttribute("pets", ps.getAllPets());
		return view;
	}
}
