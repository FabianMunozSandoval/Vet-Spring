package com.example.vet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.vet.model.Client;
import com.example.vet.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public Client createClient(Client client) {
		Client clientFound = clientRepository.findByRut(client.getRut());
		if (ObjectUtils.isEmpty(clientFound)) {
			Client clientSave = clientRepository.save(client);
			return clientSave;
		}
		return clientFound;
	}

	public Client updateClient(Client client) {
		Optional<Client> clientFound = clientRepository.findById(client.getId());
		if (clientFound.isPresent()) {
			Client clientUpdate = clientRepository.save(client);
			return clientUpdate;
		}
		return null;
	}

	public List<Client> getClient(Long id) {
		List<Client> clientList = new ArrayList<>();
		if (ObjectUtils.isEmpty(id)) {
			return clientRepository.findAll();
		} else {
			clientList.add(clientRepository.findById(id).get());
			return clientList;
		}
	}

	public boolean deleteClient(Long id) {
		try {
			clientRepository.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
