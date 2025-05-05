package com.project.traffic.domain.service;

import com.project.traffic.domain.exception.BusinessException;
import com.project.traffic.domain.model.Owner;
import com.project.traffic.domain.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegisterOwnerService {

    private final OwnerRepository ownerRepository;

    public Owner search(Long ownerId){
        return ownerRepository.findById(ownerId).orElseThrow(() -> new BusinessException("Owner not found!"));
    }

    @Transactional
    public Owner save(Owner owner){
        boolean mailUsed = ownerRepository.findByMail(owner.getMail()).filter(p -> !p.equals(owner)).isPresent();

        if (mailUsed) {
            throw new BusinessException("There is already a registered owner with this email.");
        }

        return ownerRepository.save(owner);
    }
    @Transactional
    public void delete(Long ownerId){
        ownerRepository.deleteById(ownerId);
    }
}
