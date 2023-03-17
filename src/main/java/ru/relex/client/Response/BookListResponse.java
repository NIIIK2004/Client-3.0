package ru.relex.client.Response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.relex.client.Entity.BookEntity;

import java.util.List;
@Data
@RequiredArgsConstructor
public class BookListResponse extends BaseResponse {
    public List<BookEntity> data;

    public BookListResponse(List<BookEntity> data) {
        super(true, "Список книг");
        this.data = data;
    }
}
