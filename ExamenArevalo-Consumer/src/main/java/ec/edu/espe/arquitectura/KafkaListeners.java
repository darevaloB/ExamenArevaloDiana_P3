/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura;

import ec.edu.espe.arquitectura.controller.PagoPrestamoController;
import ec.edu.espe.arquitectura.model.PagoPrestamo;
//import ec.edu.espe.arquitectura.kafka.service.MensajeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author DIANA
 */
@Slf4j
@Component
public class KafkaListeners {

    private final PagoPrestamoController mensajeController;
    private RestTemplate restTemplate = new RestTemplate();

    public KafkaListeners(PagoPrestamoController mensajeController) {
        this.mensajeController = mensajeController;
    }

    @KafkaListener(
            topics = "pagoPrestamos",
            groupId = "groupId"
    )
    public void Listener(PagoPrestamo pago) {
        log.info("Data recibida sin procesar nada: {}", pago);
        this.restTemplate.postForObject("http://localhost:8080/api/v1/pagoPrestamo", pago, PagoPrestamo.class);

    }
}
