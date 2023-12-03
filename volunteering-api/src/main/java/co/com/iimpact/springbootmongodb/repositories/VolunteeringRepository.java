package co.com.iimpact.springbootmongodb.repositories;

import co.com.iimpact.springbootmongodb.models.Volunteering;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteeringRepository extends MongoRepository<Volunteering, String> {
}
