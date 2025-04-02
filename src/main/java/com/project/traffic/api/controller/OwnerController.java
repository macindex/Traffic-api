package com.project.traffic.api.controller;

import com.project.traffic.domain.model.Owner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class OwnerController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/owners")
    public List<Owner> listar(){
        return manager.createQuery("from Owner", Owner.class).getResultList();

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
}
