package models;

public class Song {
    int name;
    int duration;
    
    public Song(int name, int duration){
        this.name = name;
        this.duration = duration;
    }

    public int getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
