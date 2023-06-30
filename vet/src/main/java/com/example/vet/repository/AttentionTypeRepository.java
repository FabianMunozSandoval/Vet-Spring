package com.example.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vet.model.AttentionType;

@Repository
public interface AttentionTypeRepository extends JpaRepository<AttentionType, Long> {
	AttentionType findByType(String type);
}
