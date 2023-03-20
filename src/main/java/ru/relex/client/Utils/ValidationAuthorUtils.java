package ru.relex.client.Utils;

import ru.relex.client.Entity.AuthorEntity;

public class ValidationAuthorUtils {
    public static boolean validateAuthor(AuthorEntity author) {
        StringBuilder errorMessage = new StringBuilder();
        String name = author.getName();
        String lastname = author.getLastname();
        String surname = author.getSurname();

        if (name.isBlank() || !name.matches("[\\sA-ZА-Яa-zа-я0-9]{2,50}")) {
            errorMessage.append("Неправильно введено имя автора. " +
                    "Минимальное количество символов - 2, максимальное - 50\n\n");
        }
        if (lastname.isBlank() || !lastname.matches("[\\sA-ZА-Яa-zа-я0-9]{2,50}")) {
            errorMessage.append("Неправильно введено фамилия автора. " +
                    "Минимальное количество символов - 2, максимальное - 50\n\n");
        }
        if (surname.isBlank() || !surname.matches("[\\sA-ZА-Яa-zа-я0-9]{2,50}")) {
            errorMessage.append("Неправильно введено отчество автора. " +
                    "Минимальное количество символов - 2, максимальное - 50\n\n");
        }

        return errorMessage.length() == 0;
    }

    public static String getErrorMessageFromBookFields(String name, String lastname, String surname) {
        StringBuilder errorMessage = new StringBuilder();
        if (name.isBlank() || !name.matches("[\\sA-ZА-Яa-zа-я0-9]{2,50}")) {
            errorMessage.append("Неправильно введено имя автора. " +
                    "Минимальное количество символов - 2, максимальное - 120\n\n");
        }
        if (lastname.isBlank() || !lastname.matches("[\\sA-ZА-Яa-zа-я0-9]{2,50}")) {
            errorMessage.append("Неправильно введена фамилия автора. " +
                    "Минимальное количество символов - 2, максимальное - 120\n\n");
        }
        if (surname.isBlank() || !surname.matches("[\\sA-ZА-Яa-zа-я0-9]{2,50}")) {
            errorMessage.append("Неправильно введено отчество автора. " +
                    "Минимальное количество символов - 2, максимальное - 70\n\n");
        }
        return errorMessage.toString();
    }
}
