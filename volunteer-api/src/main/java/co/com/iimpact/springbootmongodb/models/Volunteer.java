package co.com.iimpact.springbootmongodb.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Volunteer")
public class Volunteer {

    @Id
    private String _id;
    private String name;
    private int age;
    private String address;
    private String city;
    private String country;
    private String email;
    private String cellphone;
    private String password;
    private String[] hobbies;
    private String[] skills;

}
