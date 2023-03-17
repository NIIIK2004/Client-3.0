package ru.relex.client.controller;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import lombok.Setter;
import ru.relex.client.Entity.AuthorEntity;
import ru.relex.client.Utils.AlertUtils;

public class AuthorScreenController {
    public static ObservableList<AuthorEntity> authorData = FXCollections.observableArrayList();
    public final static String api = "http://localhost:1000/api/v1/author/";

    AlertUtils alerts = new AlertUtils();
    static Gson gson = new Gson();

    @Setter
    private Stage stage;

    @FXML
    private TableColumn<AuthorEntity, String> authorName;

    @FXML
    private TableColumn<AuthorEntity, String> authorPatronymic;

    @FXML
    private TableColumn<AuthorEntity, String> authorSurname;

    @FXML
    private void clickAddAuthor() {
    }

    @FXML
    private void clickEditAuthor() {
    }

    @FXML
    private void clickDeleteAuthor() {
    }
}
