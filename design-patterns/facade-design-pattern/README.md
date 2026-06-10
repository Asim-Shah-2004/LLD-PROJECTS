# Facade Design Pattern — Home Theater Demo

A clean Java implementation of the **Facade** structural design pattern,
modelled as a smart home theater system.

---

## Pattern Summary

> **"Provide a unified interface to a set of interfaces in a subsystem.
> Facade defines a higher-level interface that makes the subsystem easier to use."**
> — Gang of Four

The Facade pattern is useful when:
- A subsystem is complex and has many moving parts
- You want to provide a simple entry point for common workflows
- You want to decouple clients from subsystem internals

---

## Project Structure

```
facade-pattern/
├── run.ps1                          ← compile & run (PowerShell)
├── README.md
└── src/main/java/
    ├── subsystem/                   ← Complex internal subsystems
    │   ├── Amplifier.java           │  Audio signal, volume, surround sound
    │   ├── Projector.java           │  Lamp, resolution, aspect ratio, HDMI
    │   ├── StreamingPlayer.java     │  Boot, codec, buffer, play, subtitles
    │   ├── SmartLighting.java       │  Zones, brightness, colour temp, scenes
    │   └── CoolingSystem.java       │  HVAC, fan speed, air purifier
    │
    ├── facade/
    │   └── HomeTheaterFacade.java   ← Single facade; exposes start() / stop()
    │
    └── client/
        └── HomeTheaterClient.java   ← Client; knows only the facade
```

---

## Key Design Decisions

### `start()` and `stop()` are `final`

```java
public final void start(String movieTitle) { ... }
public final void stop()                   { ... }
```

These methods are declared `final` deliberately.
The **orchestration sequence** (what order subsystems power up/down) is a
contract of the facade. Allowing subclasses to override it would break the
guarantee that, for example, the projector lamp is always cooled before shutdown,
or the amplifier always gets an input source before volume is set.
`final` enforces this invariant.

### Client isolation

`HomeTheaterClient` has **zero imports** from the `subsystem` package.
It only imports `facade.HomeTheaterFacade`. This is the pattern's payoff:
the client can't accidentally call subsystem methods in the wrong order.

### Composition over inheritance

`HomeTheaterFacade` holds references to subsystem objects (composition).
It does NOT extend any of them. Facade is a **wrapper**, not a subtype.

---

## How to Run

### Requirements
- JDK 11 or later
- PowerShell 5.1+ (Windows) or PowerShell 7+ (cross-platform)

### Steps

```powershell
# Navigate to the project root
cd path\to\facade-pattern

# Run the script
.\run.ps1
```

The script will:
1. Verify `javac` is available
2. Compile all `.java` files into `out/`
3. Execute `client.HomeTheaterClient`

---

## Expected Output (abridged)

```
Client: I just want to watch a movie.
Client: I'll use the facade — no idea how any of this works internally.

╔══════════════════════════════════════════════════════╗
║  STARTING HOME THEATER — "Interstellar (2014)"       ║
╚══════════════════════════════════════════════════════╝

[CoolingSystem] HVAC unit activated.
[CoolingSystem] Target temperature → 22.0°C.
[CoolingSystem] Fan speed → LOW.
[CoolingSystem] Air purifier ON (HEPA + Activated Carbon).
[SmartLighting] System armed. All zones online.
[SmartLighting] Scene: MOVIE — dim warm glow.
[Amplifier]     Powering on... self-test passed.
[Amplifier]     Input source switched to: HDMI-1.
[Amplifier]     Dolby Surround Sound ENABLED.
[Amplifier]     Volume set to 45.
[Projector]     Lamp igniting... warming up.
[Projector]     Resolution set to: UHD_4K.
[Projector]     Aspect ratio set to: RATIO_21_9.
[StreamingPlayer] Booting up...
[StreamingPlayer] Loading: "Interstellar (2014)"...
[StreamingPlayer] Codec negotiated: H265_HEVC.
[StreamingPlayer] Buffering... 100% ready.
[StreamingPlayer] Subtitles ON [EN].
[StreamingPlayer] ▶ Playing: "Interstellar (2014)"

╔══════════════════╗
║  ENJOY THE SHOW! ║
╚══════════════════╝
```

---

## Comparison: Without vs With Facade

| Without Facade | With Facade |
|---|---|
| Client must know 5 classes | Client knows 1 class |
| Client must call ~15 methods in correct order | Client calls `start()` |
| Adding a new subsystem breaks all clients | Client is untouched |
| Shutdown order is ad-hoc | `stop()` guarantees safe teardown |

---

## Further Reading

- *Design Patterns* — Gamma, Helm, Johnson, Vlissides (GoF), Chapter 4
- Facade vs Adapter: Facade simplifies; Adapter converts interfaces
- Facade vs Mediator: Facade is one-way (client → facade → subsystems); Mediator coordinates two-way communication between subsystem objects
