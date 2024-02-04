package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Long> {


}