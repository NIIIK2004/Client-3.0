package ru.relex.client.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublishingEntity {
    private Long id;
    private String name;
    private String city;

    public static PublishingEntity getNullObject() {
        return PublishingEntity.builder()
                .id(null)
                .name("")
                .city("")
                .build();
    }
}
