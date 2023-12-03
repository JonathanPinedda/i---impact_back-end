package co.com.iimpact.springbootmongodb.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Selection Process")
public class SelectionProcess {

    @Id
    private String _id;
    private String state;
    private String idVolunteer;
    private String idVolunteering;

}
