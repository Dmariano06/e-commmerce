package com.example.ecommerce.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;


@Entity
@EnableJpaRepositories

public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String libelle;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    @Override
    public String toString() {
        return "Categorie [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
    }
    public Categorie(long id, String code, String libelle) {
        super();
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }
    public Categorie() {
        super();
        // TODO Auto-generated constructor stub
    }
}
