package com.example.vet.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vet.model.News;
import com.example.vet.service.NewsService;

@RestController
@RequestMapping("vet/api/news")
public class NewsRest {

	@Autowired
	NewsService newsService;
	
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<News> createNew(@RequestBody News ne){
		
		return ResponseEntity.ok(newsService.createNew(ne));
	}
	
	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<News> updateNew(@RequestBody News ne){
		
		return ResponseEntity.ok(newsService.updateNew(ne));
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<News>> getAllNew(){
		
		return ResponseEntity.ok(newsService.getNew(null));
	}
	
	@DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteNew(@RequestParam(value = "id") Long id){
		
		return ResponseEntity.ok(newsService.deleteNew(id));
	}
}
