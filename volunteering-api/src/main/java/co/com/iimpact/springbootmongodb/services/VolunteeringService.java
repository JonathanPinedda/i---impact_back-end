package co.com.iimpact.springbootmongodb.services;

import co.com.iimpact.springbootmongodb.models.Volunteering;
import co.com.iimpact.springbootmongodb.repositories.VolunteeringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VolunteeringService {

    @Autowired
    private VolunteeringRepository repository;

    public List<Volunteering> allVolunteering(){ return repository.findAll(); }

    public Optional<Volunteering> findVolunteeringById(String id){ return repository.findById(id); }

    public void addNewVolunteering(Volunteering volunteering){ repository.save(volunteering); }

    public void deleteVolunteering(Volunteering volunteering){ repository.deleteById(volunteering.get_id()); }

}
