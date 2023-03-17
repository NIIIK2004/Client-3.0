package ru.relex.client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditAuthorController {
    @FXML
    private TextField authorLastnameField;

    @FXML
    private TextField authorNameField;

    @FXML
    private TextField authorSurnameField;

    @FXML
    private Button buttonCloseWindow;

    @FXML
    private Button buttonSaveAuthor;

    @FXML
    void closeWindow(ActionEvent event) {

    }
}
