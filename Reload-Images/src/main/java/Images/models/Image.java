package Images.models;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Image {
    @Id
    String id;
    String url;
    private String taskCompleted;

    public Image(String id, String url, String taskCompleted) {
        this.id = id;
        this.url = url;
        this.taskCompleted = taskCompleted;
    }
}
