package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByCode(int id);

    List<Client> findAllByLibelleContaining(String libelle);

    List<Client> findAllByEmail(String email);
}

