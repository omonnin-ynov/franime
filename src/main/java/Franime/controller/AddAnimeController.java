package Franime.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddAnimeController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField imgSrcField;

    @FXML
    private TextField episodeAndSeasonField;

    @FXML
    private TextField rankField;

    @FXML
    private TextField directorField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button saveButton;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Méthode appelée lorsque le bouton "Enregistrer" est cliqué
    @FXML
    private void addAnime() {
        String name = nameField.getText();
        String type = typeField.getText();
        String imgSrc = imgSrcField.getText();
        String episodeAndSeason = episodeAndSeasonField.getText();
        String rank = rankField.getText();
        String director = directorField.getText();
        String description = descriptionField.getText();

        addToCSV(name, type, imgSrc, episodeAndSeason, rank, director, description);

        clearFields();

        stage.close();
    }

    // Méthode pour ajouter les données dans le CSV
    private void addToCSV(String name, String type, String imgSrc, String episodeAndSeason,
                          String rank, String director, String description) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("anime_data.csv", true))) {
            // Ajouter les données au CSV
            writer.println(name + "," + type + "," + imgSrc + "," + episodeAndSeason + ","
                    + rank + "," + director + "," + description);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    // Méthode pour effacer les champs après l'ajout
    private void clearFields() {
        nameField.clear();
        typeField.clear();
        imgSrcField.clear();
        episodeAndSeasonField.clear();
        rankField.clear();
        directorField.clear();
        descriptionField.clear();
    }
}
