package models;

public class Song{
    String name;
    String artist;
    String path;

    public Song(String name, String artist, String path){
        this.name = name;
        this.artist = artist;
        this.path = path;
    }

    public String getName(){
        return name;
    }
    public String getArtist(){
        return artist;
    }
    public String getPath(){
        return path;
    }
}