package notifications.service;

import lombok.AllArgsConstructor;
import notifications.dto.NotificationDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PushNotificationService {
    public boolean sendPush(NotificationDTO dto) {
        return false;
    }
}