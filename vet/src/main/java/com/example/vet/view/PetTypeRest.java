package com.example.vet.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vet.model.PetType;
import com.example.vet.service.PetTypeService;

@RestController
@RequestMapping("vet/api/petType")
public class PetTypeRest {

	@Autowired
	PetTypeService ptService;

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PetType> createPt(@RequestBody PetType pt) {

		return ResponseEntity.ok(ptService.createPetType(pt));
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<PetType>> getAllPt() {

		return ResponseEntity.ok(ptService.getPetType(null));
	}
	
	@GetMapping(path = "/getById")
	public ResponseEntity<PetType> getById(@RequestParam(value = "id") Long id){
		
		return ResponseEntity.ok(ptService.getById(id));
	}

	@DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deletePt(@RequestParam Long id) {

		return ResponseEntity.ok(ptService.deletePetType(id));
	}
}
