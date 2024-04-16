package com.example.colsubsidio.dto;


import com.example.colsubsidio.enums.TipoMovimiento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MovimientoDTO {

  private TipoMovimiento tipo;
  private Date fecha;
  private double valor;
  private Long cuentaId;
}
