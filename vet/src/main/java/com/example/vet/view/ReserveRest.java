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

import com.example.vet.model.Reserve;
import com.example.vet.service.ReserveService;

@RestController
@RequestMapping("vet/api/reserve")
public class ReserveRest {

	@Autowired
	ReserveService rService;

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reserve> create(@RequestBody Reserve reserve) {

		return ResponseEntity.ok(rService.create(reserve));
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reserve> update(@RequestBody Reserve reserve) {

		return ResponseEntity.ok(rService.update(reserve));
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Reserve>> getAll() {

		return ResponseEntity.ok(rService.get(null));
	}

	@DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> delete(@RequestParam(value = "id") Long id) {

		return ResponseEntity.ok(rService.delete(id));
	}
}
