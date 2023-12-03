package co.com.iimpact.springbootmongodb.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerDTO {

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
