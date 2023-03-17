package ru.relex.client.Response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.relex.client.Entity.AuthorEntity;

import java.util.List;

@Data
public class AuthorListResponse extends BaseResponse {
    private List<AuthorEntity> data;

    public AuthorListResponse(List<AuthorEntity> data) {
        super(true, "Список Авторов");
        this.data = data;
    }
}
