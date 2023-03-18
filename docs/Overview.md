**OVERVIEW**
=============

## Modularization

The stratergy followed for Modularizing the application is heavily inspired from ![nowinandroid](https://github.com/android/nowinandroid)  
and ![ivywallet] and also keeping loose coupling in mind

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
   <td> core <code>Navigator</code> and <code>NavHost</code> <code>navcontroller</code> 
   </td>
  </tr>
  <tr>
   <td><code>Home</code>
   </td>
   <td>Contains Home Screen and is responsible for fetching images by making network request<br>
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
</table>


