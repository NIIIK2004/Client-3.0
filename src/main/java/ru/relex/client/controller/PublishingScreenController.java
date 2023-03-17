package ru.relex.client.controller;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import lombok.Setter;
import ru.relex.client.Entity.BookEntity;
import ru.relex.client.Entity.PublishingEntity;
import ru.relex.client.Utils.AlertUtils;

public class PublishingScreenController {
    public static ObservableList<PublishingEntity> publishingData = FXCollections.observableArrayList();
    public final static String api = "http://localhost:1000/api/v1/publishing/";

    AlertUtils alerts = new AlertUtils();
    static Gson gson = new Gson();

    @Setter
    private Stage stage;

    @FXML
    private TableColumn<PublishingEntity, String> publishingAddress;

    @FXML
    private TableColumn<PublishingEntity, String> publishingName;


    @FXML
    void clickAddPublishing() {
    }

    @FXML
    void clickEditPublishing() {
    }

    @FXML
    void clickDeletePublishing() {
    }

}
