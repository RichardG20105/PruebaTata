package com.springboot.prueba.tecnica.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.prueba.tecnica.entities.Movimientos;

public interface MovimientosDao extends CrudRepository<Movimientos, Long> {
	@Query("SELECT m FROM Movimientos m WHERE m.cuenta.cliente.id = :clienteId AND m.fecha BETWEEN :startDate AND :endDate ORDER BY m.fecha DESC")
    List<Movimientos> findByCuentaClienteIdAndFechaBetweenOrderByFechaDesc(
        @Param("clienteId") Long clienteId,
        @Param("startDate") Date startDate,
        @Param("endDate") Date endDate
    );
}
