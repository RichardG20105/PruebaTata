package com.springboot.prueba.tecnica.service;

import java.util.Date;
import java.util.List;

import com.springboot.prueba.tecnica.entities.Movimientos;

public interface IMovimientoService {
	public List<Movimientos> todos();
	public Movimientos crear(Long id, Movimientos movimiento);
	public List<Movimientos> obtenerPorClienteAndFechas(Long clientId, Date startDate, Date endDate);
}
