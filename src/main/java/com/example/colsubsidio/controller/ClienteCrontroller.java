package com.example.colsubsidio.controller;

import com.example.colsubsidio.ObjectNotFoundException;
import com.example.colsubsidio.entity.Cliente;
import com.example.colsubsidio.service.ClienteService;
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
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteCrontroller {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
  public ResponseEntity<List<Cliente>> getAll() {
    List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
    return new ResponseEntity<>(clientes, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Cliente> saveClient(@RequestBody Cliente cliente) {
    Cliente clienteGuardado = clienteService.guardarCliente(cliente);
    return new ResponseEntity<>(clienteGuardado, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getClientById(@PathVariable Long id) {
    try {
      Cliente cliente = clienteService.obtenerClientePorId(id);
      return new ResponseEntity<>(cliente, HttpStatus.OK);
    } catch (ObjectNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> updateAccount(@PathVariable Long id, @RequestBody Cliente cliente) {
    Cliente clienteActualizado = clienteService.actualizarCliente(id, cliente);
    return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    clienteService.eliminarCliente(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
