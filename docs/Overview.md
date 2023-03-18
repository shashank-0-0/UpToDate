**OVERVIEW**
=============

## Modularization

The stratergy followed for Modularizing the application is heavily inspired from [nowinandroid](https://github.com/android/nowinandroid)  
and [ivywallet](https://github.com/Ivy-Apps/ivy-wallet) and also keeping loose coupling in mind

### Modules

The app consists of the following modules.

<table>
  <tr>
   <td><strong>Name</strong>
   </td>
   <td><strong>Responsibilities</strong>
   </td>
   <td><strong>Key classes and dependencies</strong>
   </td>
  </tr>
  <tr>
   <td><code>app</code>
   </td>
   <td>Top level module that combines the whole application's modules.Defines all the composable screens and sets up the navigation 
   </td>
   <td><code>App, MainActivity</code><br>
    mainly depends on navigation module <code>navigation</code>
   </td>
  </tr>
  <tr>
   <td><code>navigation</code>
   </td>
   <td>Responsible for handling navigation events through out the whole application .<br>
    Also defines Destinations
   </td>
   <td> contains <code>Navigator</code> and <code>NavHost</code> <code>navcontroller</code> 
   </td>
  </tr>
  <tr>
   <td><code>Home</code>
   </td>
   <td>Contains Home Screen and uses <code>core:Network</code> to fetch images from network<br>
   </td>
   <td> Mainly depends on<code>core:Network</code> <code> core:Persistence</code> 
   </td>
  </tr>
  <tr>
   <td><code>Favourites</code>
   </td>
   <td>Contains Favourites Screen and is responsible for fetching images from database<br>
   </td>
   <td> Depends on <code> core:Persistence</code> 
   </td>
  </tr>
  <tr>
   <td><code>Core:Domain</code>
   </td>
   <td>Contains all the top level abstract declarations used through out the application <br>
   Also includes data models
   </td>
   <td>contains <code> FlowAction</code> <code> SharedFlowAction</code> <code>FlowViewMoel</code> 
   </td>
  </tr>
  <tr>
   <td><code>Core:Network</code>
   </td>
   <td>Handles logic for  fetching data from the network using ktor for Http request and exposing  <br>
   that as Action for other modules to use
   </td>
   <td> <code>ImageDto</code> <code>NetworkFlowAction</code>
   </td>
  </tr>
<tr>
   <td><code>Core:Persistence</code>
   </td>
   <td>Handles logic related to persistence and exposes the functionality <br>
    as Actions for other modules to use
   </td>
   <td> <code>coreDb</code><code>ImageDao</code> <code>ImageEntity</code>
   </td>
  </tr>
</table>


## Architecture

The architecture is primarily MVVM + Functional Reactive programming paradigm

The UI paradigm is an endless cycle of states and events: State -> Event -> State' -> Event' -> State'' -> ….

- A *UIState* made of primitives depicts the state of the screen at a particular instant
- A *UIEvent* depicting all possible events originating from the screens
- [FlowViewModel](../core/domain/src/main/java/com/example/domain/FlowViewModel.kt) producing a Flow of UI states and receiving a Flow events.
- @Composable Screens that transforms UiState to Ui and emitting UIEvents

This way we ensure our Ui is reactive and always has the latest UiState

### Actions

Actions refers to Functions that have side-effects . For example, sending HTTP requests or querying a database.
These are alternate to **repositories** in typical MVVM approach or **use cases** in Clean Architecture.

Actions basically are closely related to the concept of "signals" or "events" in FRP (Functional Reactive Programming).
In FRP, signals are used to represent data streams that can be transformed and combined in various ways to produce new
signals.

Similarly, Actions in MVVM+FRP are functions that represent a stream of data that can be transformed and combined to 
produce new streams of data. Actions are typically used to represent domain logic such as network requests or database queries,
and can be composed together to build more complex functionality.

Few Actions defined so far in the application [ImagesFlow](../core/persistence/src/main/java/com/example/persistence/actions/ImagesFlow.kt) [SaveImageAction](../core/persistence/src/main/java/com/example/persistence/actions/SaveImageAction.kt)




