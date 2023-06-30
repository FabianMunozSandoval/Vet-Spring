package com.example.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vet.model.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
	Reserve findByHour(String hour);
}
