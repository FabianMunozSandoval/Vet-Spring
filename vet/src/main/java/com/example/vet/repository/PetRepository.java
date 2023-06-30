package com.example.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vet.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	Pet findByCode(int code);
}
