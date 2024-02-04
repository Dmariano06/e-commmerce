package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Client;
import com.example.ecommerce.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService cliService;

    @GetMapping("/clients")
    public List<Client> list() {
        System.out.println("Get all Clients...");
        return cliService.getAll();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> post(@PathVariable int id) {
        Optional<Client> four = cliService.findByCode(id);
        return four.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }

    @PostMapping("/clients")
    public long save(@RequestBody Client Client) {

        return cliService.save(Client);
    }

    @PutMapping("/clients/{code}")
    public void update(@PathVariable int code, @RequestBody Client Client) {

        cliService.update(code, Client);

    }

    @DeleteMapping("/clients/{code}")
    public void delete(@PathVariable int code) {
        cliService.delete(code);
    }


}
