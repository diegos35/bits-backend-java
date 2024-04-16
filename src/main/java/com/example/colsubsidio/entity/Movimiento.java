package com.example.colsubsidio.entity;


import com.example.colsubsidio.enums.TipoMovimiento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "movimientos")
public class  Movimiento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private TipoMovimiento tipo;

  private Date fecha;
  private double valor;

  @ManyToOne
  @JoinColumn(name = "cuenta_id", referencedColumnName = "id")
  private Cuenta cuenta;

}
