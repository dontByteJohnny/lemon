package notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public class TransactionEventDTO {
    @Getter
    @Setter
    @NonNull
    private String userId;
    @Getter
    @Setter
    @NonNull
    private String type;
    @Getter
    @Setter
    @NonNull
    private String details;


}