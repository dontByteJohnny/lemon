package notifications.messaging;

import lombok.AllArgsConstructor;
import notifications.dto.NotificationDTO;
import notifications.dto.TransactionEventDTO;
import notifications.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotificationConsumer {
    private static final String TOPIC_NAME = "transactions";
    private static final String GROUP_ID = "transactions-group";

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void listenTransactions(String transaction) {
        System.out.println("received transaction " + transaction);
    }
}
