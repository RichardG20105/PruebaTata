package com.springboot.prueba.tecnica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.prueba.tecnica.entities.Cuenta;
import com.springboot.prueba.tecnica.service.ICuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
	@Autowired
	private ICuentaService cuentaService;
	
	@GetMapping
	public ResponseEntity<List<Cuenta>> listarClientes(){
		List<Cuenta> cuentas = cuentaService.todos();
		if(cuentas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cuentas, HttpStatus.OK);
	}
	
	@PostMapping("/crear/{id}")
	public ResponseEntity<Cuenta> crearCliente(@PathVariable("id") Long id,@RequestBody Cuenta cuenta){
		return new ResponseEntity<Cuenta>(cuentaService.crear(id, cuenta), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable("id") Long id, @RequestBody Cuenta cuenta){
		Cuenta cuentaActualizado = cuentaService.editar(id, cuenta);
		if(cuentaActualizado != null) {
			return new ResponseEntity<Cuenta>(cuentaActualizado, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminarCuenta(@PathVariable("id") Long id){
		Boolean response = cuentaService.eliminar(id);
		if(response) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
