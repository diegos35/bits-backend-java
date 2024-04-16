package com.example.colsubsidio.repository;

import com.example.colsubsidio.entity.Movimiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

  @Query("SELECT m FROM Movimiento m WHERE m.cuenta.id = :cuentaId")
  List<Movimiento> findByCuentaId(Long cuentaId);
}
