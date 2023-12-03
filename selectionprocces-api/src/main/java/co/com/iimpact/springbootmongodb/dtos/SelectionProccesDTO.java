package co.com.iimpact.springbootmongodb.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionProccesDTO {

    private String _id;
    private String state;
    private String idVolunteer;
    private String idVolunteering;

}
