package com.example.jobportal.controllers;

import com.example.jobportal.entities.ImageOffre;
import com.example.jobportal.services.ImageOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imageOffre")
public class ImageOffreController {
    @Autowired
    private ImageOffreService imageOffreService;

    @GetMapping
    public List<ImageOffre> getAllImages() {
        return imageOffreService.getAllImages();
    }

    @GetMapping("/{id}")
    public Optional<ImageOffre> getImageById(@PathVariable Long id) {
        return imageOffreService.getImageOffreById(id);
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            ImageOffre image = new ImageOffre();
            image.setNom(file.getOriginalFilename());
            image.setType(file.getContentType());
            image.setData(file.getBytes()); // assuming Image.data is of byte[] type

            ImageOffre savedImage = imageOffreService.saveImageOffre(image);

            return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageOffreService.deleteImageOffre(id);
    }
}
