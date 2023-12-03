package co.com.iimpact.springbootmongodb.controllers;

import co.com.iimpact.springbootmongodb.dtos.OrganizationDTO;
import co.com.iimpact.springbootmongodb.models.Organization;
import co.com.iimpact.springbootmongodb.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/i-impact/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService service;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllOrganizations(){
        List<Organization> organizations = service.allOrganizations();

        if (!organizations.isEmpty()){
            return new ResponseEntity<List<Organization>>(organizations, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("No organizations available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findOrganizationById(@PathVariable String id){
        Optional<Organization> organizationOptional = service.findOrganizationById(id);

        if (organizationOptional.isPresent()){
            Organization organization = organizationOptional.get();
            return new ResponseEntity<>(organization, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Organization not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Organization postOrganization(@RequestBody OrganizationDTO organizationDTO){
        Organization organization = new Organization(organizationDTO.getId(), organizationDTO.getName(),
                organizationDTO.getEmail(), organizationDTO.getSocialReason(), organizationDTO.getNit(),
                organizationDTO.getAddress(), organizationDTO.getCity(), organizationDTO.getPassword(),
                organizationDTO.getCountry(), organizationDTO.getDescription(), organizationDTO.getDescription());
        service.addNewOrganization(organization);
        return organization;
    }

    @DeleteMapping("/dell/{id}")
    public ResponseEntity<?> deleteOrganization(@PathVariable String id) {
        Optional<Organization> organizationOptional = service.findOrganizationById(id);

        if (organizationOptional.isPresent()) {
            Organization organization = organizationOptional.get();
            service.deleteOrganization(organization);
            return new ResponseEntity<>("Organization deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Organization no longer existed", HttpStatus.NOT_FOUND);
        }
    }

}
