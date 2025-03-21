package notifications.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "notification_templates")
@AllArgsConstructor
public class NotificationTemplate {
    @Id
    @Getter
    @Setter
    private long id;

    @Id
    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String content;

}
