package com.example.vet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.vet.model.PetType;
import com.example.vet.repository.PetTypeRepository;

@Service
public class PetTypeService {

	@Autowired
	PetTypeRepository ptRepository;

	public PetType createPetType(PetType pt) {
		PetType ptFound = ptRepository.findByType(pt.getType());
		if (ObjectUtils.isEmpty(ptFound)) {
			PetType ptSave = ptRepository.save(pt);
			return ptSave;
		}
		return null;
	}

	public List<PetType> getPetType(Long id) {
		List<PetType> ptList = new ArrayList<>();
		if (ObjectUtils.isEmpty(id)) {
			return ptRepository.findAll();
		} else {
			ptList.add(ptRepository.findById(id).get());
			return ptList;
		}
	}
	
	public PetType getById(Long id) {
		PetType pt = ptRepository.findById(id).get();
		
		return pt;
	}

	public boolean deletePetType(Long id) {
		try {
			ptRepository.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
