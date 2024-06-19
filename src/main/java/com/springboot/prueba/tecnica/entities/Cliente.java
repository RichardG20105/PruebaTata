package com.springboot.prueba.tecnica.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Persona{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="cliente_id")
	private Long id;
	
	private String contraseña;
	private Boolean estado;
	
	@OneToMany(mappedBy = "cliente")
    private Set<Cuenta> cuentas = new HashSet<>();
	
	public Cliente() {
		super();
	}
	
	public Cliente(Long id, String contraseña, Boolean estado) {
		super();
		this.id = id;
		this.contraseña = contraseña;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Set<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
}
