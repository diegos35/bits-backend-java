package com.example.colsubsidio.service.impl;

import com.example.colsubsidio.ObjectNotFoundException;
import com.example.colsubsidio.entity.Cliente;
import com.example.colsubsidio.repository.ClienteRepository;
import com.example.colsubsidio.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {


  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  public Cliente guardarCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @Override
  public Cliente obtenerClientePorId(Long id) {
      return clienteRepository.findById(id)
          .orElseThrow(() -> new ObjectNotFoundException("Cliente no encontrado con ID: " + id));
  }

  @Override
  public List<Cliente> obtenerTodosLosClientes() {
    return clienteRepository.findAll();
  }

  @Override
  public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);

    if (optionalCliente.isPresent()) {
      Cliente cliente = optionalCliente.get();
      cliente.setNombre(clienteActualizado.getNombre());
      cliente.setDireccion(clienteActualizado.getDireccion());
      cliente.setTelefono(clienteActualizado.getTelefono());

      return clienteRepository.save(cliente);
    } else {
      throw new EntityNotFoundException(
          "El cliente con ID " + id + " no se encontró en la base de datos");
    }
  }

  @Override
  public void eliminarCliente(Long id) {
    clienteRepository.deleteById(id);
  }
}
