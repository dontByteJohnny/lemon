package notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public class NotificationDTO {
    @NonNull
    @Getter
    @Setter
    private String userId;
    @NonNull
    @Getter
    @Setter
    private String type;
    @NonNull
    @Getter
    @Setter
    private String content;

}
