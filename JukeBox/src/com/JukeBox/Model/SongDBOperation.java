package com.JukeBox.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SongDBOperation {
    String url = "jdbc:mysql://localhost:3306/jukebox";
    String username = "root";
    String password = "Manik@ndan123";

    private  Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public boolean addSong(Song song) {
        boolean result = false;
        int artistId = checkAndInsertArtist(song.getSongArtist());
        int genreId = checkAndInsertGenre(song.getSongGenre());


        try {
            PreparedStatement ps = this.getConnection().prepareStatement("insert into Song(song_Name,song_album,genre_Id,artist_Id,song_Duration)values(?,?,?,?,?)");

            ps.setString(1, song.getSongName());
            ps.setString(2, song.getSongAlbum());
            ps.setInt(3, genreId);
            ps.setInt(4, artistId);
            ps.setString(5, song.getDuration());
            int rowCount = ps.executeUpdate();
            if (rowCount > 0)
                result = true;
            else
                result = false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int checkAndInsertArtist(String artist_Name) {
        int artist_Id = 0;
        try {
            PreparedStatement ps1 = this.getConnection().prepareStatement("select * from Artist where artist_Name=?");
            ps1.setString(1, artist_Name);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                artist_Id = rs.getInt(1);
            } else
                artist_Id = insertArtist(artist_Name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return artist_Id;
    }

    private int insertArtist(String artist_name) {
        int artist_Id = 0;
        try {
            PreparedStatement ps2 = this.getConnection().prepareStatement("insert into Artist(artist_Name)values(?)", Statement.RETURN_GENERATED_KEYS);
            ps2.setString(1, artist_name);
            int rowAffected = ps2.executeUpdate();
            if (rowAffected > 0) {
                ResultSet rs1 = ps2.getGeneratedKeys();
                rs1.next();
                artist_Id = rs1.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return artist_Id;
    }

    public int checkAndInsertGenre(String Genre) {
        int genre_Id = 0;
        try {
            PreparedStatement statement = this.getConnection().prepareStatement("select * from Genre where Genre=?");
            statement.setString(1, Genre);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                genre_Id = resultSet.getInt(1);
            } else {
                genre_Id = insertGenre(Genre);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return genre_Id;
    }

    private int insertGenre(String Genre) {
        int genre_Id = 0;
        try {
            PreparedStatement ps3 = this.getConnection().prepareStatement("insert into Genre(Genre)values(?)", Statement.RETURN_GENERATED_KEYS);
            ps3.setString(1, Genre);
            int rowAffected1 = ps3.executeUpdate();
            if (rowAffected1 > 0) {
                ResultSet rs2 = ps3.getGeneratedKeys();
                rs2.next();
                genre_Id = rs2.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return genre_Id;
    }
    public List<Song> fetchSong() throws SQLException{
        List<Song> songList = new ArrayList<>();

        Statement songview =this.getConnection().createStatement();
        ResultSet result = songview.executeQuery("select * from Song_Details");
        while (result.next()){
            songList.add(new Song(result.getString(2),result.getString(3),result.getString(5), result.getString(7), result.getString(8)));
        }
        return songList;
    }
}

