package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {


    List<Fournisseur> findAllByLibelleContaining(String libelle);

    Optional<Fournisseur> findByCode(int id);

    List<Fournisseur> findAllByEmail(String email);

}
