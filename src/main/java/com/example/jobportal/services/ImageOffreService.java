package com.example.jobportal.services;

import com.example.jobportal.entities.ImageOffre;
import com.example.jobportal.repositories.ImageOffreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageOffreService {
    @Autowired
    private ImageOffreRepo imageOffreRepo;

    public List<ImageOffre> getAllImages() {
        return imageOffreRepo.findAll();
    }

    public Optional<ImageOffre> getImageOffreById(Long id) {
        return imageOffreRepo.findById(id);
    }

    public ImageOffre saveImageOffre(ImageOffre image) {
        return imageOffreRepo.save(image);
    }

    public void deleteImageOffre(Long id) {
        imageOffreRepo.deleteById(id);
    }
}
