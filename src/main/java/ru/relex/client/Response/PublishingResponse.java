package ru.relex.client.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.relex.client.Entity.PublishingEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class PublishingResponse extends BaseResponse {
    public PublishingResponse(boolean success, String message, PublishingEntity publishing) {
        super(success, message);
        this.publishing = publishing;
    }

    public PublishingResponse(PublishingEntity publishing) {
        super(true, "Publishing data:");
    }

    private PublishingEntity publishing;
}
