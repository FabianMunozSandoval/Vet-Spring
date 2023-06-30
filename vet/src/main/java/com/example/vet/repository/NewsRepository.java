package com.example.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vet.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>{
	News findByTitle(String title);
}
