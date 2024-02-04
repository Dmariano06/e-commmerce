package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Optional<Categorie> findByCode(String code);

    List<Categorie> findAllByLibelleContaining(String libelle);

    @Query(value = "SELECT count(code) FROM Categorie")
    public int nbre();

    @Query(value = "SELECT max(code) FROM Categorie")
    public int max();
}
