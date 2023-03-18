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
   <td><strong>Key classes</strong>
   </td>
  </tr>
  <tr>
   <td><code>app</code>
   </td>
   <td>Top level module that combines the whole application's modules.Defines all the composable screens and sets up the navigation 
   </td>
   <td><code>App, MainActivity</code><br>
   App-level controlled navigation via <code>NiaNavHost, NiaTopLevelNavigation</code>
   </td>
  </tr>
  <tr>
   <td><code>feature:1,</code><br>
   <code>feature:2</code><br>
   ...
   </td>
   <td>Functionality associated with a specific feature or user journey. Typically contains UI components and ViewModels which read data from other modules.<br>
   Examples include:<br>
   <ul>
      <li><a href="https://github.com/android/nowinandroid/tree/main/feature/topic"><code>feature:topic</code></a> displays information about a topic on the TopicScreen.</li>
      <li><a href="https://github.com/android/nowinandroid/tree/main/feature/foryou"><code>feature:foryou</code></a> which displays the user's news feed, and onboarding during first run, on the For You screen.</li>
      </ul>
   </td>
   <td><code>TopicScreen</code><br>
   <code>TopicViewModel</code>
   </td>
  </tr>
  <tr>
   <td><code>core:data</code>
   </td>
   <td>Fetching app data from multiple sources, shared by different features.
   </td>
   <td><code>TopicsRepository</code><br>
   </td>
  </tr>
  <tr>
   <td><code>core:ui</code>
   </td>
   <td>UI components, composables and resources, such as icons, used by different features.
   </td>
   <td><code>NiaIcons</code><br>
   <code>NewsResourceCardExpanded</code>
   </td>
  </tr>
  <tr>
   <td><code>core:common</code>
   </td>
   <td>Common classes shared between modules.
   </td>
   <td><code>NiaDispatchers</code><br>
   <code>Result</code>
   </td>
  </tr>
  <tr>
   <td><code>core:network</code>
   </td>
   <td>Making network requests and handling responses from a remote data source.
   </td>
   <td><code>RetrofitNiaNetworkApi</code>
   </td>
  </tr>
  <tr>
   <td><code>core:testing</code>
   </td>
   <td>Testing dependencies, repositories and util classes.
   </td>
   <td><code>NiaTestRunner</code><br>
   <code>TestDispatcherRule</code>
   </td>
  </tr>
  <tr>
   <td><code>core:datastore</code>
   </td>
   <td>Storing persistent data using DataStore.
   </td>
   <td><code>NiaPreferences</code><br>
   <code>UserPreferencesSerializer</code>
   </td>
  </tr>
  <tr>
   <td><code>core:database</code>
   </td>
   <td>Local database storage using Room.
   </td>
   <td><code>NiaDatabase</code><br>
   <code>DatabaseMigrations</code><br>
   <code>Dao</code> classes
   </td>
  </tr>
  <tr>
   <td><code>core:model</code>
   </td>
   <td>Model classes used throughout the app.
   </td>
   <td><code>Topic</code><br>
   <code>Episode</code><br>
   <code>NewsResource</code>
   </td>
  </tr>
</table>


