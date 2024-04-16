package com.example.colsubsidio.service;

import ch.qos.logback.core.net.server.Client;
import com.example.colsubsidio.entity.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {

  Cliente guardarCliente(Cliente cliente);

  Cliente obtenerClientePorId(Long id);

  List<Cliente> obtenerTodosLosClientes();

  Cliente actualizarCliente(Long id, Cliente clienteActualizado);

  void eliminarCliente(Long id);
}
