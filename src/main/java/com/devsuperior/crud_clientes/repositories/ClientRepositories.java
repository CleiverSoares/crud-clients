package com.devsuperior.crud_clientes.repositories;

import com.devsuperior.crud_clientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositories extends JpaRepository<Client, Long> {
}
