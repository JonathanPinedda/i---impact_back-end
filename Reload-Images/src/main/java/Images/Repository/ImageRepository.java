package Images.Repository;

import Images.models.Image;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ImageRepository {

    private final List<Image> images = new ArrayList<>();

    @PostConstruct
    public void init() {
        Image image1 = new Image("1", "../../assets/images/servicio_social-1.png", "");
        Image image2 = new Image("2", "../../assets/images/servicio-social-2.png", "");
        images.add(image1);
        images.add(image2);
    }

    public List<Image> getAllImages() {
        return images;
    }

}