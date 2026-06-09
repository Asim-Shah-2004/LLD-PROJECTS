# Notification System — Low Level Design

A Java-based notification system built using four classic design patterns: **Observer**, **Strategy**, **Decorator**, and **Singleton**. The system dispatches notifications across multiple channels (Email, SMS, Push) and supports composable message transformations like timestamps and signatures.

---

## Problem Statement

Design a notification system that can:

- Send a notification through **multiple delivery channels** (Email, SMS, Push) simultaneously
- **Decorate** messages with metadata (timestamps, signatures) without modifying the core notification object
- **Log** every notification automatically as it is dispatched
- Expose a **single shared entry point** (`NotificationService`) so no part of the application accidentally creates a second instance with its own state
- Stay **open for extension** — adding a new channel (e.g. Slack) or a new decorator (e.g. priority tag) should require no changes to existing classes

---

## Package Structure

```
src/main/java/
├── Main.java
├── run.ps1
│
├── notification/
│   ├── Notification.java          # Core interface
│   └── SimpleNotification.java    # Plain text implementation
│
├── decorator/
│   ├── NotificationDecorator.java # Abstract base decorator
│   ├── TimestampDecorator.java    # Prepends a timestamp
│   └── SignatureDecorator.java    # Appends a signature
│
├── observable/
│   ├── Observable.java            # Observable interface
│   └── NotificationObservable.java
│
├── observer/
│   ├── Observer.java              # Observer interface
│   ├── Logger.java                # Logs every notification
│   └── NotificationEngine.java    # Drives delivery strategies
│
├── strategy/
│   ├── NotificationStrategy.java  # Strategy interface
│   ├── EmailNotification.java
│   ├── SmsNotification.java
│   └── PushNotification.java
│
└── services/
    └── NotificationService.java   # Singleton entry point
```

---

## UML Diagram

```
┌─────────────────────────────────────────────────────────────────────┐
│                          «interface»                                │
│                          Notification                               │
│─────────────────────────────────────────────────────────────────────│
│  + getContent() : String                                            │
└───────────────┬─────────────────────────┬───────────────────────────┘
                │ implements               │ implements
                │                         │
    ┌───────────▼────────────┐   ┌────────▼──────────────────────────┐
    │  SimpleNotification    │   │   «abstract»                      │
    │────────────────────────│   │   NotificationDecorator           │
    │  - text : String       │   │───────────────────────────────────│
    │────────────────────────│   │  # notification : Notification    │
    │  + getContent()        │   │───────────────────────────────────│
    └────────────────────────┘   │  + getContent() : String          │
                                 └──────────┬────────────────────────┘
                                            │ extends
                          ┌─────────────────┼──────────────────┐
                          │                                     │
              ┌───────────▼──────────┐           ┌─────────────▼────────────┐
              │  TimestampDecorator  │           │   SignatureDecorator      │
              │──────────────────────│           │──────────────────────────│
              │                      │           │  - signature : String     │
              │──────────────────────│           │──────────────────────────│
              │  + getContent()      │           │  + getContent()           │
              └──────────────────────┘           └──────────────────────────┘


┌─────────────────────────────────────────┐
│            «interface»                  │
│            Observable                  │
│─────────────────────────────────────────│
│  + add(Observer)                        │
│  + remove(Observer)                     │
│  + notifyObservers()                    │
└──────────────┬──────────────────────────┘
               │ implements
   ┌───────────▼──────────────────────────────────┐
   │         NotificationObservable               │
   │──────────────────────────────────────────────│
   │  - observers : List<Observer>                │
   │  - notification : Notification               │
   │──────────────────────────────────────────────│
   │  + add(Observer)                             │
   │  + remove(Observer)                          │
   │  + notifyObservers()                         │
   │  + getNotification() : String                │
   │  + setNotification(Notification)  ◄── triggers notifyObservers()
   └──────────────────────────────────────────────┘
               ▲ holds ref                ▲ holds ref
               │                          │
   ┌───────────┴──────────┐   ┌───────────┴──────────────────────────┐
   │       Logger         │   │         NotificationEngine            │
   │──────────────────────│   │───────────────────────────────────────│
   │                      │   │  - strategies: List<NotificationStrategy>
   │──────────────────────│   │───────────────────────────────────────│
   │  + update()          │   │  + addNotificationStrategy(...)       │
   │  prints to console   │   │  + update()  ◄── calls each strategy  │
   └──────────────────────┘   └───────────────────────────────────────┘
                                          │ uses
                          ┌───────────────▼─────────────────────────────┐
                          │          «interface»                        │
                          │          NotificationStrategy               │
                          │─────────────────────────────────────────────│
                          │  + sendNotification(String content)         │
                          └──────┬──────────────┬───────────────┬───────┘
                                 │ implements   │               │
                    ┌────────────▼──┐  ┌────────▼──┐  ┌────────▼──┐
                    │    Email      │  │    SMS    │  │   Push    │
                    │Notification   │  │Notif.     │  │Notif.     │
                    └───────────────┘  └───────────┘  └───────────┘


┌──────────────────────────────────────────────┐
│           NotificationService                │
│       «Singleton»                            │
│──────────────────────────────────────────────│
│  - instance : NotificationService  (static)  │
│  - observable : NotificationObservable       │
│  - notifications : List<Notification>        │
│──────────────────────────────────────────────│
│  - NotificationService()  (private)          │
│  + getInstance() : NotificationService       │
│  + getObservable() : NotificationObservable  │
│  + sendNotification(Notification)            │
└──────────────────────────────────────────────┘
```

