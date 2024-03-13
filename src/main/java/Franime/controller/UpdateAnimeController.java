package Franime.controller;

import Franime.csv.CsvDataManager;
import Franime.model.Anime;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UpdateAnimeController {

    private Anime selectedAnime;

    @FXML
    private Button updateButton;


    public void setSelectedAnime(Anime selectedAnime) {
        this.selectedAnime = selectedAnime;
    }

    @FXML
    private void handleUpdateButtonAction() {
        Anime updatedAnime = getUpdatedAnimeFromForm();

        CsvDataManager.updateAnime(selectedAnime, updatedAnime);

        ((Stage) updateButton.getScene().getWindow()).close();
    }

    private Anime getUpdatedAnimeFromForm() {
        return null;
    }
}
