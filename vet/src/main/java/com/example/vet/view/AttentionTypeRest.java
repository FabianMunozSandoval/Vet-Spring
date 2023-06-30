package com.example.vet.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vet.model.AttentionType;
import com.example.vet.service.AttentionTypeService;

@RestController
@RequestMapping("vet/api/attentionType")
public class AttentionTypeRest {
	
	@Autowired
	AttentionTypeService aService;

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttentionType> create(@RequestBody AttentionType ate) {

		return ResponseEntity.ok(aService.create(ate));
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<AttentionType>> getAll() {

		return ResponseEntity.ok(aService.get(null));
	}

}
