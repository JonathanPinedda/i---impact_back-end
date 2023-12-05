package Images.controller;

import Images.models.Image;
import Images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/i-impact/images")
public class ImageController {
    @Autowired
    private ImageService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getImageById(@PathVariable String id) {
        Image image = service.getImageById(id);

        if (image != null) {
            return new ResponseEntity<>(image, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Image not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

}
