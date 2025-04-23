package com.project.traffic.domain.service;

import com.project.traffic.domain.model.Owner;
import com.project.traffic.domain.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegisterOwnerService {

    private final OwnerRepository ownerRepository;
    @Transactional
    public Owner save(Owner owner){
        return ownerRepository.save(owner);
    }
    @Transactional
    public void delete(Long ownerId){
        ownerRepository.deleteById(ownerId);
    }
}
