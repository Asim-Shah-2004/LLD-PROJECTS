package strategies;

import java.util.Random;

import models.Playlist;
import models.Song;

public class RandomStrategy implements PlayStrategy {

    private Playlist playlist;
    private int currentIndex = 0;
    private Random random;

    public void setPlaylist(Playlist playlist){
        this.playlist = playlist;
        this.currentIndex = 0;
        this.random = new Random();
    }
    public Song next(){
        if(currentIndex == playlist.getSongs().size()){
            return null;
        }
        
        Song song = playlist.getSongs().get(currentIndex);
        currentIndex++;
        return song;   
    }
    public boolean hasNext(){
        if(currentIndex == playlist.getSongs().size()){
            return false;
        }
        return true;
    }
    public Song previous(){
        if(currentIndex == 0){
            return null;
        }
        currentIndex--;
        Song song = playlist.getSongs().get(currentIndex);
        return song;
        
    }
    public boolean hasPrevious(){
        if(currentIndex == 0){
            return false;
        }
        return true;
    }
}
