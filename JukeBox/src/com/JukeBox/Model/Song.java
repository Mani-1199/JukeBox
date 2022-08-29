package com.JukeBox.Model;

public class Song {


    private String songName;
    private String songAlbum;
    private String songGenre;
    private String songArtist;
    private String duration;

    public Song(String songName, String songAlbum, String songGenre, String songArtist, String duration) {
        this.songName = songName;
        this.songAlbum = songAlbum;
        this.songGenre = songGenre;
        this.songArtist = songArtist;
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + songName + '\'' +
                ", songAlbum='" + songAlbum + '\'' +
                ", songGenre='" + songGenre + '\'' +
                ", songArtist='" + songArtist + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
