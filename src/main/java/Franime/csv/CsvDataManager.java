package Franime.csv;

import Franime.model.Anime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvDataManager {

    private static final String CSV_FILE_PATH = "anime_data.csv";

    public static List<Anime> readData() {
        List<Anime> animeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Vérifier que la ligne contient suffisamment d'éléments
                if (data.length >= 7) {
                    Anime anime = new Anime(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5], data[6]);
                    animeList.add(anime);
                } else {
                    // Gérer le cas où la ligne ne contient pas suffisamment d'éléments
                    System.err.println("Ligne du fichier CSV incomplète : " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return animeList;
    }

    public static void updateAnime(Anime oldAnime, Anime updatedAnime) {
        List<Anime> animeList = readData();

        for (int i = 0; i < animeList.size(); i++) {
            if (animeList.get(i).equals(oldAnime)) {
                animeList.set(i, updatedAnime);
                break;
            }
        }
        writeData(animeList);
    }

    public static void writeData(List<Anime> animeList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (Anime anime : animeList) {
                writer.write(String.format("%s,%s,%s,%s,%d,%s,%s\n",
                        anime.getName(), anime.getType(), anime.getImgSrc(),
                        anime.getEpisodeAndSeason(), anime.getRank(), anime.getDirector(), anime.getDescription()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
