package com.springboot.prueba.tecnica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.prueba.tecnica.entities.Cliente;
import com.springboot.prueba.tecnica.entities.Cuenta;
import com.springboot.prueba.tecnica.repository.ClienteDao;
import com.springboot.prueba.tecnica.repository.CuentaDao;

@Service
public class CuentaServiceImpl implements ICuentaService{
	@Autowired
	private CuentaDao cuentaDao;
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> todos() {
		return (List<Cuenta>) cuentaDao.findAll();
	}

	@Override
	public Cuenta crear(Long id, Cuenta cuenta) {
		Optional<Cliente> cliente = clienteDao.findById(id);
		if(cliente.isPresent()) {
			cuenta.setCliente(cliente.get());
			return cuentaDao.save(cuenta);			
		}
		return null;
	}

	@Override
	public Cuenta editar(Long numeroCuenta, Cuenta cuenta) {
		Optional<Cuenta> cuentaExiste = cuentaDao.findById(numeroCuenta);
		if(cuentaExiste.isPresent()) {
			Cuenta cuentaEnBd = cuentaExiste.get();
			cuentaEnBd.setEstado(cuenta.getEstado());
			cuentaEnBd.setSaldoInicial(cuenta.getSaldoInicial());
			cuentaEnBd.setTipo(cuenta.getTipo());
			return cuentaDao.save(cuentaEnBd);
		}
		return null;
	}

	@Override
	public Boolean eliminar(Long numeroCuenta) {
		Optional<Cuenta> cuentaExiste = cuentaDao.findById(numeroCuenta);
		if(cuentaExiste.isPresent()) {
			cuentaDao.deleteById(numeroCuenta);
			return true;
		}
		return false;
	}
	
}
