# Decorator Pattern

## Overview
The Decorator pattern attaches additional responsibilities to an object dynamically by wrapping it with one or more decorator objects. It provides a flexible alternative to subclassing for extending behavior.

## Key Ideas
- Composition over inheritance: decorators hold a reference to a component.
- Open/closed principle: new behaviors can be added without changing existing classes.
- Behavior stacking: multiple decorators can be combined to build features at runtime.

## Participants
- Component: the common interface for objects that can be decorated.
- Concrete Component: the base object being decorated.
- Decorator: an abstract wrapper that implements the component interface and delegates work.
- Concrete Decorators: add behavior before or after delegating.

## When to Use
- You need to add features at runtime without creating many subclasses.
- You want to combine behaviors in different orders or combinations.

## UML Diagram
```mermaid
classDiagram
    class Character {
        <<interface>>
        +getAbilities()
    }

    class Mario {
        +getAbilities()
    }

    class Decorator {
        <<interface>>
        +getAbilities()
    }

    class HeightBoost {
        -Character ch
        +HeightBoost(Character)
        +getAbilities()
    }

    class GunBoost {
        -Character ch
        +GunBoost(Character)
        +getAbilities()
    }

    class SlowFalling {
        -Character ch
        +SlowFalling(Character)
        +getAbilities()
    }

    Character <|.. Mario
    Character <|.. Decorator
    Decorator <|.. HeightBoost
    Decorator <|.. GunBoost
    Decorator <|.. SlowFalling
    HeightBoost --> Character
    GunBoost --> Character
    SlowFalling --> Character
```

## Run
Use the PowerShell script to compile and run the example, then clean up build output:

```powershell
./run.ps1
```
