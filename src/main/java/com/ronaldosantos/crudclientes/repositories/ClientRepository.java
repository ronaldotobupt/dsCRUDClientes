package com.ronaldosantos.crudclientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronaldosantos.crudclientes.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
