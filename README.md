UP TO DATE
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

The app is fully modularized to ensure each module is as loosely coupled as possible , which provides us with a lot
of benefits as explained in the official docs.
(Note : As of now modularization seems overkill since there is not too much of functionality but it is done by
keeping scalability in mind)

## Architecture

The core architecture of the app follows **MVVM** and elements of **Functional Reactive Programming**  

### Overview

The main paradigm followed is FRP(Functional reactive Programming) paradigm which is an endless cycle of states and events:
State -> Event -> State' -> Event' -> State'' -> …. 
Every FRP program starts with an initial state that will be updated with each event it receives.

![Design](https://static.wixstatic.com/media/fdfbff_c281e26662c8470dbb260e3c97e6a510~mv2.png)

### WHY?

The MVVM architecture is a widely adopted architecture pattern in Android app development.
It helps to separate concerns and improve code maintainability and testability by dividing the app into three components :
the Model (data layer), the View (UI layer), and the ViewModel (glue layer between the Model and the View).

The android world is filled with **events** oiginating from user or android system and based on those events the **state**  
need to be updated,This is where Functional Reactive Programming pattern can be utilized.Functional Reactive Programming (FRP) is a programming 
paradigm that is based on the concept of reactive streams, which are a sequence of events that can be observed and reacted to. 

By combining MVVM with FRP, we can benefit from the strengths of both patterns.

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
