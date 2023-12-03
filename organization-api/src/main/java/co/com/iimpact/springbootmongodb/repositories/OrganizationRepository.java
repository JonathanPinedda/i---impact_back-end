package co.com.iimpact.springbootmongodb.repositories;

import co.com.iimpact.springbootmongodb.models.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends MongoRepository<Organization, String> {
}
