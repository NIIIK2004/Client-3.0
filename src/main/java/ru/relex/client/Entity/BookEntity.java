package ru.relex.client.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookEntity {
    private Long id;

    private AuthorEntity author;
    private PublishingEntity publishing;

    private String title;
    private String typeBook;
    private String year;

    public static BookEntity getNullObject() {
        return BookEntity.builder()
                .id(null)
                .typeBook("")
                .author(AuthorEntity.getNullObject())
                .publishing(PublishingEntity.getNullObject())
                .year("")
                .title("")
                .build();
    }
   /* @Override
    public BookEntity clone() {
        try {
            BookEntity book = (BookEntity) super.clone();
            return (BookEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return getNullObject();
    }*/
}
