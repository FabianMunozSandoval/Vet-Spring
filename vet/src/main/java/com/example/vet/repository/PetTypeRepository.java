package com.example.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vet.model.PetType;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {

	PetType findByType(String type);
}
