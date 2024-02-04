package com.example.ecommerce.Service;

import com.example.ecommerce.Model.User;
import com.example.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;


    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        System.out.println("Get all Users 11111...");
        return userRepository.findAll(Sort.by("username").ascending());
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public long save(User User) {
        System.out.println("save  all Users 11111...");
        User.setActive(true);

        //    User.setPassword(encoder.encode(User.getPassword()));
        return userRepository.save(User)
                .getId();
    }

    public void update( User User) {
        userRepository.save(User);
    }

    public Optional<User> login(String name) {
        return userRepository.findByUsername(name);
    }

    public void delete(long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }


    public List<User> getAllByEmail(String email) {
    System.out.println("Get all Users 11111...");
    return userRepository.findAllByEmail(email);
    }

}
