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

import com.example.vet.model.Client;
import com.example.vet.service.ClientService;

@RestController
@RequestMapping("vet/api/client")
public class ClientRest {

	@Autowired
	ClientService clientService;

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> createClient(@RequestBody Client client) {

		return ResponseEntity.ok(clientService.createClient(client));
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {

		return ResponseEntity.ok(clientService.updateClient(client));
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Client>> getAllClient() {

		return ResponseEntity.ok(clientService.getClient(null));
	}

	@DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteClient(@RequestParam(value = "id") Long id) {

		return ResponseEntity.ok(clientService.deleteClient(id));
	}
}
