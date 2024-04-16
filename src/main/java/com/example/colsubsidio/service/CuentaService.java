package com.example.colsubsidio.service;

import com.example.colsubsidio.entity.Cliente;
import com.example.colsubsidio.entity.Cuenta;
import java.util.List;
import java.util.Optional;

public interface CuentaService {

  Cuenta guardarCuenta(Cuenta cuenta);

  Optional<Cuenta> obtenerCuentaPorId(Long id);
  List<Cuenta> findByClientId(Long clientId);

  List<Cuenta> obtenerTodasLasCuentas();

  Cuenta actualizarCuenta(Long id, Cuenta cuentaActualizada);

    void eliminarCuenta(Long id);

}
