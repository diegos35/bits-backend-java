package com.example.colsubsidio.service.impl;

import com.example.colsubsidio.entity.Cuenta;
import com.example.colsubsidio.repository.CuentaRepository;
import com.example.colsubsidio.repository.MovimientoRepository;
import com.example.colsubsidio.service.CuentaService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {

  @Autowired
  private CuentaRepository cuentaRepository;

  @Override
  public Cuenta guardarCuenta(Cuenta cuenta) {
    cuenta.setSaldo(0);
    return cuentaRepository.save(cuenta);
  }

  @Override
  public Optional<Cuenta> obtenerCuentaPorId(Long id) {
    return cuentaRepository.findById(id);
  }
  @Override
  public List<Cuenta> findByClientId(Long id) {
    return cuentaRepository.findByClientId(id);
  }

  @Override
  public List<Cuenta> obtenerTodasLasCuentas() {
    return cuentaRepository.findAll();
  }

  @Override
  public Cuenta actualizarCuenta(Long id, Cuenta cuentaActualizada) {
    Optional<Cuenta> optionalCuenta = cuentaRepository.findById(id);
    if (optionalCuenta.isPresent()) {
      Cuenta cuenta = optionalCuenta.get();
      cuenta.setNumero(cuentaActualizada.getNumero());
      return cuentaRepository.save(cuenta);
    } else {
      throw new EntityNotFoundException(
          "La cuenta con ID " + id + " no se encontró en la base de datos");
    }
  }

  @Override
  public void eliminarCuenta(Long id) {
    cuentaRepository.deleteById(id);
  }
}
