# Observer Pattern (YouTube Channel Example)

This project demonstrates the Observer design pattern using a YouTube channel that notifies subscribers when a new video is uploaded.

## UML (Class Diagram)

```mermaid
classDiagram
    class Observer {
        +add(Observable)
        +delete(Observable)
        +notifyObservable()
    }

    class Observable {
        +update()
    }

    class YtChannel {
        -subscribers: List~Observable~
        -name: String
        -latestVideo: String
        +YtChannel(name)
        +add(Observable)
        +delete(Observable)
        +notifyObservable()
        +uploadVideo(video)
        +getLatestVideo()
    }

    class MobileSubscriber {
        -name: String
        -channel: YtChannel
        +MobileSubscriber(name, channel)
        +update()
    }

    class Main {
        +main(args)
    }

    Observer <|.. YtChannel
    Observable <|.. MobileSubscriber
    YtChannel o-- Observable : subscribers
    Main --> YtChannel
    Main --> MobileSubscriber
```

## How It Works

- `YtChannel` acts as the subject and keeps a list of `Observable` subscribers.
- `MobileSubscriber` implements `Observable` and reacts to updates.
- When `uploadVideo()` is called, the channel notifies all subscribers.

## Why Use Observer?

- Decouples the subject from its dependents.
- Allows dynamic subscription at runtime.
- Makes event-driven flows easier to extend.

## Run

```powershell
./run.ps1
```

You can pass a custom main class name if needed:

```powershell
./run.ps1 -MainClass Main
```
