package co.com.iimpact.springbootmongodb.repositories;

import co.com.iimpact.springbootmongodb.models.Volunteer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerRepository extends MongoRepository<Volunteer, String> {
    //    @Query("asdadasdas")      En caso tenga error al ingresar algo a la base de datos, utilizar el tipo de objeto objectId
//    private List<?> FindByHobbies("");
}
