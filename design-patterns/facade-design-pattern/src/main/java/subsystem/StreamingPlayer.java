package subsystem;

public class StreamingPlayer {

    public enum Codec { H264, H265_HEVC, AV1, VP9 }

    private boolean running;
    private String currentMedia;
    private Codec activeCodec;
    private boolean subtitlesEnabled;
    private String subtitleLanguage;
    private int bufferPercent;

    public StreamingPlayer() {
        this.running = false;
        this.currentMedia = null;
        this.activeCodec = Codec.H264;
        this.subtitlesEnabled = false;
        this.subtitleLanguage = "en";
        this.bufferPercent = 0;
    }

    public void boot() {
        this.running = true;
        System.out.println("[StreamingPlayer] Booting up... OS loaded. Network adapter ready.");
    }

    public void shutdown() {
        stopMedia();
        this.running = false;
        System.out.println("[StreamingPlayer] Graceful shutdown complete.");
    }

    public void loadMedia(String mediaTitle) {
        if (!running) throw new IllegalStateException("Player is not running.");
        this.currentMedia = mediaTitle;
        System.out.println("[StreamingPlayer] Loading: \"" + mediaTitle + "\"...");
        negotiateCodec();
        bufferMedia();
    }

    private void negotiateCodec() {
        this.activeCodec = Codec.H265_HEVC;
        System.out.println("[StreamingPlayer] Codec negotiated: " + activeCodec + ".");
    }

    private void bufferMedia() {
        this.bufferPercent = 100;
        System.out.println("[StreamingPlayer] Buffering... 100% ready.");
    }

    public void play() {
        if (currentMedia == null) throw new IllegalStateException("No media loaded.");
        System.out.println("[StreamingPlayer] ▶ Playing: \"" + currentMedia + "\" [" + activeCodec + "].");
    }

    public void stopMedia() {
        if (currentMedia != null) {
            System.out.println("[StreamingPlayer] ⏹ Stopping: \"" + currentMedia + "\".");
            this.currentMedia = null;
            this.bufferPercent = 0;
        }
    }

    public void enableSubtitles(String language) {
        this.subtitlesEnabled = true;
        this.subtitleLanguage = language;
        System.out.println("[StreamingPlayer] Subtitles ON [" + language.toUpperCase() + "].");
    }

    public void disableSubtitles() {
        this.subtitlesEnabled = false;
        System.out.println("[StreamingPlayer] Subtitles OFF.");
    }

    public boolean isRunning()      { return running; }
    public String getCurrentMedia() { return currentMedia; }
}
