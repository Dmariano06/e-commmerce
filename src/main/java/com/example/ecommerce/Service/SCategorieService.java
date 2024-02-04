package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.ListCategorie;
import com.example.ecommerce.Model.Categorie;
import com.example.ecommerce.Model.SCategorie;
import com.example.ecommerce.Repository.SCategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SCategorieService {
    @Autowired
    SCategorieRepository repository;

    public List<ListCategorie> getAll() {
        System.out.println("Get all Sous Categories 11111...");
        return repository.listScateg();
    }

    public Optional<SCategorie> findByCode(String code) {
        return repository.findByCode(code);
    }

    public long save(SCategorie scategorie) {
        System.out.println("save  all Categories 11111...");
        SCategorie scat = new SCategorie();
        scat.setCode(scategorie.getCode());
        scat.setLibelle(scategorie.getLibelle());
        scat.setCcateg(scategorie.getCcateg());
        scat.setRang(1);
        return repository.save(scat)
                .getId();
    }
    public void update(String code, SCategorie scategorie) {
        Optional<SCategorie> scateg = repository.findByCode(code);
        if (scateg.isPresent()) {
            SCategorie scat = scateg.get();
            scat.setLibelle(scategorie.getLibelle());
            scat.setCcateg(scategorie.getCcateg());
            repository.save(scat);
        }
    }


    public List<SCategorie> findByLibelle(String libelle) {
        return repository.findAllByLibelleContaining(libelle);
    }

    public void delete(String code) {
        Optional<SCategorie> cat = repository.findByCode(code);
        cat.ifPresent(repository::delete);
    }

    public List<SCategorie> findByCcateg(String code) {
        return repository.findAllByCcateg(code);
    }



    public int nbre(String code) {
        return repository.nbre(code);
    }



    public int max(String code) {
        return repository.max(code);
    }



}
