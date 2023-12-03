package co.com.iimpact.springbootmongodb.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Organization")
public class Organization {

    @Id
    private String id;

    private String name;
    private String email;
    private String socialReason;
    private String nit;
    private String address;
    private String city;
    private String password;
    private String country;
    private String description;
    private String cellphone;

}
