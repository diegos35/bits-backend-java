package com.example.colsubsidio.controller;

import com.example.colsubsidio.entity.Cuenta;
import com.example.colsubsidio.service.CuentaService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin(origins = "*")
public class CuentaController {

  @Autowired
  private CuentaService cuentaService;

  @GetMapping
  public ResponseEntity<List<Cuenta>> getAllCuentas() {
    List<Cuenta> cuentas = cuentaService.obtenerTodasLasCuentas();
    return new ResponseEntity<>(cuentas, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<List<Cuenta>> getCuentasByClientId(@PathVariable Long id) {
    List<Cuenta> cuentas = cuentaService.findByClientId(id);
    if (cuentas.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(cuentas, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta) {
    Cuenta nuevaCuenta = cuentaService.guardarCuenta(cuenta);
    return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cuenta> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
    Cuenta cuentaActualizada = cuentaService.actualizarCuenta(id, cuenta);
    return new ResponseEntity<>(cuentaActualizada, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
    cuentaService.eliminarCuenta(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
