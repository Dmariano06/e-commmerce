package com.example.ecommerce.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "Utilisateur",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"
                        + ""),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    @Size(max = 40)
    private String username;
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    private String nom;
    private int code;
    private String password;
    private boolean isActive;
    private String role;
    private String fileName;
    private String token;
    private LocalDateTime tokenCreationDate;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public LocalDateTime getTokenCreationDate() {
        return tokenCreationDate;
    }
    public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
        this.tokenCreationDate = tokenCreationDate;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", nom=" + nom + ", code=" + code
                + ", password=" + password + ", isActive=" + isActive + ", role=" + role + ", fileName=" + fileName
                + ", token=" + token + ", tokenCreationDate=" + tokenCreationDate + "]";
    }
    public User(long id, @NotBlank @Size(max = 40) String username,@NotBlank @Size(max = 60) @Email String email,
                String nom, int code, String password, boolean isActive, String role, String fileName, String token,
                LocalDateTime tokenCreationDate) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.nom = nom;
        this.code = code;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
        this.fileName = fileName;
        this.token = token;
        this.tokenCreationDate = tokenCreationDate;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }


}
