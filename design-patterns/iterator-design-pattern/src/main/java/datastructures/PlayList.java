package datastructures;

import java.util.ArrayList;
import java.util.List;

import models.Song;
import iterators.Iterable;
import iterators.Iterator;
import iterators.PlayListIterator;

public class PlayList implements Iterable<Song> {
    List<Song> songs;

    public PlayList(){
        songs = new ArrayList<>();
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void removeSong(Song song){
        songs.remove(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public Iterator<Song> getIterator() {
        return new PlayListIterator(this.songs);
    }
}
