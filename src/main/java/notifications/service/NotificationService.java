package notifications.service;

import lombok.AllArgsConstructor;
import notifications.dto.NotificationDTO;
import notifications.entity.Notification;
import notifications.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository repository;
    private final EmailService emailService;
    private final PushNotificationService pushService;
    private final RedisCacheService redisCacheService;

    public void processNotification(NotificationDTO dto) {
        Notification notification = new Notification(dto.getUserId(), dto.getType(), dto.getContent());
        repository.save(notification);

        // enviar email y push
        boolean emailSent = emailService.sendEmail(dto);
        boolean pushSent = pushService.sendPush(dto);

        if (!emailSent || !pushSent) {
            redisCacheService.cacheFailedNotification(notification.getId(), notification.getContent());
        }

    }
}
