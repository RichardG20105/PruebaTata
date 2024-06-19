package com.springboot.prueba.tecnica.service;

import java.util.List;

import com.springboot.prueba.tecnica.entities.Cuenta;

public interface ICuentaService {
	public List<Cuenta> todos();
	public Cuenta crear(Long id, Cuenta cuenta);
	public Cuenta editar(Long numeroCuenta, Cuenta cuenta);
	public Boolean eliminar(Long numeroCuenta);
}
