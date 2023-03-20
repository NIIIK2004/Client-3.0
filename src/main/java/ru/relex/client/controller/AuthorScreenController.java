package ru.relex.client.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.Setter;
import ru.relex.client.Entity.AuthorEntity;
import ru.relex.client.MainApp;
import ru.relex.client.Utils.AlertUtils;
import ru.relex.client.Utils.ValidationAuthorUtils;
import ru.relex.client.dao.AuthorDao;

import java.io.IOException;

public class AuthorScreenController {
    public static ObservableList<AuthorEntity> authorData = FXCollections.observableArrayList();
    public final static String apiA = "http://localhost:1000/api/v1/author/";

    AlertUtils alerts = new AlertUtils();
    static Gson gson = new Gson();

    @Setter
    private Stage stage;

    @FXML
    private TableView<AuthorEntity> tableAuthor;

    @FXML
    private TableColumn<AuthorEntity, String> authorName;

    @FXML
    private TableColumn<AuthorEntity, String> authorPatronymic;

    @FXML
    private TableColumn<AuthorEntity, String> authorSurname;

    @FXML
    private void initialize() {
        try {
            getData();
            updateTable();
        } catch (IOException e) {
            alerts.serverNotRun(stage);
            System.exit(0);
        }
    }

    @FXML
    private void clickAddAuthor() throws IOException {
        AuthorEntity author = AuthorEntity.getNullObject();
        MainApp.showEditDialogAuthor(author);
        if (ValidationAuthorUtils.validateAuthor(author)) {
            addAuthor(author);
        }
    }

    @FXML
    private void clickEditAuthor() throws IOException {
        AuthorEntity author = tableAuthor.getSelectionModel().getSelectedItem();
        if (author != null) {
            MainApp.showEditDialogAuthor(author);
            updateAuthor(author);
        } else {
            alerts.showNotSelected();
        }
    }

    @FXML
    private void clickDeleteAuthor() throws IOException {
        AuthorEntity author = tableAuthor.getSelectionModel().getSelectedItem();
        if (author != null) {
            AuthorDao.deleteAuthor(author);
        } else {
            alerts.showNotSelected();
        }
    }

    private void updateTable() {
        authorName.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        authorSurname.setCellValueFactory(new PropertyValueFactory<>("authorSurname"));
        authorPatronymic.setCellValueFactory(new PropertyValueFactory<>("authorPatronymic"));
    }

    public static void getData() throws IOException {
        String response = AuthorDao.getAuthor();
        JsonObject base = gson.fromJson(response, JsonObject.class);
        JsonArray jsonArray = base.getAsJsonArray("data");
        for (JsonElement element : jsonArray) {
            AuthorEntity newAuthor = gson.fromJson(element.toString(), AuthorEntity.class);
            authorData.add(newAuthor);
        }
    }

    public static void addAuthor(AuthorEntity author) throws IOException {
        Long id = AuthorDao.sendAuthorAndGetData(author).getId();
        author.setId(id);
        authorData.add(author);
        System.out.println(author);
    }

    public static void updateAuthor(AuthorEntity author) throws IOException {
        AuthorDao.updateAuthor(author);
        int bookIndex = authorData.indexOf(author);
        authorData.set(bookIndex, author);
    }


}
