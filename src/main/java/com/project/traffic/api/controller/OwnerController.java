package com.project.traffic.api.controller;

import com.project.traffic.domain.model.Owner;
import com.project.traffic.domain.repository.OwnerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerRepository ownerRepository;

//    public OwnerController(OwnerRepository ownerRepository){
//        this.ownerRepository = ownerRepository;
//    }

    @GetMapping
    public List<Owner> listar() {
//        return ownerRepository.findByNome("Carlos andrade");
        return ownerRepository.findAll();
    }
    @GetMapping("/{ownerId}")
    public ResponseEntity<Owner> search(@PathVariable Long ownerId){
        return ownerRepository.findbyId(ownerId)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
//    @GetMapping("/owners/{ownerId}")
//    public Owner search(@PathVariable Long ownerId){
//        Optional<Owner> owner = ownerRepository.findById(ownerId);
//        return owner.orElse(null);
//    }
//    @GetMapping("/owners/{ownerId}")
//    public ResponseEntity search(@PathVariable Long ownerId){
//        Optional<Owner> owner = ownerRepository.findById(ownerId);
//        if (owner.isPresent()){
//            return ResponseEntity.ok(owner.get());
//        }
//        return ResponseEntity.notFound().build();
//    }


//        var owner1 = new Owner();
//        owner1.setId(1L);
//        owner1.setNome("João");
//        owner1.setEmail("joaodasilva@hotmail.com");
//        owner1.setTelefone("34 99998-9999");
//
//        var owner2 = new Owner();
//        owner2.setId(2L);
//        owner2.setNome("Pablo");
//        owner2.setEmail("pablodoarrocha@hotmail.com");
//        owner2.setTelefone("34 988887-9999");
//        return Arrays.asList(owner1, owner2);

}
