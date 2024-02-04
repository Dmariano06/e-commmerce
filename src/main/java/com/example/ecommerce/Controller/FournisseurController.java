package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Fournisseur;
import com.example.ecommerce.Service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class FournisseurController {
    @Autowired
    private FournisseurService fourService;


    @GetMapping("/fournisseurs")
    public List<Fournisseur> list() {
        System.out.println("Get all Fournisseurs...");
        return fourService.getAll();
    }

    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> post(@PathVariable int id) {
        Optional<Fournisseur> four = fourService.findByCode(id);
        return four.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }

    @PostMapping("/fournisseurs")
    public long save(@RequestBody Fournisseur Fournisseur) {

        return fourService.save(Fournisseur);
    }

    @PutMapping("/fournisseurs/{code}")
    public void update(@PathVariable int code, @RequestBody Fournisseur Fournisseur) {

        fourService.update(code, Fournisseur);

    }

    @DeleteMapping("/fournisseurs/{code}")
    public void delete(@PathVariable int code) {
        fourService.delete(code);
    }

}