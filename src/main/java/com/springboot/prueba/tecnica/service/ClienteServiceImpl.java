package com.springboot.prueba.tecnica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.prueba.tecnica.entities.Cliente;
import com.springboot.prueba.tecnica.repository.ClienteDao;

@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private ClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> todos() {
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	public Optional<Cliente> obtenerPorId(Long clienteId) {
		Optional<Cliente> cliente = clienteDao.findById(clienteId);
		if(cliente.isPresent()) {
			return cliente;
		}
		return null;
	}

	@Override
	public Cliente crear(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	public Cliente editar(Long clienteId, Cliente cliente) {
		Optional<Cliente> clienteExistente = clienteDao.findById(clienteId);
		if(clienteExistente.isPresent()) {
			Cliente clienteEnBD = clienteExistente.get();
			clienteEnBD.setNombre(cliente.getNombre());
            clienteEnBD.setGenero(cliente.getGenero());
            clienteEnBD.setEdad(cliente.getEdad());
            clienteEnBD.setIdentificacion(cliente.getIdentificacion());
            clienteEnBD.setDireccion(cliente.getDireccion());
            clienteEnBD.setTelefono(cliente.getTelefono());
            clienteEnBD.setContraseña(cliente.getContraseña());
            clienteEnBD.setEstado(cliente.getEstado());
			return clienteDao.save(clienteEnBD);
		}
		return null;
	}

	@Override
	public Boolean eliminar(Long clienteId) {
		Optional<Cliente> clienteExistente = clienteDao.findById(clienteId);
		 if (clienteExistente.isPresent()) {
            clienteDao.deleteById(clienteId);
            return true;
        } else {
            return false;
        }
}
	
	
}
