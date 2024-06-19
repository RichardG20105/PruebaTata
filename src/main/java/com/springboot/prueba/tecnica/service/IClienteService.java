package com.springboot.prueba.tecnica.service;

import java.util.List;
import java.util.Optional;

import com.springboot.prueba.tecnica.entities.Cliente;

public interface IClienteService {
	public List<Cliente> todos();
	public Optional<Cliente> obtenerPorId(Long clienteId);
	public Cliente crear(Cliente cliente);
	public Cliente editar(Long clienteId, Cliente cliente);
	public Boolean eliminar(Long clienteId);
}
