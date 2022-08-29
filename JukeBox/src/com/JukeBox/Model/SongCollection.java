package com.JukeBox.Model;


import java.util.List;
import java.util.stream.Collectors;

public class SongCollection{

    List<Song>filterByName(List<Song>list,String songName)
    {
        List<Song> song1=list.stream().filter(a->a.getSongName().equalsIgnoreCase(songName)).collect(Collectors.toList());
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.printf("%20s %s %20s %s %20s %s %20s %s %20s %s","SONGNAME","|","ALBUM" ,"|","GENERE","|","ARTIST","|","DURATION ","|\n");
        for(Song song:song1)
        {
            System.out.format("%20s %s %20s %s %20s %s %20s %s %20s %s",song.getSongName(),"|",song.getSongAlbum(),"|",song.getSongGenre(),"|",song.getSongArtist(),"|",song.getDuration(),"|");
            System.out.println();
        }
        System.out.println("__________________________________________________________________________________________________________________");
        return song1;
    }

    List<Song> filterByAlbum(List<Song>list, String songAlbum)
    {
        List<Song>song2=list.stream().filter(b->b.getSongAlbum().equalsIgnoreCase(songAlbum)).collect(Collectors.toList());
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.printf("%20s %s %20s %s %20s %s %20s %s %20s %s","SONGNAME","|","ALBUM" ,"|","GENERE","|","ARTIST","|","DURATION ","|\n");
        for(Song song:song2)
        {
            System.out.format("%20s %s %20s %s %20s %s %20s %s %20s %s",song.getSongName(),"|",song.getSongAlbum(),"|",song.getSongGenre(),"|",song.getSongArtist(),"|",song.getDuration(),"|");
            System.out.println();
        }
        System.out.println("__________________________________________________________________________________________________________________");
        return song2;
    }
    List<Song> filterByGenre(List<Song>list,String songGenre)
    {
        List<Song>song3=list.stream().filter(c->c.getSongGenre().equalsIgnoreCase(songGenre)).collect(Collectors.toList());
        System.out.printf("%20s %s %20s %s %20s %s %20s %s %20s %s","SONGNAME","|","ALBUM" ,"|","GENERE","|","ARTIST","|","DURATION ","|\n");
        System.out.println("__________________________________________________________________________________________________________________");
        for (Song song:song3)
        {
            System.out.format("%20s %s %20s %s %20s %s %20s %s %20s %s",song.getSongName(),"|",song.getSongAlbum(),"|",song.getSongGenre(),"|",song.getSongArtist(),"|",song.getDuration(),"|");
            System.out.println();
        }
        System.out.println("__________________________________________________________________________________________________________________");
        return song3;
    }
    List<Song> filterByArtist(List<Song>list,String songArtist)
    {
        List<Song>song4=list.stream().filter(d->d.getSongArtist().equalsIgnoreCase(songArtist)).collect(Collectors.toList());
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.printf("%20s %s %20s %s %20s %s %20s %s %20s %s","SONGNAME","|","ALBUM" ,"|","GENERE","|","ARTIST","|","DURATION ","|\n");
        for (Song song:song4)
        {
            System.out.format("%20s %s %20s %s %20s %s %20s %s %20s %s",song.getSongName(),"|",song.getSongAlbum(),"|",song.getSongGenre(),"|",song.getSongArtist(),"|",song.getDuration(),"|");
            System.out.println();
        }
        System.out.println("__________________________________________________________________________________________________________________");
        return song4;
    }
    public void  displayAllSong(List<Song>songList){
        if (songList.isEmpty()){
            System.out.println("LIST IS EMPTY");
        }else {
            System.out.println("__________________________________________________________________________________________________________________");
            System.out.printf("%20s %s %20s %s %20s %s %20s %s %20s %s","SONGNAME","|","ALBUM" ,"|","GENERE","|","ARTIST","|","DURATION ","|\n");

            System.out.println("==================================================================================================================");
            for (Song song:songList){
                System.out.format("%20s %s %20s %s %20s %s %20s %s %20s %s",song.getSongName(),"|",song.getSongAlbum(),"|",song.getSongGenre(),"|",song.getSongArtist(),"|",song.getDuration(),"|");
                System.out.println();
            }
            System.out.println("__________________________________________________________________________________________________________________");
        }
    }
}
