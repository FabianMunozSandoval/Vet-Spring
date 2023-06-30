package com.example.vet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.vet.model.Pet;
import com.example.vet.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	PetRepository petRepository;

	public Pet createPet(Pet pet) {
		Pet petFound = petRepository.findByCode(pet.getCode());
		if (ObjectUtils.isEmpty(petFound)) {
			Pet petSave = petRepository.save(pet);
			return petSave;
		}
		return petFound;
	}

	public Pet updatePet(Pet pet) {
		Optional<Pet> petFound = petRepository.findById(pet.getId());
		if (petFound.isPresent()) {
			Pet petUpdate = petRepository.save(pet);
			return petUpdate;
		}
		return null;
	}

	public List<Pet> getPet(Long id) {
		List<Pet> petList = new ArrayList<>();
		if (ObjectUtils.isEmpty(id)) {
			return petRepository.findAll();
		} else {
			petList.add(petRepository.findById(id).get());
			return petList;
		}
	}

	public boolean deletePet(Long id) {
		try {
			petRepository.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
