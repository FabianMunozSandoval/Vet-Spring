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

import com.example.vet.model.Pet;
import com.example.vet.service.PetService;

@RestController
@RequestMapping("vet/api/pet")
public class PetRest {

	@Autowired
	PetService petService;

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {

		return ResponseEntity.ok(petService.createPet(pet));
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pet> updatePet(@RequestBody Pet pet) {

		return ResponseEntity.ok(petService.updatePet(pet));
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Pet>> getAllPet() {

		return ResponseEntity.ok(petService.getPet(null));
	}
	
	@GetMapping(path = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pet>> getById(@RequestParam(value = "id") Long id){
		
		return ResponseEntity.ok(petService.getPet(id));
	}

	@DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deletePet(@RequestParam(value = "id") Long id) {

		return ResponseEntity.ok(petService.deletePet(id));
	}
}
