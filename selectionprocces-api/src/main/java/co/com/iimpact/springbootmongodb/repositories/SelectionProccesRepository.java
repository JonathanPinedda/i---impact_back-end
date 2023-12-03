package co.com.iimpact.springbootmongodb.repositories;

import co.com.iimpact.springbootmongodb.models.SelectionProcess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectionProccesRepository extends MongoRepository<SelectionProcess, String> {
}
