package com.example.vet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.vet.model.AttentionType;
import com.example.vet.repository.AttentionTypeRepository;

@Service
public class AttentionTypeService {

	@Autowired
	AttentionTypeRepository ateRepo;

	public AttentionType create(AttentionType ate) {
		AttentionType ateFound = ateRepo.findByType(ate.getType());
		if (ObjectUtils.isEmpty(ateFound)) {
			AttentionType ateSave = ateRepo.save(ate);

			return ateSave;
		}
		return null;
	}

	public List<AttentionType> get(Long id) {
		List<AttentionType> atelist = new ArrayList<>();
		if (ObjectUtils.isEmpty(id)) {
			return ateRepo.findAll();
		} else {
			atelist.add(ateRepo.findById(id).get());

			return atelist;
		}
	}
}
