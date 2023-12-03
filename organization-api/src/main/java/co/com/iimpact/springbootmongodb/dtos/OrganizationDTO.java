package co.com.iimpact.springbootmongodb.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {

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
