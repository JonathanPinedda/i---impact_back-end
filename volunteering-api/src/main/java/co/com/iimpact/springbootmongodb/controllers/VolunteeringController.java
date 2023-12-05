package co.com.iimpact.springbootmongodb.controllers;

import co.com.iimpact.springbootmongodb.dtos.VolunteeringDTO;
import co.com.iimpact.springbootmongodb.models.Volunteering;
import co.com.iimpact.springbootmongodb.services.VolunteeringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/i-impact/volunteering")
public class VolunteeringController {

    @Autowired
    private VolunteeringService service;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllVolunteering(){
        List<Volunteering> volunteering = service.allVolunteering();

        if (!volunteering.isEmpty()){
            return new ResponseEntity<List<Volunteering>>(volunteering, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("No volunteering available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findVolunteeringById(@PathVariable String id){
        Optional<Volunteering> volunteeringOptional = service.findVolunteeringById(id);

        if (volunteeringOptional.isPresent()){
            Volunteering volunteering = volunteeringOptional.get();
            return new ResponseEntity<>(volunteering, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Volunteering not founded", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Volunteering postVolunteering(@RequestBody VolunteeringDTO volunteeringDTO) {
        Volunteering volunteering = new Volunteering(volunteeringDTO.get_id(), volunteeringDTO.getIdOrganization(),
                volunteeringDTO.getTitle(), volunteeringDTO.getDescription(), volunteeringDTO.getDateStart(), volunteeringDTO.getDateEnd(),
                volunteeringDTO.getWeeklyHours(), volunteeringDTO.getRequirements(), volunteeringDTO.getSocialReason(),
                volunteeringDTO.getOrganization(), volunteeringDTO.getNeededSkills());
        service.addNewVolunteering(volunteering);
        return volunteering;
    }

    @DeleteMapping("/dell/{id}")
    public ResponseEntity<?> deleteVolunteering(@PathVariable String id) {
        Optional<Volunteering> volunteeringOptional = service.findVolunteeringById(id);

        if (volunteeringOptional.isPresent()) {
            Volunteering volunteering = volunteeringOptional.get();
            service.deleteVolunteering(volunteering);
            return new ResponseEntity<>("Volunteering deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Volunteering no longer existed", HttpStatus.NOT_FOUND);
        }
    }
}
