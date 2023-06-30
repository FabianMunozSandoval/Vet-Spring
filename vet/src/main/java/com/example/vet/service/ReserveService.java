package com.example.vet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.vet.model.Reserve;
import com.example.vet.repository.ReserveRepository;

@Service
public class ReserveService {

	@Autowired
	ReserveRepository rRepo;

	public Reserve create(Reserve reserve) {
		Reserve reFound = rRepo.findByHour(reserve.getHour());
		if (ObjectUtils.isEmpty(reFound)) {
			Reserve reSave = rRepo.save(reserve);

			return reSave;
		}
		return null;
	}

	public Reserve update(Reserve reserve) {
		Optional<Reserve> reFound = rRepo.findById(reserve.getId());
		if (reFound.isPresent()) {
			Reserve reSave = rRepo.save(reserve);

			return reSave;
		}
		return null;
	}

	public List<Reserve> get(Long id) {
		List<Reserve> reList = new ArrayList<>();
		if (ObjectUtils.isEmpty(id)) {
			return rRepo.findAll();
		} else {
			reList.add(rRepo.findById(id).get());

			return reList;
		}
	}

	public boolean delete(Long id) {
		try {
			rRepo.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
