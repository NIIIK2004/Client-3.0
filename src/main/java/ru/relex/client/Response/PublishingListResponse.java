package ru.relex.client.Response;

import lombok.Data;
import ru.relex.client.Entity.PublishingEntity;

import java.util.List;

@Data
public class PublishingListResponse extends BaseResponse {
    private List<PublishingEntity> data;

    public PublishingListResponse(List<PublishingEntity> data) {
        super(true, "Список Издательств");
        this.data = data;
    }
}
