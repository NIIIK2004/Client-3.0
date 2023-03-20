package ru.relex.client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.relex.client.Entity.AuthorEntity;
import ru.relex.client.Utils.AlertUtils;
import ru.relex.client.Utils.ValidationAuthorUtils;
import ru.relex.client.dao.AuthorDao;
import ru.relex.client.dao.BookDao;

import java.io.IOException;

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
        editDialogStage.close();
    }

    private Stage editDialogStage;

    public void setEditDialogStage(Stage editDialogStage) {
        this.editDialogStage = editDialogStage;
    }


    private AuthorEntity author;

    public void setLabels(AuthorEntity author) {
        this.author = author;
        authorNameField.setText(author.getName());
        authorSurnameField.setText(author.getSurname());
        authorLastnameField.setText(author.getLastname());
    }


    private boolean okClicked = false;

    public boolean isOkClicked() {
        return okClicked;
    }

    public void saveAuthor() throws IOException {
        if (isInputValid()) {
            author.setName(authorNameField.getText());
            author.setLastname(authorLastnameField.getText());
            author.setSurname(authorSurnameField.getText());
            author.setId(AuthorDao.sendAuthorAndGetData(author).getId());

            okClicked = true;
            editDialogStage.close();
        }
    }

    private boolean isInputValid() {
       String errorMessage = ValidationAuthorUtils.getErrorMessageFromBookFields(
                authorNameField.getText(),
                authorSurnameField.getText(),
                authorLastnameField.getText()
        );
        if (errorMessage.length() == 0)
            return true;
        else {
            AlertUtils.showWarning(errorMessage);
            return false;
        }
    }
}
