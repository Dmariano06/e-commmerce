package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);

    User findByEmail(String email);

    User findByToken(String token);

    List<User> findAllByEmail(String email);




}

