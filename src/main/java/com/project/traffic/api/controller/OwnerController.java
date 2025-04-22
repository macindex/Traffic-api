package com.project.traffic.api.controller;

import com.project.traffic.domain.model.Owner;
import com.project.traffic.domain.repository.OwnerRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ownerRepository.findById(ownerId)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
//    @GetMapping("/owners/{ownerId}")
//    public Owner search(@PathVariable Long ownerId){
//        Optional<Owner> owner = ownerRepository.findById(ownerId);
//        return owner.orElse(null);
//    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner add(@Valid @RequestBody Owner owner){
        return ownerRepository.save(owner);
    }
    @PutMapping("/{ownerId}")
    public ResponseEntity<Owner> update(@PathVariable Long ownerId, @RequestBody Owner owner) {
        if (!ownerRepository.existsById(ownerId)) {
            return ResponseEntity.notFound().build();
        }
        owner.setId(ownerId);
        Owner ownerUpdated = ownerRepository.save(owner);

        return ResponseEntity.ok(ownerUpdated);
    }
    @DeleteMapping("/{ownerId}")
    public ResponseEntity<Object> remove(@PathVariable Long ownerId) {
        return ownerRepository.findById(ownerId)
                .map(owner -> {
                    ownerRepository.delete(owner);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
