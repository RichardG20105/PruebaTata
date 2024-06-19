package com.springboot.prueba.tecnica.controllers;

import java.util.List;
import java.util.Optional;

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

import com.springboot.prueba.tecnica.entities.Cliente;
import com.springboot.prueba.tecnica.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> clientes = clienteService.todos();
		if(clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obterClienteId(@PathVariable("id") Long id){
		Optional<Cliente> cliente = clienteService.obtenerPorId(id);
		if(cliente.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.crear(cliente), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
		Cliente clienteActualizado = clienteService.editar(id, cliente);
		if(clienteActualizado != null) {
			return new ResponseEntity<Cliente>(clienteActualizado, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminarCliente(@PathVariable("id") Long id){
		Boolean response = clienteService.eliminar(id);
		if(response) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
