package co.com.iimpact.springbootmongodb.dtos;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteeringDTO {

    private String _id;
    private String idOrganization;
    private String title;
    private String description;
    private String dateStart;
    private String DateEnd;
    private int weeklyHours;
    private String[] requirements;
    private String socialReason;
    private String organization;
    private String[] neededSkills;
}
