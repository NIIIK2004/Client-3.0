package ru.relex.client.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.relex.client.Entity.BookEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookResponse extends BaseResponse {
    private BookEntity data;

    public BookResponse(boolean success, String message, BookEntity data) {
        super(success, message);
        this.data = data;
    }
}
