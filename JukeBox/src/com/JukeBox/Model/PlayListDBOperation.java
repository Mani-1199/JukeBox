package com.JukeBox.Model;

import java.sql.*;
import java.util.ArrayList;

public class PlayListDBOperation {
    String url = "jdbc:mysql://localhost:3306/jukebox";
    String username = "root";
    String password = "Manik@ndan123";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void createplaylist(String playListName) throws SQLException {

        PreparedStatement ps = this.getConnection().prepareStatement("insert into playlist(playListName)values (?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, playListName);

        int rowAffected = ps.executeUpdate();
        if (rowAffected > 0) {
            System.out.println("Playlistname Inserted");
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                System.out.println("Playlist Created");
            }
        }
    }
    public void displayPlaylist()throws  SQLException {
        PreparedStatement ps1= this.getConnection().prepareStatement("select * from playlist");
        ResultSet rs= ps1.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t "+rs.getString(2));
        }
    }
    public int searchSong(String songName) throws SQLException{
        int songid=0;
        PreparedStatement ps2 = this.getConnection().prepareStatement("select * from Song where song_Name=?");
        ps2.setString(1,songName);
        ResultSet rs1 = ps2.executeQuery();
        if(rs1.next()){
            songid=rs1.getInt(1);
            System.out.println("Song Present");
        }
        else {
            System.out.println("Song Not Present");
        }
        return songid;
    }
    public int searchPodcast(String podcastName) throws SQLException{
        int podcastid=0;
        PreparedStatement ps3 = this.getConnection().prepareStatement("select * from Podcast where podcast_Name=?");
        ps3.setString(1,podcastName);
        ResultSet rs2 = ps3.executeQuery();
        if(rs2.next()){
            podcastid=rs2.getInt(1);
            System.out.println("Podcast present");
        }
        else {
            System.out.println("Podcast Not Present");
        }
        return podcastid;
    }
    public int searchPlaylist(String playlistName) throws SQLException{
        int playlistid=0;
        PreparedStatement ps4 = this.getConnection().prepareStatement("select * from playlist where playlistName=?");
        ps4.setString(1,playlistName);
        ResultSet rs3 = ps4.executeQuery();
        if(rs3.next()){
            playlistid=rs3.getInt(1);
            System.out.println("Playlist Present");
        }
        else {
            System.out.println("Playlist Not Present");
        }
        return playlistid;
    }
    public boolean insertIntoPlaylistContent(String playListName,String trackName,int choice)throws SQLException{
        int playlistId=searchPlaylist(playListName);
        int trackId=0;
        if(choice==1){
            trackId=searchSong(trackName);
        }
        else
            trackId=searchPodcast(trackName);
            if(trackId!=0 && playlistId!=0){
                PreparedStatement ps5 = this.getConnection().prepareStatement("insert into PlaylistContent(playlistId,trackId) values(?,?)");
                ps5.setInt(1,playlistId);
                ps5.setInt(2,trackId);
                int insert = ps5.executeUpdate();
                if(insert>0){
                    System.out.println("PlayList Inserted");
                }
                else {
                    System.out.println("Playlist Not Inserted");
                }
            }
            else {
                System.out.println("Not Inserted");
            }
            return true;
        }
    public ArrayList<Integer> displayPlaycontent(String playlistName)throws  SQLException
    {
        int playlistId=searchPlaylist(playlistName);
        if(playlistId!=0) {
            PreparedStatement ps6= this.getConnection().prepareStatement(" select trackId from playlistcontent where playlistId=?");
            ps6.setInt(1,playlistId);
            ResultSet resultSet= ps6.executeQuery();
            ArrayList<Integer> trackIdList=new ArrayList<>();
            while(resultSet.next()){
                trackIdList.add(resultSet.getInt(1));
            }
            displayTrack(trackIdList);
        }
        else {
            System.out.println("playlistId is not found");
        }
        return null;
    }
    public void displayTrack(ArrayList<Integer> tracklist)throws SQLException
    {
        PreparedStatement ps7= this.getConnection().prepareStatement("select podcast_Name from podcast where podcast_Id=?");
        PreparedStatement ps8= this.getConnection().prepareStatement("select song_Name from Song where song_Id=?");
        for (int id:tracklist) {
            if(id>=100&& id<300)
            {
                ps8.setInt(1,id);
                ResultSet rs1=ps8.executeQuery();
                System.out.print("Song Name: ");
                if(rs1.next())
                {
                    System.out.print(rs1.getString(1));
                }
            }
            else if(id>=300&&id<1000)
            {
                ps7.setInt(1,id);
                ResultSet rs2=ps7.executeQuery();
                if(rs2.next())
                {
                    System.out.println(rs2.getString(1));
                }
            }
        }
    }
}


