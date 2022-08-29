package com.JukeBox.Model;

public class Genre {
    private int genreid;
    private String genre;

    public Genre(int genreid, String genre) {
        this.genreid = genreid;
        this.genre = genre;
    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreid=" + genreid +
                ", genre='" + genre + '\'' +
                '}';
    }
}
