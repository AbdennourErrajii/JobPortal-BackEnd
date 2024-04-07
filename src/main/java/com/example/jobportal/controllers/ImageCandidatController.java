package com.example.jobportal.controllers;


import com.example.jobportal.entities.ImageCandidat;
import com.example.jobportal.services.ImageCandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imageCandidat")
@CrossOrigin("*")
public class ImageCandidatController {
    @Autowired
    private ImageCandidatService imageCandidatService;

    @GetMapping
    public List<ImageCandidat> getAllImagesCandidat() {
        return imageCandidatService.getAllImageCandidat();
    }

    @GetMapping("/{id}")
    public Optional<ImageCandidat> getImageCandidatById(@PathVariable Long id) {
        return imageCandidatService.getImageCandidatById(id);
    }

    @PostMapping
    public ResponseEntity<?> uploadImageCandidat(@RequestParam("file") MultipartFile file) {
        try {
            ImageCandidat imageCandidat = new ImageCandidat();
            imageCandidat.setNom(file.getOriginalFilename());
            imageCandidat.setType(file.getContentType());
            imageCandidat.setData(file.getBytes()); // assuming Image.data is of byte[] type

            ImageCandidat savedImage = imageCandidatService.saveImage(imageCandidat);

            return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    public ImageCandidat updateImageCandidat(@PathVariable Long id, @RequestBody ImageCandidat image) {
        image.setId(id);
        return imageCandidatService.UpdateImageCandidat(image);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageCandidatService.deleteImageCandidat(id);
    }
}
