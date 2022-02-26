package ec.edu.espe.arquitectura;

import com.github.javafaker.Faker;
import ec.edu.espe.arquitectura.model.PagoPrestamo;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

@SpringBootApplication
@Slf4j
public class ExamenArevaloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenArevaloApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Object> kafkaTemplate) {
        return args -> {
            Faker faker = new Faker();
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            PagoPrestamo pago = new PagoPrestamo();
            for (int i = 0; i < 10; i++) {
                pago.setCodigoPrestamo(faker.number().digits(7));
                pago.setValorPago(faker.number().randomDouble(3, 2, 5));
                pago.setFechaPago(date);
                pago.setHoraPago(dateFormat.format(date));
                pago.setNroCuota(faker.number().randomDigit());
                log.info("PagoPrestamo: {}", pago);
                ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send("pagoPrestamos", pago);
                send.addCallback(new KafkaSendCallback<String, Object>() {
                    @Override
                    public void onSuccess(SendResult<String, Object> result) {
                        log.info("Mensaje enviado: {}", result.getRecordMetadata());
                    }

                    @Override
                    public void onFailure(Throwable ex) {
                        log.error("Error al enviar el mensaje {}", ex);
                    }

                    @Override
                    public void onFailure(KafkaProducerException ex) {
                        log.error("Error al enviar el mensaje {}", ex); //To change body of generated methods, choose Tools | Templates.
                    }

                });
            }
        };
    }
}
