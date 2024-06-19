package com.springboot.prueba.tecnica.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.prueba.tecnica.entities.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long>{

}
