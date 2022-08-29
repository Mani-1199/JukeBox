package com.JukeBox.Model;

public class Playlist {

    private String playlistName;

    public Playlist( String playmistName) {
        this.playlistName = playmistName;
    }


    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                ", playlistName='" + playlistName + '\'' +
                '}';
    }
}
