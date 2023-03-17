package ru.relex.client.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.relex.client.Entity.AuthorEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorResponse extends BaseResponse {
    private AuthorEntity author;

    public AuthorResponse(boolean success, String message, AuthorEntity author) {
        super(success, message);
        this.author = author;
    }

    public AuthorResponse(AuthorEntity author) {
        super(true, "Author data:");
    }
}
