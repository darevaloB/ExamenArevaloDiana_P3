/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.PagoPrestamoRepository;
import ec.edu.espe.arquitectura.model.PagoPrestamo;
import org.springframework.stereotype.Service;

/**
 *
 * @author DIANA
 */
@Service
public class PagoPrestamoService {
    
     private final PagoPrestamoRepository pagoPrestamoRepository;

    public PagoPrestamoService(PagoPrestamoRepository pagoPrestamoRepository) {
        this.pagoPrestamoRepository = pagoPrestamoRepository;
    }

    
    public void guardarPagoPrestamo(PagoPrestamo pago) {
        this.pagoPrestamoRepository.save(pago);
    }
}
