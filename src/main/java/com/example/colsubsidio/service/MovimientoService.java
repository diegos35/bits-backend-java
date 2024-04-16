package com.example.colsubsidio.service;

import com.example.colsubsidio.dto.MovimientoDTO;
import com.example.colsubsidio.entity.Movimiento;
import java.util.List;

public interface MovimientoService {

  Movimiento agregarMovimiento(MovimientoDTO movimientoDTO);

  List<Movimiento> getMovimientosByCuentaId(Long cuentaId);
}
