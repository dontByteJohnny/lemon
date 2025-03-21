package notifications.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class RedisCacheService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void saveToCache(String key, Object value, long expirationInSeconds) {
        try {
            redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(expirationInSeconds));
            log.info("save key-value", key, value);
        } catch (Exception e) {
            log.error("Error with redis {}", e.getMessage());
        }
    }


    public Object getFromCache(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error("Error with redis: {}", e.getMessage());
            return null;
        }
    }


    public void cacheFailedNotification(long notificationId, String notificationData) {
        String key = "failed_notification:" + notificationId;
        saveToCache(key, notificationData, 86400); // 1day
    }


    public List<String> getFailedNotifications() {
        try {
            Set<String> keys = redisTemplate.keys("failed_notification:*");
            if (keys == null || keys.isEmpty()) {
                return Collections.emptyList();
            }
            return keys.stream()
                    .map(this::getFromCache)
                    .filter(Objects::nonNull)
                    .map(Object::toString)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error with redis {}", e.getMessage());
            return Collections.emptyList();
        }
    }
}
