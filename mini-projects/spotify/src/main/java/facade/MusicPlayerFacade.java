package facade;

import managers.DeviceManager;
import core.AudioEngine;
import devices.AudioOutputDevice;
import enums.DeviceType;
import models.Song;
import models.Playlist;
import strategies.PlayStrategy;
import strategies.CustomStrategy;

public class MusicPlayerFacade {
    
    AudioEngine ae;
    AudioOutputDevice aod;
    PlayStrategy playStrategy;

    public MusicPlayerFacade() {
        this.ae = new AudioEngine();
        this.aod = null;
        this.playStrategy = new CustomStrategy();
    }

    public void setPlayStrategy(PlayStrategy playStrategy) {
        this.playStrategy = playStrategy;
    }

    public void setPlaylist(Playlist playlist) {
        this.playStrategy.setPlaylist(playlist);
    }

    public void play(Song song){
        ae.play(aod, song);
    }

    public void playNext() {
        if (playStrategy.hasNext()) {
            Song song = playStrategy.next();
            if (song != null) {
                ae.play(aod, song);
            }
        } else {
            System.out.println("No next song to play");
        }
    }

    public void playAll() {
        if (!playStrategy.hasNext()) {
            System.out.println("No songs to play");
            return;
        }
        while (playStrategy.hasNext()) {
            Song song = playStrategy.next();
            if (song != null) {
                ae.play(aod, song);
            }
        }
    }

    public void playPrevious() {
        if (playStrategy.hasPrevious()) {
            Song song = playStrategy.previous();
            if (song != null) {
                ae.play(aod, song);
            }
        } else {
            System.out.println("No previous song to play");
        }
    }

    public void addToNext(Song song) {
        playStrategy.addToNext(song);
    }

    public void addToQueue(Song song) {
        playStrategy.addToQueue(song);
    }

    public void pause(Song song){
        String name = ae.getCurrentSongName();
        if(name == null || !name.equals(song.getName())){
            System.out.println("not matching song");
            return;
        }
        ae.pause();
    }

    public void connect(DeviceType dt){
        DeviceManager dm = new DeviceManager();
        this.aod = dm.connect(dt);
    }

}
