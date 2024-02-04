package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Client;
import com.example.ecommerce.Model.Parametre;
import com.example.ecommerce.Model.User;
import com.example.ecommerce.Repository.ClientRepository;
import com.example.ecommerce.Repository.ParametreRepository;
import com.example.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {
    @Autowired
    ClientRepository repository;
    @Autowired
    ParametreRepository paramRepository;
    @Autowired
    UserRepository userRepository;
    public List<Client> getAll() {
        System.out.println("Get all Clients 11111...");
        return repository.findAll(Sort.by("libelle").ascending());
    }


    public Optional<Client> findByCode(int id) {
        return repository.findByCode(id);
    }

    public long save(Client Client) {
        long id = 1;
        Optional<Parametre> ParamInfo = paramRepository.findById(id);
        if (ParamInfo.isPresent()) {
            Parametre param = ParamInfo.get();
            param.setNumc(param.getNumc()+1);
            param = paramRepository.save(param);
        }
        User user = new User();
        user.setUsername(Client.getEmail());
        user.setEmail(Client.getEmail());
        user.setPassword(Client.getPwd());
        user.setRole("CLIENT");
        user.setActive(true);
        userRepository.save(user);
        return repository.save(Client)
                .getId();
    }
    public void update(int code, Client Client) {
        Optional<Client> cli = repository.findByCode(code);
        if (cli.isPresent()) {
            Client cl = cli.get();
            cl.setLibelle(Client.getLibelle());
            cl.setAdresse(Client.getAdresse());
            repository.save(cl);
        }
    }




    public List<Client> findByLibelle(String libelle) {
        return repository.findAllByLibelleContaining(libelle);
    }

    public List<Client> findByEmail(String email) {
        return repository.findAllByEmail(email);
    }

    public void delete(int code) {
        Optional<Client> cat = repository.findByCode(code);
        cat.ifPresent(repository::delete);
    }



}
