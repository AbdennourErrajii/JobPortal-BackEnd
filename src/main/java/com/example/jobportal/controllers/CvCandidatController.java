package com.example.jobportal.controllers;
import com.example.jobportal.entities.CvCandidat;
import com.example.jobportal.services.CvCandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Cv")
@CrossOrigin("*")
public class CvCandidatController {
    @Autowired
    private CvCandidatService cvCandidatService;

    @GetMapping
    public List<CvCandidat> getAllCvCandidat() {
        return cvCandidatService.getAllCvCandidat();
    }

    @GetMapping("/candidat/{id}")
    public Optional<CvCandidat> getCvByCandidatId(@PathVariable Long id) {
        return Optional.ofNullable(cvCandidatService.getCvCandidatByCandidatId(id));
    }


    @PostMapping
    public ResponseEntity<?> uploadCvCandidat(@RequestParam("file") MultipartFile file) {
        try {
            CvCandidat cvCandidat = new CvCandidat();
            cvCandidat.setNom(file.getOriginalFilename());
            cvCandidat.setType(file.getContentType());
            cvCandidat.setData(file.getBytes()); // assuming Image.data is of byte[] type

            CvCandidat savedCvCandidat = cvCandidatService.saveCvCandidat(cvCandidat);

            return new ResponseEntity<>(savedCvCandidat, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    public CvCandidat updateCvCandidat(@PathVariable Long id, @RequestBody CvCandidat cv) {
        cv.setId(id);
        return cvCandidatService.UpdateCvCandidat(cv);
    }

    @DeleteMapping("/{id}")
    public void deleteCvCandidat(@PathVariable Long id) {
        cvCandidatService.deleteCvCandidat(id);
    }
}
