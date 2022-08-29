package com.JukeBox.Model;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("WELCOME To JukeBox");
        SongDBOperation sdb = new SongDBOperation();
        PodDBOperation pdb = new PodDBOperation();
        SongCollection songCollection=new SongCollection();
        PodcastCollection podcastCollection=new PodcastCollection();
        List<Song> List = sdb.fetchSong();
        List<Podcast> List1 = pdb.fetchpodcast();
        PlayListDBOperation playlist = new PlayListDBOperation();

        System.out.println("******************Welcome to jukebox*********************");

        Scanner scanner=new Scanner(System.in);
        System.out.println("Press 1 to Insert a Song");
        System.out.println("Press 2 to Insert Podcast");
        System.out.println("Press 3 to Song View");
        System.out.println("Press 4 to Filter Song by Song Name");
        System.out.println("Press 5 to Filter Song by Song Album");
        System.out.println("Press 6 to Filter Song by Song Genre");
        System.out.println("Press 7 to Filter Song by Song Artist");
        System.out.println("Press 8 to Podcast View");
        System.out.println("Press 9 to Filter Podcast by Podcast Name");
        System.out.println("Press 10 to Filter Podcast by Celebrity Name");
        System.out.println("Press 11 to Filter Podcast by Duration");
        System.out.println("Press 12 to Filter Podcast by Release Date");
        System.out.println("Press 13 to Insert into Playlist");
        System.out.println("Press 14 to Display Playlist");
        System.out.println("Press 15 to Add Song and Podcast To Playlist");
        System.out.println("Press 16 to Display Playlist Content");
        System.out.println("**************************************************************************************");
        int choice=scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Song Name:");
                    String SongName = scanner.next();
                    System.out.println("Enter the SongAlbum:");
                    String SongAlbum = scanner.next();
                    System.out.println("Enter Song Artist Name:");
                    String SongArtist = scanner.next();
                    System.out.println("Enter Song Genre:");
                    String SongGenre = scanner.next();
                    System.out.println("Enter Song Duration:");
                    String Duration = scanner.next();

                    Song song = new Song(SongName, SongAlbum, SongArtist, SongGenre, Duration);
                    sdb.addSong(song);
                    System.out.println("Song Added");
                    break;
                case 2:
                    System.out.println("*******************************WELCOME TO PODCAST***********************************************");
                    System.out.println("Enter the Podcast Name");
                    String podcastName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter Podcast Release Date");
                    String celebrityName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter the Podcast Duration");
                    String podcastDuration = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter the Celebrity Name");
                    String podcastReleaseDate = scanner.next();
                    Podcast podcast = new Podcast(podcastName, celebrityName, podcastDuration, podcastReleaseDate);
                    pdb.addPodCast(podcast);
                    System.out.println("Podcast Added");
                    break;
                case 3:
                    songCollection.displayAllSong(List);
                    break;
                case 4:
                    System.out.println("Enter Song Name");
                    String searchSong = scanner.next();
                    songCollection.filterByName(List, searchSong);
                    break;
                case 5:
                    System.out.println("Enter Album Name");
                    String searchAlbum = scanner.next();
                    songCollection.filterByAlbum(List, searchAlbum);
                    break;
                case 6:
                    System.out.println("Enter Genre Name");
                    String searchGenre = scanner.next();
                    songCollection.filterByGenre(List, searchGenre);
                    break;
                case 7:
                    System.out.println("Enter Artist Name");
                    String searchArtist = scanner.next();
                    songCollection.filterByArtist(List, searchArtist);
                    break;

                case 8:
                    podcastCollection.displayAllPodcast(List1);
                    break;
                case 9:
                    System.out.println("Enter Podcast Name");
                    String searchPodcast = scanner.next();
                    podcastCollection.filterByNamePodcast(List1, searchPodcast);
                    break;
                case 10:
                    System.out.println("Enter Celebrity Name");
                    String searchCelebrity = scanner.next();
                    podcastCollection.filterByCelebrity(List1, searchCelebrity);
                    break;
                case 11:
                    System.out.println("Enter Duration");
                    String searchDura = scanner.next();
                    podcastCollection.filterByPodcastDuration(List1, searchDura);
                    break;
                case 12:
                    System.out.println("Enter Release Date");
                    String searchDate = scanner.next();
                    podcastCollection.filterByPodcastReleaseDate(List1, searchDate);
                    break;
                case 13:
                    System.out.println("Enter the playListName");
                    String playlistName = scanner.next();
                    playlist.createplaylist(playlistName);
                    break;
                case 14:
                    playlist.displayPlaylist();
                    break;
                case 15:
                    System.out.println("Enter the playlistName to add song or podcast");
                    String playListName = scanner.next();
                    System.out.println("press 1 for Add song \npress 2 for Add podcast");
                    int choize = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter trackName");
                    String trackName = scanner.nextLine();
                    playlist.insertIntoPlaylistContent(playListName, trackName, choize);
                    break;
                case 16:
                    System.out.println("Enter the Name of the playlist to display content");
                    String playlistName1 = scanner.next();
                    playlist.displayPlaycontent(playlistName1);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
    }
}
