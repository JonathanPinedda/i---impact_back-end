package co.com.iimpact.springbootmongodb.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Volunteering")
public class Volunteering {
    @Id
    private String _id;
    private String idOrganization;
    private String tittle;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateStar;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date DateEnd;
    private int weeklyHours;
    private String[] requirements;
    private String socialReason;
    private String organization;
    private String[] neededSkills;

}
