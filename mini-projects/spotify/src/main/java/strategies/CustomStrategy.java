package strategies;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import models.Playlist;
import models.Song;

public class CustomStrategy implements PlayStrategy {
    private Playlist playlist;
    private int currentIndex = 0;
    
    private LinkedList<Song> userQueue = new LinkedList<>();
    
    private List<Song> playedSongs = new ArrayList<>();
    private int historyIndex = -1;

    @Override
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        this.currentIndex = 0;
        this.userQueue.clear();
        this.playedSongs.clear();
        this.historyIndex = -1;
    }

    @Override
    public Song next() {
        
        if (historyIndex < playedSongs.size() - 1) {
            historyIndex++;
            return playedSongs.get(historyIndex);
        }

        
        Song songToPlay = null;
        if (!userQueue.isEmpty()) {
            songToPlay = userQueue.poll();
        } else if (playlist != null && currentIndex < playlist.getSongs().size()) {
            songToPlay = playlist.getSongs().get(currentIndex);
            currentIndex++;
        }

        if (songToPlay != null) {
            playedSongs.add(songToPlay);
            historyIndex++;
        }
        return songToPlay;
    }

    @Override
    public boolean hasNext() {
        if (historyIndex < playedSongs.size() - 1) {
            return true;
        }
        return !userQueue.isEmpty() || (playlist != null && currentIndex < playlist.getSongs().size());
    }

    @Override
    public Song previous() {
        if (historyIndex > 0) {
            historyIndex--;
            return playedSongs.get(historyIndex);
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return historyIndex > 0;
    }

    @Override
    public void addToNext(Song song) {
        if (song != null) {
            userQueue.addFirst(song);
        }
    }

    @Override
    public void addToQueue(Song song) {
        if (song != null) {
            userQueue.addLast(song);
        }
    }
}
