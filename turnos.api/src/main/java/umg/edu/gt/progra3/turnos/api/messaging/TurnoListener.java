package umg.edu.gt.progra3.turnos.api.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import umg.edu.gt.progra3.turnos.api.config.RabbitMQConfig;
import umg.edu.gt.progra3.turnos.repository.model.Turno;

@Component
public class TurnoListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void recibirTurno(Turno turno) {
        System.out.println("📥 [RabbitMQ] Turno recibido: " + turno.getCliente().getNombre());
        // Puedes guardar logs o registrar acciones futuras
    }
}
