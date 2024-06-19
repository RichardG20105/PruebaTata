package com.springboot.prueba.tecnica.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.prueba.tecnica.entities.Cuenta;
import com.springboot.prueba.tecnica.entities.Movimientos;
import com.springboot.prueba.tecnica.repository.CuentaDao;
import com.springboot.prueba.tecnica.repository.MovimientosDao;

@Service
public class MovimientoServiceImpl implements IMovimientoService {
	@Autowired
	private MovimientosDao movimientosDao;
	
	@Autowired
	private CuentaDao cuentaDao;
	@Override
	public List<Movimientos> todos() {
		return (List<Movimientos>) movimientosDao.findAll();
	}

	@Override
	public Movimientos crear(Long id, Movimientos movimiento) {
		Optional<Cuenta> cuenta = cuentaDao.findById(id);
		if(cuenta.isPresent()) {
			movimiento.setCuenta(cuenta.get());
			return movimientosDao.save(movimiento);
		}
		return null;
	}

	@Override
	public List<Movimientos> obtenerPorClienteAndFechas(Long clientId, Date startDate, Date endDate) {
		return movimientosDao.findByCuentaClienteIdAndFechaBetweenOrderByFechaAsc(clientId, startDate, endDate);
	}
}
