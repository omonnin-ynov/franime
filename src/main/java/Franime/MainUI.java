package Franime;

import Franime.controller.AnimeListController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/anime_list.fxml"));
        Parent root = loader.load();
        AnimeListController animeListController = loader.getController();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Titre de ta Fenêtre");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
