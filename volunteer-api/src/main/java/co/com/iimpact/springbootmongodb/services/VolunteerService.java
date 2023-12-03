package co.com.iimpact.springbootmongodb.services;

import co.com.iimpact.springbootmongodb.models.Volunteer;
import co.com.iimpact.springbootmongodb.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository repository;

    public List<Volunteer> allVolunteers(){ return repository.findAll(); }

    public Optional<Volunteer> findVolunteerById(String id){ return repository.findById(id); }

    public void addNewVolunteer(Volunteer volunteer){ repository.save(volunteer); }

    public void deleteVolunteer(Volunteer volunteer){ repository.deleteById(volunteer.get_id()); }

}