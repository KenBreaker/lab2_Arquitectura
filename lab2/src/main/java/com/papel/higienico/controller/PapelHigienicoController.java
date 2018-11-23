package com.papel.higienico.controller;

import com.papel.higienico.exception.PapelitoNotFound;
import com.papel.higienico.model.Paper;
import com.papel.higienico.repository.PapelHigienicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PapelHigienicoController {

    @Autowired
    PapelHigienicoRepository papelHigienicoRepository;
    
    
    // CREATE
    @PostMapping("/paper")
    public Paper createPaper(@Valid @RequestBody Paper paper) { 
        return papelHigienicoRepository.save(paper);
    }
    
    // READ ALL
    @GetMapping("/paper")
    public List<Paper> getAllPapers() {
        return papelHigienicoRepository.findAll();
    }
    
    // READ n
    @GetMapping("/paper/{id}")
    public Paper getPaperById(@PathVariable(value = "id") Long paperId) {
        return papelHigienicoRepository.findById(paperId)
                .orElseThrow(() -> new PapelitoNotFound("Paper", "id", paperId));
    }
    
    // UPDATE
    @PutMapping("/paper/{id}")
    public Paper updatePaper(@PathVariable(value = "id") Long paperId,
                                            @Valid @RequestBody Paper paperDetails) {
    	Paper paper = papelHigienicoRepository.findById(paperId)
                .orElseThrow(() -> new PapelitoNotFound("Paper", "id", paperId));
    	paper.setBrand(paperDetails.getBrand());
    	paper.setDescription(paperDetails.getDescription());

        Paper updatedPaper = papelHigienicoRepository.save(paper);
        return updatedPaper;
    }
    
    // DELETE
    @DeleteMapping("/paper/{id}")
    public ResponseEntity<?> deletePaper(@PathVariable(value = "id") Long paperId) {
    	Paper paper = papelHigienicoRepository.findById(paperId)
                .orElseThrow(() -> new PapelitoNotFound("Paper", "id", paperId));

    	papelHigienicoRepository.delete(paper);

        return ResponseEntity.ok().build();
    }
}