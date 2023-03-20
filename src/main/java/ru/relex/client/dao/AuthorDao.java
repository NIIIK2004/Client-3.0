package ru.relex.client.dao;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ru.relex.client.Entity.AuthorEntity;
import ru.relex.client.Response.BaseResponse;
import ru.relex.client.Utils.HTTPUtils;

import java.io.IOException;

import static ru.relex.client.controller.AuthorScreenController.apiA;

public class AuthorDao {
    static HTTPUtils http = new HTTPUtils();
    static Gson gson = new Gson();

    public static String getAuthor() throws IOException {
        return http.get(apiA, "all");
    }

    public static AuthorEntity sendAuthorAndGetData(AuthorEntity author) throws IOException {
        String response = http.post(apiA + "add", gson.toJson(author));
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        return gson.fromJson(jsonObject.get("data"), AuthorEntity.class);
    }

    public static String updateAuthor(AuthorEntity author) throws IOException {
        return http.put(apiA + "update", gson.toJson(author));
    }

    public static BaseResponse deleteAuthor(AuthorEntity author) throws IOException {
        return http.delete(apiA, author.getId());
    }
}
