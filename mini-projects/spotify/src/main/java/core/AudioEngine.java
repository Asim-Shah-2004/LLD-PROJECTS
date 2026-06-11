package core;

import models.Song;
import devices.AudioOutputDevice;

public class AudioEngine {
    private Song currentSong;
    private boolean songIsPaused;

    public AudioEngine() {
        currentSong = null;
        songIsPaused = false;
    }

    public String getCurrentSongName() {
        if (currentSong != null) {
            return currentSong.getName();
        }
        return "";
    }

    public boolean isPaused() {
        return songIsPaused;
    }

    public void play(AudioOutputDevice aod, Song song) {
        if (song == null) {
            throw new RuntimeException("Cannot play a null song.");
        }
    
        if (songIsPaused && song == currentSong) {
            songIsPaused = false;
            System.out.println("Resuming song: " + song.getName());
            aod.playSound();
            return;
        }

        currentSong = song;
        songIsPaused = false;
        System.out.println("Playing song: " + song.getName());
        aod.playSound();
    }

    public void pause() {
        if (currentSong == null) {
            throw new RuntimeException("No song is currently playing to pause.");
        }
        if (songIsPaused) {
            throw new RuntimeException("Song is already paused.");
        }
        songIsPaused = true;
        System.out.println("Pausing song: " + currentSong.getName());
    }
}