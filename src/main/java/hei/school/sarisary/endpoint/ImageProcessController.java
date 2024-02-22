package hei.school.sarisary.endpoint;

import hei.school.sarisary.repository.model.ImageInformation;
import hei.school.sarisary.service.event.ImageProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageProcessController {

    private final ImageProcessService imageProcessService;

    @Autowired
    public ImageProcessController(ImageProcessService imageProcessService) {
        this.imageProcessService = imageProcessService;
    }

    @PutMapping("/black-and-white/{id}")
    public ResponseEntity<String> processImage(@PathVariable String id, @RequestParam("image") MultipartFile image) {
        try {
            String transformedUrl = imageProcessService.processImage(id, image);
            return new ResponseEntity<>(transformedUrl, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/black-and-white/{id}")
    public ResponseEntity<ImageInformation> getImageInfo(@PathVariable String id) {
        ImageInformation imageInfo = imageProcessService.getImageInfo(id);
        if (imageInfo != null) {
            return new ResponseEntity<>(imageInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}