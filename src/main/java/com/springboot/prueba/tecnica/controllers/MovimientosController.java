package com.springboot.prueba.tecnica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.prueba.tecnica.entities.Movimientos;
import com.springboot.prueba.tecnica.entities.MovimientosRequest;
import com.springboot.prueba.tecnica.service.IMovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
	@Autowired
	private IMovimientoService movimientoService;
	
	@GetMapping
	public ResponseEntity<List<Movimientos>> listarClientes(){
		List<Movimientos> movimientos = movimientoService.todos();
		if(movimientos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(movimientos, HttpStatus.OK);
	}
	
	@PostMapping("/crear/{id}")
	public ResponseEntity<Movimientos> crearCliente(@PathVariable("id") Long id,@RequestBody Movimientos movimiento){
		return new ResponseEntity<Movimientos>(movimientoService.crear(id, movimiento), HttpStatus.CREATED);
	}
	
	@PostMapping("/cliente")
    public ResponseEntity<List<Movimientos>> obtenerMovimientosPorCliente(@RequestBody MovimientosRequest movimientosRequest) {
        List<Movimientos> movimientos = movimientoService.obtenerPorClienteAndFechas(
                movimientosRequest.getClienteId(),
                movimientosRequest.getStartDate(),
                movimientosRequest.getEndDate()
        );
        if (movimientos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movimientos, HttpStatus.OK);
    }
}