---

## Design Patterns Used

### 1. Observer Pattern
**Classes:** `Observable`, `NotificationObservable`, `Observer`, `Logger`, `NotificationEngine`

`NotificationObservable` maintains a list of observers. When `setNotification()` is called, it immediately calls `notifyObservers()`, which triggers `update()` on every registered observer. This decouples the sender from the receivers — `NotificationObservable` has no knowledge of what `Logger` or `NotificationEngine` do.

### 2. Strategy Pattern
**Classes:** `NotificationStrategy`, `EmailNotification`, `SmsNotification`, `PushNotification`

`NotificationEngine` holds a list of `NotificationStrategy` implementations. On each `update()` call, it iterates through all strategies and invokes `sendNotification()` on each. Adding a new channel means creating one new class that implements `NotificationStrategy` — nothing else changes.

### 3. Decorator Pattern
**Classes:** `Notification`, `NotificationDecorator`, `TimestampDecorator`, `SignatureDecorator`

Decorators wrap a `Notification` object and override `getContent()` to augment the message. Because every decorator also implements `Notification`, they can be stacked arbitrarily:

```java
// Timestamp wraps the message, then Signature wraps that
Notification n = new SignatureDecorator(
    new TimestampDecorator(
        new SimpleNotification("Server alert")),
    " — Ops Team");
// Result: "[2026-01-01:00:00:00]Server alert — Ops Team"
```

### 4. Singleton Pattern
**Class:** `NotificationService`

The constructor is `private`. `getInstance()` is `static` and returns the same object on every call, ensuring one shared observable and one notification history list throughout the application.

```java
public static NotificationService getInstance() {
    if (instance == null) {
        instance = new NotificationService();
    }
    return instance;
}
```

---

## How It Works — Request Flow

```
Caller
  │
  ▼
NotificationService.getInstance()
  │  sendNotification(notification)
  │
  ▼
NotificationObservable.setNotification(notification)
  │  notifyObservers()
  │
  ├──► Logger.update()
  │      └─ prints: "Logged : <content>"
  │
  └──► NotificationEngine.update()
         └─ for each NotificationStrategy:
              ├─ EmailNotification.sendNotification(content)
              ├─ SmsNotification.sendNotification(content)
              └─ PushNotification.sendNotification(content)
```

The decorated `getContent()` call happens lazily — only when an observer actually reads the content via `getNotification()`. The observable stores the `Notification` object, not the resolved string.

---

## Running the Project

Place `Main.java` and `run.ps1` inside `src/main/java/` alongside the package folders, then run:

```powershell
cd path\to\notification-system\src\main\java
.\run.ps1
```

The script compiles all `.java` files into a temporary `out\` directory, runs `Main`, and deletes `out\` when finished.

---

## Test Cases Covered in Main.java

| # | Case | What it tests |
|---|------|---------------|
| 1 | Plain notification | Baseline observer + strategy flow |
| 2 | `TimestampDecorator` | Single decorator wrapping |
| 3 | `SignatureDecorator` | Single decorator wrapping |
| 4 | `Signature(Timestamp(msg))` | Stacked decorators, outer = signature |
| 5 | `Timestamp(Signature(msg))` | Stacked decorators, outer = timestamp |
| 6 | Singleton check | Both `getInstance()` calls return the same object |
| 7 | Three sequential notifications | History list and repeated dispatch |
| 8 | Empty string content | Edge case — empty message |
| 9 | Decorated empty content | Decorator chain on empty string |
| 10 | Isolated observable + single strategy | Independent wiring without `NotificationService` |