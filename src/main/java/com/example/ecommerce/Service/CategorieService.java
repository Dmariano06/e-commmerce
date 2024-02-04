package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Categorie;
import com.example.ecommerce.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serial;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategorieService {
    @Autowired
    CategorieRepository repository;

    public List<Categorie> getAll() {
        System.out.println("Get all Categories 11111...");
        return repository.findAll(Sort.by("libelle").ascending());
    }

    public int max() {
        return repository.max();
    }

    public int nbre() {
        return repository.nbre();
    }

    public Optional<Categorie> findById(String code) {
        return repository.findByCode(code);
    }

    public long save(Categorie categorie) {
        Categorie cat = new Categorie();
        cat.setCode(categorie.getCode());
        cat.setLibelle(categorie.getLibelle());
        System.out.println("save  all Categories 11111...");

        return repository.save(cat)
                .getId();
    }
    public void update(String code, Categorie categorie) {
        Optional<Categorie> categ = repository.findByCode(code);
        if (categ.isPresent()) {
            Categorie cat = categ.get();
            cat.setLibelle(categorie.getLibelle());
            repository.save(cat);
        }
    }


    public List<Categorie> findByLibelle(String libelle) {
        return repository.findAllByLibelleContaining(libelle);
    }

    public void delete(String code) {
        Optional<Categorie> cat = repository.findByCode(code);
        cat.ifPresent(repository::delete);
    }

}
