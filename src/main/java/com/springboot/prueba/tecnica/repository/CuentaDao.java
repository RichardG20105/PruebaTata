package com.springboot.prueba.tecnica.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.prueba.tecnica.entities.Cuenta;

public interface CuentaDao extends CrudRepository<Cuenta, Long>{

}
