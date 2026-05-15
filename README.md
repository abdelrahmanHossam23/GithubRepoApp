# GithubRepoApp

GithubRepoApp is a Kotlin-based Android application designed to interact with the GitHub API, retrieve repository and issue data, and display them with an intuitive user interface. The app follows best practices for modular architecture and dependency injection, making the codebase organized, scalable, and easily testable.

---

## Table of Contents

- [Project Structure](#project-structure)
- [Features](#features)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Build & Run](#build--run)
- [Testing](#testing)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

---

## Project Structure

```
.githubrepoapp/
|-- app/
|   |-- build.gradle.kts
|   |-- proguard-rules.pro
|   |-- src/
|       |-- main/
|           |-- AndroidManifest.xml
|           |-- java/
|               |-- com/example/githubrepoapp/
|                   |-- MyApplication.kt
|                   |-- data/
|                   |-- di/
|                   |-- domain/
|                   |-- ui/
|-- build.gradle.kts
|-- gradle/
|   |-- libs.versions.toml
|   |-- wrapper/
|-- gradle.properties
|-- gradlew
|-- gradlew.bat
|-- settings.gradle.kts
```

### Main Modules

- **data**  
  Data layer, containing sources, repositories, mappers, and app-wide constants.
- **di**  
  Dependency Injection configuration using modules (database, network, repository).
- **domain**  
  Business logic: models, use-cases, repository interfaces.
- **ui**  
  User interface: activities, screens, navigation, theming, and utilities.
- **MyApplication.kt**  
  The custom Application class for initializing app-wide services.

---

## Features

- Retrieve and display GitHub repositories and their details.
- List and present GitHub issue data.
- Decoupled, modular code with clear separation of concerns.
- Mappers to transform data for domain and presentation layers.
- Utilizes dependency injection for testability and scalability.

---

## Architecture

- **Language:** 100% [Kotlin](https://kotlinlang.org/)
- **Layers:** Follows clean architecture:
  - **Data:** Handles data fetching, caching, and mapping (`dataSources`, `repository`, `mapper`).
  - **Domain:** Contains use-cases, repository contracts, and business logic models.
  - **UI:** Activities and Compose screens for presentation, navigation, and theming.
  - **DI:** Dependency injection setup, leveraging modules for modularity and easy testing.

- **Directory Highlights:**
  - `data/dataSources/local` and `data/dataSources/remote`: For handling local and remote data respectively.
  - `di/DatabaseModule.kt`, `di/NetworkModule.kt`, `di/RepositoryModule.kt`: Dependency injection modules.
  - `ui/screens`, `ui/theme`, `ui/navigation`: Modular UI code.

---

## Getting Started

### Prerequisites

- Android Studio (Arctic Fox or later recommended)
- JDK 11 or above
- Gradle (use the supplied wrapper)

### Setup

1. Clone the repository.
   ```sh
   git clone https://github.com/abdelrahmanHossam23/GithubRepoApp.git
   cd GithubRepoApp
   ```
2. Open in Android Studio.
3. Let Gradle sync and download dependencies.

---

## Build & Run

To build and run the app:

```sh
./gradlew assembleDebug
./gradlew installDebug
```

Or simply click 'Run' in Android Studio.

---

## Testing

Unit and instrumentation tests are located in:

- `app/src/test/`
- `app/src/androidTest/`

To run tests:

```sh
./gradlew test
./gradlew connectedAndroidTest
```

---

## Configuration

- **`gradle.properties`**: Properties for the build system and project
- **`proguard-rules.pro`**: Rules for code shrinking and obfuscation

---

## Contributing

1. Fork the repo.
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes.
4. Push to your branch.
5. Create a Pull Request.

---

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.

---

## Acknowledgments

This app uses the GitHub public API and is inspired by open-source standards for clean Android development.
