package Franime.model;

public class Anime {
    private String name;
    private String type;
    private String imgSrc;
    private String episodeAndSeason;
    private int rank;
    private String director;
    private String description;

    // Constructeur
    public Anime(String name, String type, String imgSrc, String episodeAndSeason, int rank, String director, String description) {
        this.name = name;
        this.type = type;
        this.imgSrc = imgSrc;
        this.episodeAndSeason = episodeAndSeason;
        this.rank = rank;
        this.director = director;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getEpisodeAndSeason() {
        return episodeAndSeason;
    }

    public void setEpisodeAndSeason(String episodeAndSeason) {
        this.episodeAndSeason = episodeAndSeason;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Anime{name='%s', type='%s', imgSrc='%s', episodeAndSeason='%s', rank=%d, director='%s', description='%s'}",
                name, type, imgSrc, episodeAndSeason, rank, director, description);
    }
}
