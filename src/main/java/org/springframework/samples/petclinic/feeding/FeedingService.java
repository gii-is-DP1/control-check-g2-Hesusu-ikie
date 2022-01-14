package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {
	
	@Autowired
	private FeedingRepository fr;
	
    public List<Feeding> getAll(){
        return fr.findAll();
    }

    public List<FeedingType> getAllFeedingTypes(){
        return fr.findAllFeedingTypes();
    }

    public FeedingType getFeedingType(String typeName) {
        return fr.findByFeedingType(typeName);
    }

    @Transactional(rollbackFor = UnfeasibleFeedingException.class)
    public Feeding save(Feeding feeding) throws UnfeasibleFeedingException {
    	Pet p = feeding.getPet();
    	FeedingType ft = feeding.getFeedingType();
    	if(!ft.getPetType().equals(p.getType())) {
    		throw new UnfeasibleFeedingException();
    	}
        return fr.save(feeding); 
    }

    
}
