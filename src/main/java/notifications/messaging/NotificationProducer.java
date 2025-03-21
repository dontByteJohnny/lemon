package notifications.messaging;

import lombok.AllArgsConstructor;
import notifications.dto.TransactionEventDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {
    private static final String TOPIC_NAME = "transactions";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTransaction(String transaction) {
        kafkaTemplate.send(TOPIC_NAME, transaction);
    }
}