package com.ronaldosantos.crudclientes.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ronaldosantos.crudclientes.dto.ClientDTO;
import com.ronaldosantos.crudclientes.entities.Client;
import com.ronaldosantos.crudclientes.repositories.ClientRepository;
import com.ronaldosantos.crudclientes.servicies.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable){
		Page<Client> result = repository.findAll(pageable);
		return result.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado"));
		return new ClientDTO(client);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		copyDtoToEntity(dto,entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getReferenceById(id);
			copyDtoToEntity(dto,entity);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		}
	catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
	}
	
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}

}
