package com.example.colsubsidio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String direccion;
  private String telefono;

  @JsonIgnore
  @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
  private List<Cuenta> cuentas;

}
