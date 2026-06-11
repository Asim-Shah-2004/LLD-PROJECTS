# Spotify Mini-Project (Low-Level Design)

A premium, modular console-based Spotify music player client designed using clean object-oriented principles, design patterns, and robust playback strategies in Java.

---

## 🛠️ Design Patterns Implemented

The architecture leverages several classic structural and behavioral design patterns to ensure decoupling, extensibility, and maintainability:

1. **Facade Pattern (`MusicPlayerFacade`)**
   * Simplifies the complex subsystem interaction (audio playback engine, device manager, and strategy controller) into a single unified interface for the client.
2. **Strategy Pattern (`PlayStrategy`)**
   * Decouples the song selection/iteration logic. Concrete strategies like `SequentialStrategy`, `RandomStrategy`, and `CustomStrategy` (supporting play queue and custom ordering) can be swapped seamlessly.
3. **Adapter Pattern (Device Adapters)**
   * Adapts various external proprietary vendor audio APIs (`BlueToothAPI`, `HeadphoneAPI`, `WiredSpeakerAPI`) to a common application interface (`AudioOutputDevice`).
4. **Factory Pattern (`DeviceFactory`)**
   * Enforces object-creation guidelines by instantiating the correct `AudioOutputDevice` adapter based on the specified `DeviceType` enum.

---

## 🗺️ System Architecture (UML Diagram)

Below is the UML class diagram describing all elements and relations within the system:

```mermaid
classDiagram
    class MusicPlayerFacade {
        -AudioEngine ae
        -AudioOutputDevice aod
        -PlayStrategy playStrategy
        +MusicPlayerFacade()
        +setPlayStrategy(PlayStrategy playStrategy)
        +setPlaylist(Playlist playlist)
        +play(Song song)
        +playNext()
        +playPrevious()
        +playAll()
        +addToNext(Song song)
        +addToQueue(Song song)
        +pause(Song song)
        +connect(DeviceType dt)
    }

    class AudioEngine {
        -Song currentSong
        -boolean songIsPaused
        +AudioEngine()
        +getCurrentSongName() String
        +isPaused() boolean
        +play(AudioOutputDevice aod, Song song)
        +pause()
    }

    class AudioOutputDevice {
        <<interface>>
        +playSound()
    }

    class BlueToothAdapter {
        -BlueToothAPI blueToothAPI
        +BlueToothAdapter(BlueToothAPI API)
        +playSound()
    }
    class HeadphoneAdapter {
        -HeadphoneAPI headphoneAPI
        +HeadphoneAdapter(HeadphoneAPI API)
        +playSound()
    }
    class WiredSpeakerAdapter {
        -WiredSpeakerAPI wiredSpeakerAPI
        +WiredSpeakerAdapter(WiredSpeakerAPI API)
        +playSound()
    }

    class BlueToothAPI {
        +playViaBluetooth()
    }
    class HeadphoneAPI {
        +playViaHeadphone()
    }
    class WiredSpeakerAPI {
        +playViaSpeaker()
    }

    class DeviceFactory {
        +creatDevice(DeviceType dt) AudioOutputDevice
    }

    class DeviceManager {
        +connect(DeviceType dt) AudioOutputDevice
    }

    class DeviceType {
        <<enumeration>>
        BLUETOOTH
        WIRED_SPEAKER
        HEADPHONE
    }

    class Song {
        -String name
        -String artist
        -String path
        +Song(String name, String artist, String path)
        +getName() String
        +getArtist() String
        +getPath() String
    }

    class Playlist {
        -String name
        -List~Song~ songs
        +Playlist(String name)
        +getName() String
        +getSongs() List~Song~
        +addSong(Song song)
        +removeSong(Song song)
    }

    class PlayStrategy {
        <<interface>>
        +setPlaylist(Playlist playlist)
        +next() Song
        +hasNext() boolean
        +previous() Song
        +hasPrevious() boolean
        +addToNext(Song song)
        +addToQueue(Song song)
    }

    class SequentialStrategy {
        -Playlist playlist
        -int currentIndex
        +setPlaylist(Playlist playlist)
        +next() Song
        +hasNext() boolean
        +previous() Song
        +hasPrevious() boolean
    }

    class RandomStrategy {
        -Playlist playlist
        -int currentIndex
        -Random random
        +setPlaylist(Playlist playlist)
        +next() Song
        +hasNext() boolean
        +previous() Song
        +hasPrevious() boolean
    }

    class CustomStrategy {
        -Playlist playlist
        -int currentIndex
        -LinkedList~Song~ userQueue
        -List~Song~ playedSongs
        -int historyIndex
        +setPlaylist(Playlist playlist)
        +next() Song
        +hasNext() boolean
        +previous() Song
        +hasPrevious() boolean
        +addToNext(Song song)
        +addToQueue(Song song)
    }

    MusicPlayerFacade --> AudioEngine
    MusicPlayerFacade --> AudioOutputDevice
    MusicPlayerFacade --> PlayStrategy
    DeviceManager --> DeviceFactory
    DeviceFactory ..> AudioOutputDevice : creates
    BlueToothAdapter ..|> AudioOutputDevice
    HeadphoneAdapter ..|> AudioOutputDevice
    WiredSpeakerAdapter ..|> AudioOutputDevice
    BlueToothAdapter --> BlueToothAPI
    HeadphoneAdapter --> HeadphoneAPI
    WiredSpeakerAdapter --> WiredSpeakerAPI
    Playlist "1" *--> "*" Song
    CustomStrategy ..|> PlayStrategy
    SequentialStrategy ..|> PlayStrategy
    RandomStrategy ..|> PlayStrategy
    CustomStrategy --> Playlist
    SequentialStrategy --> Playlist
    RandomStrategy --> Playlist
```

---

## 🚀 Getting Started & Execution

A automated script has been provided to build, execute the test runner, and clean up temporary compilation artifacts.

### Prerequisites

* Java Development Kit (JDK) 8 or higher installed and added to your `PATH`.
* PowerShell (standard on Windows).

### Running the Application

Open a PowerShell terminal in the project directory and run:

```powershell
powershell -ExecutionPolicy Bypass -File .\run.ps1
```

This script will:
1. Compile all Java code into the `bin/` directory.
2. Execute the `Main` class runner.
3. Automatically delete all compilation artifacts (cleaning up the `bin/` directory).
