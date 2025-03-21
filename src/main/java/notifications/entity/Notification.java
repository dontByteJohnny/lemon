package notifications.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String userId;

    @Column(nullable = false)
    @Getter
    @Setter
    private String type;

    @Column(nullable = false)
    @Getter
    @Setter
    private String content;

    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDateTime createdAt;


    public Notification(String userId, String type, String content) {
        this.userId = userId;
        this.type = type;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }
}