package Images.service;

import Images.Repository.ImageRepository;
import Images.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ImageService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private ImageRepository imageRepository;
    private final List<Image> allImages;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        this.imageRepository.init();
        this.allImages = this.imageRepository.getAllImages();
    }
    public CompletableFuture<Image> getImageByIdAsync(String imageId) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Image> optionalImage = allImages.stream()
                    .filter(image -> image.getId().equals(imageId))
                    .findFirst();

            return optionalImage.orElseGet(() -> new Image(imageId, "", "Image not found for ID: " + imageId));
        }, executorService);
    }

    public Image getImageById(String imageId) {
        try {
            CompletableFuture<Image> futureImage = getImageByIdAsync(imageId);
            return futureImage.get();
        } catch (InterruptedException | ExecutionException e) {
            return new Image(imageId, "", "Error");
        }
    }
}