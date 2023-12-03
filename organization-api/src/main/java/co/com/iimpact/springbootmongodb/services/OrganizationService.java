package co.com.iimpact.springbootmongodb.services;

import co.com.iimpact.springbootmongodb.models.Organization;
import co.com.iimpact.springbootmongodb.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository repository;

    public List<Organization> allOrganizations(){ return repository.findAll();}

    public Optional<Organization> findOrganizationById(String id){ return repository.findById(id); }

    public void addNewOrganization(Organization organization){ repository.save(organization); }

    public void deleteOrganization(Organization organization){ repository.deleteById(organization.getId()); }

}
