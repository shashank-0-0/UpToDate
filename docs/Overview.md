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
   <td>Responsible for handling navigation events through out the whole application.<br>
   </td>
   <td>defines Destinations and core <code>Navigator</code> logic 
   </td>
  </tr>
</table>


