package com.project.traffic.domain.repository;

import com.project.traffic.domain.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
//    List<Owner> findByNameContaining(String name);
//    List<Owner> findById(Long OwnerId)

    Optional<Owner> findById(Long ownerId);
}
