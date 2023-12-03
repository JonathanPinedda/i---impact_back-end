package co.com.iimpact.springbootmongodb.controllers;

import co.com.iimpact.springbootmongodb.dtos.VolunteerDTO;
import co.com.iimpact.springbootmongodb.models.Volunteer;
import co.com.iimpact.springbootmongodb.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/i-impact/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService service;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllVolunteers(){
        List<Volunteer> volunteers = service.allVolunteers();

        if (!volunteers.isEmpty()){
            return new ResponseEntity<List<Volunteer>>(volunteers, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("No volunteer available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findVolunteerById(@PathVariable String id){
        Optional<Volunteer> volunteerOptional = service.findVolunteerById(id);

        if (volunteerOptional.isPresent()){
            Volunteer volunteer = volunteerOptional.get();
            return new ResponseEntity<>(volunteer, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Volunteer not founded", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Volunteer postVolunteer(@RequestBody VolunteerDTO volunteerDTO){
        return new Volunteer(volunteerDTO.get_id(), volunteerDTO.getName(),
                volunteerDTO.getAge(), volunteerDTO.getAddress(), volunteerDTO.getCity(),
                volunteerDTO.getCountry(), volunteerDTO.getEmail(), volunteerDTO.getCellphone(),
                volunteerDTO.getPassword(), volunteerDTO.getHobbies(), volunteerDTO.getSkills());
    }

    @DeleteMapping("/dell/{id}")
    public ResponseEntity<?> deleteVolunteer(@PathVariable String id) {
        Optional<Volunteer> volunteerOptional = service.findVolunteerById(id);

        if (volunteerOptional.isPresent()) {
            Volunteer volunteer = volunteerOptional.get();
            service.deleteVolunteer(volunteer);
            return new ResponseEntity<>("Volunteer deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Volunteer no longer existed", HttpStatus.NOT_FOUND);
        }
    }

}
