package ru.relex.client.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;
import ru.relex.client.Response.BaseResponse;
import ru.relex.client.Response.BookListResponse;

import java.io.IOException;

public class HTTPUtils {
     static OkHttpClient client = new OkHttpClient();
     static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder().url(url).post(body).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String get(String url, String args) throws IOException {
        Request request = new Request.Builder().url(url + args).build();
        try (Response response = client.newCall(request).execute()) {
            /*BookListResponse book;
            book = gson.fromJson(response.body().string(), BookListResponse.class);
            System.out.println(book.getData().get(0).getAuthor().getLastname());*/
            return response.body().string();
        }
    }

    public String put(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder().url(url).post(body).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public BaseResponse delete(String url, Long Id) throws IOException {
        System.out.println("delete book (id) - " + Id);
        Request request = new Request.Builder().url(url + "delete/" + Id).delete().build();
        try (Response response = client.newCall(request).execute()) {
            return gson.fromJson(response.body().string(), BaseResponse.class);
        }
    }
}
