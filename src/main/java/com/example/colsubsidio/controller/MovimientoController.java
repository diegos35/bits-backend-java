package com.example.colsubsidio.controller;

import com.example.colsubsidio.dto.MovimientoDTO;
import com.example.colsubsidio.entity.Movimiento;
import com.example.colsubsidio.service.MovimientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimientos")
@CrossOrigin(origins = "*")
public class MovimientoController {

  @Autowired
  private MovimientoService movimientoService;

  @GetMapping("/{id}")
  public ResponseEntity<List<Movimiento>> getMovimientosByCuentaId(@PathVariable Long id) {
    List<Movimiento> movimientos = movimientoService.getMovimientosByCuentaId(id);
    return new ResponseEntity<>(movimientos, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> agregarMovimiento(@RequestBody MovimientoDTO movimientoDTO) {
    try {
      Movimiento movimiento = movimientoService.agregarMovimiento(movimientoDTO);
      return new ResponseEntity<>(movimiento, HttpStatus.CREATED);
    } catch (RuntimeException ex) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(ex.getMessage());
    }
  }
}
