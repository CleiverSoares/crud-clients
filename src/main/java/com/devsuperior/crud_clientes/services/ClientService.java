package com.devsuperior.crud_clientes.services;

import com.devsuperior.crud_clientes.dto.ClientDTO;
import com.devsuperior.crud_clientes.entities.Client;
import com.devsuperior.crud_clientes.repositories.ClientRepositories;
import com.devsuperior.crud_clientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepositories repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado! ID: " + id));
        return new ClientDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

}
