package iterators;

import java.util.List;
import models.Song;

public class PlayListIterator implements Iterator<Song>{
    private List<Song> songs;
    private int index;
    
    public PlayListIterator(List<Song> songs){
        this.songs = songs;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.songs.size();
    }
    @Override
    public Song next() {
        if(!hasNext()){
            return null;
        }
        Song song = this.songs.get(this.index);
        this.index++;
        return song;
    }
}
