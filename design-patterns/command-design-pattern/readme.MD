# Command Design Pattern — Smart Home Remote

A Java implementation of the **Command** behavioural design pattern, modelling a smart-home remote that controls household appliances (AC, Fan, Light).

---

## What is the Command Pattern?

The Command pattern encapsulates a request as an object, thereby decoupling the sender (invoker) from the receiver. The invoker only knows how to call `execute()` and `undo()` on a command — it never directly touches the appliance.

| Role | Class in this project |
|---|---|
| **Command** (interface) | `Command` |
| **Concrete commands** | `AcCommand`, `FanCommand`, `LightCommand` |
| **Receivers** | `Ac`, `Fan`, `Light` |
| **Invoker** | `Remote` |
| **Client** | `Main` |

---

## Project structure

```
command-design-pattern/
└── src/
    └── main/
        └── java/
            ├── Main.java
            ├── run.ps1
            ├── appliances/
            │   ├── Ac.java
            │   ├── Fan.java
            │   └── Light.java
            ├── commands/
            │   ├── Command.java        ← interface
            │   ├── AcCommand.java
            │   ├── FanCommand.java
            │   └── LightCommand.java
            └── controllers/
                └── Remote.java
```

---

## How it works

1. **`Remote`** holds a list of `Command` slots and a parallel `isPressed` boolean list.
2. Calling `pressButton(index)` toggles the pressed state — first press calls `execute()`, second press calls `undo()`, and so on.
3. Each `Command` implementation holds a reference to its receiver and delegates to it.
4. The `Remote` is completely decoupled from the appliances — adding a new appliance only requires a new `Command` class with no changes to `Remote`.

---

## Running the project

### Prerequisites

- Java 11 or later (`java` and `javac` on your `PATH`)
- PowerShell 5.1+ (Windows) or PowerShell 7+ (cross-platform)

### Steps

```powershell
# Navigate to the source root
cd src/main/java

# Allow script execution (one-time, if needed)
Set-ExecutionPolicy -Scope CurrentUser RemoteSigned

# Compile and run
./run.ps1
```

The script compiles all `.java` files into a local `out/` directory and then runs `Main`.

---

## Demo cases

`Main.java` exercises eight scenarios:

| Case | What it demonstrates |
|---|---|
| 1 | First press turns all appliances **on** |
| 2 | Second press turns all appliances **off** |
| 3 | Toggling a single appliance four times |
| 4 | Each button tracks its state independently |
| 5 | Reassigning a button to a different receiver at runtime |
| 6 | Null-slot guard — unassigned buttons print a warning, not a crash |
| 7 | Two remotes sharing one physical receiver |
| 8 | Stress test — 10-button remote cycling all lights on and off |

---

## Key design benefits shown

- **Open/closed principle** — add a new appliance by writing one new `Command` class; `Remote` is untouched.
- **Undo support** — every command carries its own `undo()` logic.
- **Runtime flexibility** — commands can be swapped or reassigned while the program runs (Case 5).
- **Null safety** — `Remote` guards against unassigned slots gracefully (Case 6).