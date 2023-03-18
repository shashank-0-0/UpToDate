**UPTODATE**
==================

The primary focus of this application is not on **What** to build rather on **How** to build and explore all
the latest trends in the android world.Its built entirely with Kotlin and Jetpack Compose.

# Features

Currently the app displays a list of Space pictures from the NASA Api and the user can save pictures locally.
Its still a work in progress 🚧.
The focus is on writing scalable code so that more feature's can be easily integrated without having the overhead
of refactoring the a lot of existing code.

# Decisions

## Modularization

Decided to fully modularize the app  to ensure each module is as loosely coupled as possible , which provides us with a lot
of benefits like scalability , maintainability ,lower build time etc.
(Note : As of now modularization seems overkill since there is not too much of functionality but it is done by
keeping scalability in mind)

## Architecture

The core architecture of the app follows **MVVM** and elements of **Functional Reactive Programming**  

### Overview

The main paradigm followed is FRP(Functional reactive Programming) paradigm which is an endless cycle of states and events:
State -> Event -> State' -> Event' -> State'' -> …. 
Every FRP program starts with an initial state that will be updated with each event it receives.

![Design](https://static.wixstatic.com/media/fdfbff_c281e26662c8470dbb260e3c97e6a510~mv2.png)

The architecture followed is described in a little more detail in [overview](docs\Overview.md)

## Tech Stack

### Core

- Kotlin
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Jetpack Compose Navigation](https://developer.android.com/jetpack/compose/navigation)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Kotlin Flows](https://kotlinlang.org/docs/flow.html)
- [Hilt](https://dagger.dev/hilt/) (DI)

### Persistence
- [Room DB](https://developer.android.com/training/data-storage/room)

### Networking
- [Ktor Client](https://ktor.io/docs/getting-started-ktor-client.html) (REST client)

## References
- [FRP (Functional Reactive Programming)](https://www.toptal.com/android/functional-reactive-programming-part-1)
- [Ivy Wallet](https://github.com/Ivy-Apps/ivy-wallet)
