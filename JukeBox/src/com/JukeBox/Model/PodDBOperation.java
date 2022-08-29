package com.JukeBox.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodDBOperation {
    String url = "jdbc:mysql://localhost:3306/jukebox";
    String username = "root";
    String password = "Manik@ndan123";
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    public boolean addPodCast (Podcast podCast) throws SQLException
    {
        boolean result=false;
        int celebrity_Id=checkAndInsertPodcastCelebrity(podCast.getPodcastCelebrity());

        PreparedStatement ps=this.getConnection().prepareStatement("insert into Podcast(podcast_Name,podcast_Release_Date,podcast_Duration,celebrity_Id)values(?,?,?,?)");
        ps.setString(1, podCast.getPodcastName());
        ps.setString(2, podCast.getPodcastReleaseDate());
        ps.setString(3,podCast.getDuration());
        ps.setInt(4,celebrity_Id);

        int rowCount=ps.executeUpdate();
        if(rowCount>0)
            result=true;
        else
            result=false;
        return result;
    }


    public int checkAndInsertPodcastCelebrity( String celebrity_Name)throws SQLException
    {
        System.out.println("celebrity_Name = " + celebrity_Name);
        int celebrity_Id=0;
        PreparedStatement insert1=this.getConnection().prepareStatement("select * from Celebrity where celebrity_Name=?");
        insert1.setString(1,celebrity_Name);
        ResultSet rs=insert1.executeQuery();
        if(rs.next())
            celebrity_Id=rs.getInt(1);
        else
            celebrity_Id=insertPodcastCelebrity(celebrity_Name);
        return celebrity_Id;
    }
    private int insertPodcastCelebrity(String celebrity_Name)throws SQLException
    {
        System.out.println("celebrity_Name = " + celebrity_Name);
        int celebrity_id=0;
        PreparedStatement statement= this.getConnection().prepareStatement("insert into Celebrity(celebrity_name)values(?)",Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,celebrity_Name);
        int rowAffected1=statement.executeUpdate();
        if(rowAffected1>0)
        {
            ResultSet rs2=statement.getGeneratedKeys();
            rs2.next();
            celebrity_id=rs2.getInt(1);

        }
        return celebrity_id;
    }
    public List<Podcast>fetchpodcast()throws SQLException
    {
        List<Podcast> podCastList = new ArrayList<>();
        Statement podcastView= this.getConnection().createStatement();
        ResultSet resultSet=podcastView.executeQuery("select * from podCast_details");
        while (resultSet.next()) {
            podCastList.add((new Podcast(resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(6))));
        }
        return podCastList;
    }
}