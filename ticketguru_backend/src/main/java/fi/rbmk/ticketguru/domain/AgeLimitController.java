package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AgeLimitController {
	
	@Autowired
	private AgeLimitRepository alrepository;
	
	@GetMapping("api/ageLimits")
	public List<AgeLimit> ageLimitListRest() {
		return (List<AgeLimit>) alrepository.findAll();
	}
	
	@PostMapping
    AgeLimit ageLimit(@RequestBody AgeLimit ageLimit) {
        return alrepository.save(ageLimit);
    }
	
	@PatchMapping("/{id}")
    AgeLimit editAgeLimit(@RequestBody AgeLimit newAgeLimit, @PathVariable Long id) {
        AgeLimit ageLimit = alrepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if(newAgeLimit.getName() != "") { AgeLimit.setName(newAgeLimit.getName()); }
        if(newAgeLimit.getSpecifier() != null) { AgeLimit.setSpecifier(newAgeLimit.getSpecifier()); }
        alrepository.save(ageLimit);
        return ageLimit;
    }

}
