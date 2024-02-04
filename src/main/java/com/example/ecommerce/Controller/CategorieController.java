package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.ListCategorie;
import com.example.ecommerce.Model.Categorie;
import com.example.ecommerce.Repository.CategorieRepository;
import com.example.ecommerce.Service.CategorieService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/categories/7")
    public  int getCode() {
        System.out.println("Get Numbers...");
        int  x = categorieService.nbre();
        System.out.println(x);
        if (x == 0)
        {
            return 0;
        }
        else
        {
            return categorieService.max();
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/categories")
    public List<Categorie> list() {
        System.out.println("Get all Categories...");
        return categorieService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/categories/{id}")
    public ResponseEntity<Categorie> post(@PathVariable String id) {
        Optional<Categorie> cat = categorieService.findById(id);
        return cat.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/categories")
    public long save(@RequestBody Categorie categorie) {

        return categorieService.save(categorie);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/categories/{id}")
    public void update(@PathVariable String id, @RequestBody Categorie categorie) {
Optional<Categorie> post = categorieService.findById(id);
if(post.isPresent()) {
    categorieService.update(id, categorie);
} else {
    categorieService.save(categorie);
}

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable String id) {
        categorieService.delete(id);
    }



}
