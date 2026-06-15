# Template Method Design Pattern

A demonstration of the **Template Method Design Pattern** implemented in Java, modeling a machine learning model training and evaluation pipeline.

---

## Design Pattern Description

The **Template Method Pattern** is a behavioral design pattern that defines the skeleton of an algorithm in a method of a superclass, deferring some steps to subclasses. It lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

### Key Characteristics
1. **Template Method**: A method in the base class (often declared `final`) that defines the skeleton/flow of the algorithm. In this project, `Model.executePipeline()` acts as the template method.
2. **Abstract/Primitive Operations**: Steps of the algorithm that must be implemented by concrete subclasses (e.g., `load()`, `preprocess()`, `train()`, `evaluate()`, `save()`).
3. **Hook Methods (Optional)**: Methods in the base class that have default empty or basic implementations, allowing subclasses to hook into the algorithm at specific points if needed.

---

## UML Diagram

The following class diagram shows the structure of the Template Method Pattern implementation:

```mermaid
classDiagram
    class Model {
        <<abstract>>
        +executePipeline() void
        +load()* void
        +preprocess()* void
        +train()* void
        +evaluate()* void
        +save()* void
    }
    class DecisionTree {
        +load() void
        +preprocess() void
        +train() void
        +evaluate() void
        +save() void
    }
    class NeuralNetwork {
        +load() void
        +preprocess() void
        +train() void
        +evaluate() void
        +save() void
    }
    class SVM {
        +load() void
        +preprocess() void
        +train() void
        +evaluate() void
        +save() void
    }
    class Main {
        +main(args: String[]) void
    }

    Model <|-- DecisionTree
    Model <|-- NeuralNetwork
    Model <|-- SVM
    Main ..> Model : uses
```

---

## How to Run

You can build, run, and clean up the project automatically using the provided PowerShell script:

```powershell
.\run.ps1
```
