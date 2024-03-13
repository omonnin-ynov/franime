package Franime.controller;

import Franime.csv.CsvDataManager;
import Franime.model.Anime;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AnimeListController {

    @FXML
    private ListView<Anime> animeListView;

    private List<Anime> animeList;

    @FXML
    private TextField searchTextField;

    private Anime selectedAnime; // Ajout de cette variable

    public Anime getSelectedAnime() {
        return selectedAnime;
    }

    @FXML
    private void searchAnime() {
        String searchTerm = searchTextField.getText().toLowerCase();

        List<Anime> filteredList = animeList.stream()
                .filter(anime -> anime.getName().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());

        animeListView.getItems().setAll(filteredList);
    }

    @FXML
    public void initialize() {
        animeList = CsvDataManager.readData();
        animeListView.getItems().addAll(animeList);

        animeListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Anime anime, boolean empty) {
                super.updateItem(anime, empty);

                if (empty || anime == null || anime.getName() == null) {
                    setText(null);
                } else {
                    setText(anime.getName());
                }
            }
        });

        animeListView.setOnMouseClicked(event -> {
            selectedAnime = animeListView.getSelectionModel().getSelectedItem();
            if (selectedAnime != null) {
                openAnimeDetails(selectedAnime);
            }
        });
    }
    @FXML
    private void openUpdateAnimeForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/update_anime.fxml"));
            Parent root = loader.load();

            Stage updateAnimeStage = new Stage();
            updateAnimeStage.setTitle("Modifier un anime");
            updateAnimeStage.initModality(Modality.WINDOW_MODAL);
            updateAnimeStage.initOwner(animeListView.getScene().getWindow());

            UpdateAnimeController updateAnimeController = loader.getController();

            if (updateAnimeController != null) {
                updateAnimeController.setSelectedAnime(selectedAnime);

                Scene scene = new Scene(root);
                updateAnimeStage.setScene(scene);
                updateAnimeStage.showAndWait();
            } else {
                System.err.println("Le contrôleur de mise à jour d'anime est null.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void openAnimeDetails(Anime anime) {
        System.out.println("Ouverture des détails de l'anime : " + anime.getName());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/anime_details.fxml"));
            Parent root = loader.load();

            Stage detailsStage = new Stage();
            detailsStage.setTitle("Détails de l'anime");
            detailsStage.initModality(Modality.WINDOW_MODAL);
            detailsStage.initOwner(animeListView.getScene().getWindow());

            AnimeDetailsController detailsController = loader.getController();

            if (detailsController != null) {
                detailsController.setStage(detailsStage);
                detailsController.setSelectedAnime(anime);

                Scene scene = new Scene(root);
                detailsStage.setScene(scene);
                detailsStage.show();
            } else {
                System.err.println("Le contrôleur des détails de l'anime est null.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openAddAnimeForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/add_anime.fxml"));
            Parent root = loader.load();

            Stage addAnimeStage = new Stage();
            addAnimeStage.setTitle("Ajouter un nouvel anime");
            addAnimeStage.initModality(Modality.WINDOW_MODAL);
            addAnimeStage.initOwner(animeListView.getScene().getWindow());

            AddAnimeController addAnimeController = loader.getController();

            if (addAnimeController != null) {
                addAnimeController.setStage(addAnimeStage);
                Scene scene = new Scene(root);
                addAnimeStage.setScene(scene);
                addAnimeStage.showAndWait();

                animeList = CsvDataManager.readData();
                animeListView.getItems().setAll(animeList);
            } else {
                System.err.println("Le contrôleur d'ajout d'anime est null.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
