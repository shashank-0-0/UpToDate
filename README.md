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

The main paradigm followed is FRP paradigm which is an endless cycle of states and events: State -> Event -> State' -> Event' -> State'' -> …. 
Every FRP program starts with an initial state that will be updated with each event it receives.
![Design](https://static.wixstatic.com/media/fdfbff_912ea9e2966941d1a2811d8380b4a899~mv2.png)












 
