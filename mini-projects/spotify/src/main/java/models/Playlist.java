package models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    String name;
    List<Song> songs = new ArrayList<>();

    public Playlist(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public List<Song> getSongs(){
        return songs;
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void removeSong(Song song){
        songs.remove(song);
    }

}
