package com.example.colsubsidio.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "cuentas")
public class Cuenta {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String numero;
  private double saldo;

  @ManyToOne
  @JoinColumn(name = "cliente_id", referencedColumnName = "id")
  private Cliente cliente;

  @JsonIgnore
  @OneToMany(mappedBy = "cuenta", cascade = CascadeType .ALL)
  private List<Movimiento> movimientos;

}
