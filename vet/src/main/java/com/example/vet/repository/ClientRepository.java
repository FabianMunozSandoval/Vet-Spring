package com.example.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vet.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByRut(String rut);
}
