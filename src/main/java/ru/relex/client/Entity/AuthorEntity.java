package ru.relex.client.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorEntity {
    private Long id;
    private String name;
    private String surname;
    private String lastname;

    public static AuthorEntity getNullObject() {
        return AuthorEntity.builder()
                .id(null)
                .name("")
                .surname("")
                .lastname("")
                .build();
    }
}
