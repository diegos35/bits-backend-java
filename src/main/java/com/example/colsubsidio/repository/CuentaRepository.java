package com.example.colsubsidio.repository;

import com.example.colsubsidio.entity.Cuenta;
import com.example.colsubsidio.entity.Movimiento;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

  @Query("SELECT c FROM Cuenta c WHERE c.cliente.id = :clienteId")
  List<Cuenta> findByClientId(Long clienteId);

}
