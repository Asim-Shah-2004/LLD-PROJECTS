import facade.MusicPlayerFacade;
import models.Playlist;
import models.Song;
import enums.DeviceType;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("              SPOTIFY CLIENT SYSTEM               ");
        System.out.println("==================================================");

        // Initialize Facade
        MusicPlayerFacade player = new MusicPlayerFacade();

        // 1. Test Device Connection
        System.out.println("\n[Test 1] Connecting to Bluetooth device...");
        player.connect(DeviceType.BLUETOOTH);

        // 2. Create Playlist & Songs
        System.out.println("\n[Test 2] Setting up Playlist and Songs...");
        Playlist playlist = new Playlist("My Chill Vibes");
        Song songA = new Song("Ocean Breeze", "Artist A", "/path/a");
        Song songB = new Song("Sunset Glow", "Artist B", "/path/b");
        Song songC = new Song("Night Drive", "Artist C", "/path/c");
        playlist.addSong(songA);
        playlist.addSong(songB);
        playlist.addSong(songC);
        player.setPlaylist(playlist);
        System.out.println("Playlist '" + playlist.getName() + "' set with " + playlist.getSongs().size() + " songs.");

        // 3. Test Individual playNext / Queue Manipulation
        System.out.println("\n[Test 3] Testing playNext() and custom queue management...");
        player.playNext(); // Plays Ocean Breeze

        Song songD = new Song("Morning Dew (Play Next)", "Artist D", "/path/d");
        System.out.println("Queueing '" + songD.getName() + "' to play next...");
        player.addToNext(songD);

        Song songE = new Song("Late Night Coffee (Play Later)", "Artist E", "/path/e");
        System.out.println("Queueing '" + songE.getName() + "' to play later (end of queue)...");
        player.addToQueue(songE);

        // Plays Morning Dew
        player.playNext();

        // Plays Late Night Coffee
        player.playNext();

        // 4. Test playPrevious (traverse history)
        System.out.println("\n[Test 4] Navigating backwards through playback history...");
        player.playPrevious(); // Back to Late Night Coffee
        player.playPrevious(); // Back to Morning Dew
        player.playPrevious(); // Back to Ocean Breeze
        player.playPrevious(); // No previous song

        // 5. Test playAll feature
        System.out.println("\n[Test 5] Testing playAll() with remaining songs...");
        // Since we navigated back to Ocean Breeze (historyIndex = 0), playAll() should play the remaining songs:
        // Morning Dew, Late Night Coffee, Sunset Glow, Night Drive.
        player.playAll();

        System.out.println("\n==================================================");
        System.out.println("          ALL TEST SCENARIOS COMPLETED            ");
        System.out.println("==================================================");
    }
}
