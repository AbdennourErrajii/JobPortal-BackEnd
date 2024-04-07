package com.example.jobportal.services;

import com.example.jobportal.entities.ImageCandidat;
import com.example.jobportal.repositories.ImageCandidatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageCandidatService {
    @Autowired
    private ImageCandidatRepo imageCandidatRepo;

    public List<ImageCandidat> getAllImageCandidat() {
        return imageCandidatRepo.findAll();
    }

    public Optional<ImageCandidat> getImageCandidatById(Long id) {
        return imageCandidatRepo.findById(id);
    }

    public ImageCandidat saveImage(ImageCandidat image) {
        return imageCandidatRepo.save(image);
    }

    public ImageCandidat UpdateImageCandidat(ImageCandidat image) {
        return imageCandidatRepo.save(image);
    }

    public void deleteImageCandidat(Long id) {
        imageCandidatRepo.deleteById(id);
    }

}
