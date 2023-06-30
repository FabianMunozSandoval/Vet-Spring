package com.example.vet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.vet.model.News;
import com.example.vet.repository.NewsRepository;

@Service
public class NewsService {

	@Autowired
	NewsRepository newsRepository;
	
	public News createNew(News ne) {
		News newFound = newsRepository.findByTitle(ne.getTitle());
		if (ObjectUtils.isEmpty(newFound)) {
			News newCreated = newsRepository.save(ne);
			
			return newCreated;
		}
		return null;
	}
	
	public News updateNew(News ne) {
		Optional<News> newFound = newsRepository.findById(ne.getId());
		if (newFound.isPresent()) {
			News newCreated = newsRepository.save(ne);
			
			return newCreated;
		}
		return null;
	}
	
	public List<News> getNew(Long id){
		List<News> news = new ArrayList<>();
		if (ObjectUtils.isEmpty(id)) {
			return newsRepository.findAll();
		}else {
			news.add(newsRepository.findById(id).get());
			return news;
		}
	}
	
	public boolean deleteNew(Long id) {
		try {
			newsRepository.deleteById(id);
			return true;
		} catch (IllegalArgumentException e){
			return false;
		}
	}
}
