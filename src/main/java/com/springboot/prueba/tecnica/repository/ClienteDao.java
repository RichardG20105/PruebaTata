package com.springboot.prueba.tecnica.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.prueba.tecnica.entities.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
}
