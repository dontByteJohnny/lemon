package notifications.service;

import lombok.AllArgsConstructor;
import notifications.dto.NotificationDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    public boolean sendEmail(NotificationDTO dto) {
        return false;
    }
}