package com.example.colsubsidio.service.impl;

import com.example.colsubsidio.dto.MovimientoDTO;
import com.example.colsubsidio.entity.Cuenta;
import com.example.colsubsidio.entity.Movimiento;
import com.example.colsubsidio.enums.TipoMovimiento;
import com.example.colsubsidio.repository.MovimientoRepository;
import com.example.colsubsidio.service.CuentaService;
import com.example.colsubsidio.service.MovimientoService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoServiceImpl implements MovimientoService {

  @Autowired
  CuentaService cuentaService;

  @Autowired
  private MovimientoRepository movimientoRepository;

  @Override
  public List<Movimiento> getMovimientosByCuentaId(Long cuentaId) {
    Cuenta cuenta = cuentaService.obtenerCuentaPorId(cuentaId)
        .orElseThrow(() -> new EntityNotFoundException("Cuenta no encontrada con ID: " + cuentaId));

    return movimientoRepository.findByCuentaId(cuenta.getId());
  }

    @Override
  public Movimiento agregarMovimiento(MovimientoDTO movimientoDTO) {
    Cuenta cuenta = cuentaService.obtenerCuentaPorId(movimientoDTO.getCuentaId())
        .orElseThrow(() -> new EntityNotFoundException(
            "Cuenta no encontrada con ID: " + movimientoDTO.getCuentaId()));

    double saldoDespuesMovimiento;
    if (TipoMovimiento.DEBITO.equals(movimientoDTO.getTipo())) {
      saldoDespuesMovimiento = cuenta.getSaldo() + movimientoDTO.getValor();
    } else {
      saldoDespuesMovimiento = cuenta.getSaldo() - movimientoDTO.getValor();
    }
    if (saldoDespuesMovimiento < 0) {
      throw new RuntimeException("El movimiento resultaría en un saldo negativo en la cuenta.");
    }

    cuenta.setSaldo(saldoDespuesMovimiento);

    Movimiento movimiento = new Movimiento();
    movimiento.setTipo(movimientoDTO.getTipo());
    movimiento.setFecha(new Date());
    movimiento.setValor(movimientoDTO.getValor());
    movimiento.setCuenta(cuenta);

    movimientoRepository.save(movimiento);
    cuentaService.actualizarCuenta(movimientoDTO.getCuentaId(),cuenta);

    return movimiento;
  }
}
