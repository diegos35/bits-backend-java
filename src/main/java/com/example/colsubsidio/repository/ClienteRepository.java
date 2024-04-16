package com.example.colsubsidio.repository;

import com.example.colsubsidio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
