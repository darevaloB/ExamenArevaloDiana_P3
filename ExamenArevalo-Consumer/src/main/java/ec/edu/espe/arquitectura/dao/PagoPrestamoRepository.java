/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.PagoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DIANA
 */
public interface PagoPrestamoRepository extends JpaRepository<PagoPrestamo, Integer> {
    
}
