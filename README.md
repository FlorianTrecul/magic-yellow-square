<h1 align="center">Magic Yellow Square</h1>

<p align="center">
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

<p align="center"> 

Make a native Android application displaying a 70 pixels yellow square that can be moved on the whole screen.
Displaying the central position of the square and the date.
Save the data of the movements of the square and the date in a database.

</p>
</br>

## Technical Stack & Open-source Libraries
- Sdk minimum 21+
- [Kotlin](https://kotlinlang.org/), [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) - For the Asynchronous part.
- [Hilt](https://dagger.dev/hilt/) - For dependency injection.
- Jetpack
  - [Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle) - To observe the data when the life cycle state changes.
  - [Navigation Component](https://developer.android.com/guide/navigation) - To allow the user to navigate the application through the different screens.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - To store and manage user interface data in a lifecycle fashion
- Architecture
  - MVVM Architecture (Model - View - ViewModel)
  - Repository pattern
  - Clean Architecture
- [Room](https://developer.android.com/training/data-storage/room) - A database to enable data persistence.
- [Timber](https://github.com/JakeWharton/timber) - A library to allow logging.

## Architecture
Magic Yellow Square is based on MVVM architecture, Repository pattern with a database and Clean Architecture.
The use of Clean Architecture allows you to make the application evolve quickly and easily and the database allows data persistence.

## Features
- Use a [Pager](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) to make the loading of the list of items more fluid.
- Add Unit Tests, Integration Tests, End-to-End Tests, etc. To avoid regressions, to ensure the correct functioning of the application in spite of the modifications made over time, etc, 
  This is a learning point, because it seems important to me for the proper functioning of an application in the long term.





