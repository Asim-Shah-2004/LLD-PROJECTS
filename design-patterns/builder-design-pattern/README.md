# Builder Design Pattern

The **Builder Pattern** is a creational design pattern that allows the step-by-step construction of complex objects. Unlike other creational patterns that construct objects in a single call, the Builder pattern guides the construction process parameter by parameter, allowing different representations of the same object to be created using the same construction process.

This repository demonstrates three variations of the Builder Design Pattern in Java:
1. **Simple Builder** (Basic parameter setting with fluent interfaces)
2. **Builder with Director** (Pre-configured configurations managed by a Director)
3. **Step Builder** (Enforced compile-time step-by-step wizard-like construction)

---

## 🏗️ UML Class Diagram

The following diagram illustrates how the three builder pattern implementations are structured and how they interact.

```mermaid
classDiagram
    %% Package Simple Builder
    namespace simplebuilder {
        class HTTP {
            ~String url
            ~String method
            ~String body
            ~String headers
            ~String queryParams
            ~String timeout
            +execute() void
        }
        class HTTPRequestBuilder {
            -HTTP http
            +HTTPRequestBuilder(String url)
            +setMethod(String method) HTTPRequestBuilder
            +setBody(String body) HTTPRequestBuilder
            +setHeaders(String headers) HTTPRequestBuilder
            +setQueryParams(String queryParams) HTTPRequestBuilder
            +setTimeout(String timeout) HTTPRequestBuilder
            +build() HTTP
        }
    }
    HTTPRequestBuilder --> HTTP : builds

    %% Package Builder with Director
    namespace builderwithdirector {
        class CreateGetRequest {
            -HTTPRequestBuilder httpRequestBuilder
            +CreateGetRequest(HTTPRequestBuilder httpRequestBuilder)
            +createGetRequest() void
        }
        class CreatePostRequest {
            -HTTPRequestBuilder httpRequestBuilder
            +CreatePostRequest(HTTPRequestBuilder httpRequestBuilder)
            +createPostRequest(String body) void
        }
    }
    CreateGetRequest --> HTTPRequestBuilder : directs
    CreatePostRequest --> HTTPRequestBuilder : directs

    %% Package Step Builder
    namespace stepbuilder {
        class URLStep {
            <<interface>>
            +withUrl(String url) MethodStep
        }
        class MethodStep {
            <<interface>>
            +setMethod(String method) HeaderStep
        }
        class HeaderStep {
            <<interface>>
            +setHeaders(String headers) OptionalStep
        }
        class OptionalStep {
            <<interface>>
            +setBody(String body) OptionalStep
            +setQueryParams(String queryParams) OptionalStep
            +setTimeout(String timeout) OptionalStep
            +build() HTTP
        }
        class StepHTTP [HTTP] {
            ~String url
            ~String method
            ~String body
            ~String headers
            ~String queryParams
            ~String timeout
            +execute() void
        }
        class StepHTTPRequestBuilder [HTTPRequestBuilder] {
            -String url
            -String method
            -String body
            -String headers
            -String queryParams
            -String timeout
            +withUrl(String url) MethodStep
            +setMethod(String method) HeaderStep
            +setHeaders(String headers) OptionalStep
            +setBody(String body) OptionalStep
            +setQueryParams(String queryParams) OptionalStep
            +setTimeout(String timeout) OptionalStep
            +build() HTTP
        }
    }
    
    StepHTTPRequestBuilder ..|> URLStep : implements
    StepHTTPRequestBuilder ..|> MethodStep : implements
    StepHTTPRequestBuilder ..|> HeaderStep : implements
    StepHTTPRequestBuilder ..|> OptionalStep : implements
    StepHTTPRequestBuilder --> StepHTTP : builds
```

---

## 🔍 Implementation Variants

### 1. Simple Builder
This is the standard approach to the Builder pattern.
* **Goal**: Solve the **Telescoping Constructor** anti-pattern (where a class has multiple constructors with long parameter lists, making code hard to read and write).
* **How it works**: The `HTTPRequestBuilder` class contains a private instance of `HTTP`. Methods like `setMethod()`, `setHeaders()`, and `setTimeout()` assign values to fields step-by-step and return `this` (the builder instance), allowing method chaining. Finally, `build()` is called, checking for required parameters (URL and Method) before returning the built `HTTP` object.

```java
HTTP http = new HTTPRequestBuilder("https://google.com")
    .setMethod("GET")
    .setHeaders("Content-Type: application/json")
    .setTimeout("10000")
    .build();
```

### 2. Builder with Director
* **Goal**: Abstract the construction process of commonly used configurations to avoid code duplication.
* **How it works**: The **Director** (`CreateGetRequest` and `CreatePostRequest`) wraps a Builder. The Director knows the specific sequence of steps needed to build pre-defined shapes of requests (e.g. GET requests or POST requests with specific headers). The client instantiates the builder, hands it to the Director, and runs the pre-configured steps.

```java
HTTPRequestBuilder builder = new HTTPRequestBuilder("https://google.com");
CreateGetRequest director = new CreateGetRequest(builder);

director.createGetRequest(); // Sets GET method and headers
HTTP http = builder.build();
```

### 3. Step Builder (Wizard Pattern)
* **Goal**: Enforce a strict build sequence at compile-time. For example, you cannot set headers before setting a URL and a Method, and you can only build after all mandatory fields are provided.
* **How it works**: We split the builder's interface into single-method interfaces (`URLStep`, `MethodStep`, `HeaderStep`, `OptionalStep`).
  * `URLStep` returns `MethodStep`.
  * `MethodStep` returns `HeaderStep`.
  * `HeaderStep` returns `OptionalStep`.
  * Only `OptionalStep` contains the optional configurations and the final `.build()` method.
  
This creates an "IDE-guided" sequence. The compiler checks that you follow the strict order, making it impossible to create an invalid request configuration.

```java
HTTP http = new stepbuilder.HTTPRequestBuilder()
    .withUrl("https://google.com")  // Returns MethodStep
    .setMethod("POST")               // Returns HeaderStep
    .setHeaders("Content-Type: json")// Returns OptionalStep
    .setBody("{\"name\":\"john\"}") // Returns OptionalStep
    .build();                        // Builds stepbuilder.HTTP
```

---

## 🚀 Execution

To compile, run, and clean the project, you can use the provided PowerShell script. It automatically manages the lifecycle of the compiled classes to keep your directory clean.

### Running via PowerShell

Run the following command in your PowerShell terminal:

```powershell
.\run.ps1
```

If you encounter execution policy issues, run:

```powershell
powershell -ExecutionPolicy Bypass -File .\run.ps1
```

### Script Lifecycle
1. **Clean**: Deletes any pre-existing `.class` files in the directory.
2. **Compile**: Compiles all Java files under `src/main/java` using `javac`.
3. **Execute**: Runs the `Main` class to showcase the simple builder, director, and step builder implementations.
4. **Purge**: Cleans up the compiled `.class` files after execution, leaving the directory artifact-free.
