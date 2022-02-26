/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author DIANA
 */
@Data
@Entity
@Table(name = "prestamo")
public class PagoPrestamo implements Serializable {

    private static final long serialVersionUID = 123456L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPagoPrestamo", nullable = false)
    private Integer ididPagoPrestamo;
    
    @Column(name = "codPrestamo", nullable = false, length = 7)
    private String codigoPrestamo;

    @Column(name = "valorPago", nullable = false)
    private Double valorPago;

    @Column(name = "fechaPago", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPago;

    @Column(name = "horaPago", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private String horaPago;

    @Column(name = "nroCuota", nullable = false)
    private Integer nroCuota;

}
