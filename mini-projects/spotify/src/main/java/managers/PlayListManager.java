package managers;

import models.Playlist;
import java.util.HashMap;
import java.util.Map;
import models.Song;

public class PlayListManager {
    Map<String, Playlist> playlistmap = new HashMap<>();

    public void createPlaylist(String name){
        if(playlistmap.containsKey(name)){
            System.out.println("playlist already exists");
            return;
        }
        Playlist p = new Playlist(name);
        playlistmap.put(name, p);
    }

    public void deletePlaylist(String name){
        if(!playlistmap.containsKey(name)){
            System.out.println("playlist does not exist");
            return;
        }
        playlistmap.remove(name);
    }

    public Playlist gePlaylist(String name){
        return playlistmap.get(name);
    }

    public void addSongToPlaylist(String playlistName, Song song){
        if(!playlistmap.containsKey(playlistName)){
            System.out.println("playlist does not exist");
            return;
        }
        Playlist playlist = playlistmap.get(playlistName);
        playlist.addSong(song);
        System.out.println("song added to playlist");   
    }

}
