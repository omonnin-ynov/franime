package Franime.controller;

import Franime.model.Anime;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class AnimeDetailsController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label directorLabel;

    @FXML
    private Label descriptionLabel;

    private Stage stage;

    private Anime selectedAnime;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSelectedAnime(Anime selectedAnime) {
        this.selectedAnime = selectedAnime;
        updateDetails();
    }

    private void updateDetails() {
        if (selectedAnime != null) {
            nameLabel.setText(selectedAnime.getName());
            typeLabel.setText("Type: " + selectedAnime.getType());
            directorLabel.setText("Director: " + selectedAnime.getDirector());
            descriptionLabel.setText(selectedAnime.getDescription());
        }
    }

    @FXML
    private void handleClose() {
        if (stage != null) {
            stage.close();
        }
    }
}
