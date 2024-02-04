package com.example.ecommerce.Model;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@EnableJpaRepositories
public class SCategorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String libelle;
    private String ccateg;

    private int rang;
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
    public String getCcateg() {
        return ccateg;
    }
    public void setCcateg(String ccateg) {
        this.ccateg = ccateg;
    }
    public int getRang() {
        return rang;
    }
    public void setRang(int rang) {
        this.rang = rang;
    }
    @Override
    public String toString() {
        return "SCategorie [id=" + id + ", code=" + code + ", libelle=" + libelle + ", ccateg=" + ccateg + ", rang="
                + rang + "]";
    }
    public SCategorie(long id, String code, String libelle, String ccateg, int rang) {
        super();
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.ccateg = ccateg;
        this.rang = rang;
    }
    public SCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }


}
