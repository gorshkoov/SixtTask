SixtTask
=============================
Here is the test task for Sixt. 

## Description
As an Android engineer I want a small Android app that displays a group of cars on a map and a list, so I can see if you are the Android developer we are looking for.
## Acceptance Criteria
- Implement an app in Kotlin (preferably) or Java that retrieves and displays our cars both on a map and on a list.
  - The list of cars can be found at https://cdn.sixt.io/codingtask/cars
   - In case any car images are missing, use a fall-back image.
- You may use any external frameworks and libraries you like, just add a short note explaining why you chose them.
- Show us what you care about when it comes to architecture, structure, clean code, UI/UX, error- handling and automated testing.

## Used libraries
- **Kotlin** as the main language of the app;
- **Dagger 2 Android** as the dependency injection library;
- **View model** and **Live data** for communication between views and data logic layer;
- **Coroutines** for async operations;
- **Constraint layout** for layout creation;
- **TimberKt** for logging;
- **Retrofit2** for network requests;
- **Google Maps** for map showing;
- **Glide** for image loading;
- **Mockito kotlin 2**, **Kotlin coroutines test**, **Junit** for testing.

## Notes
Design used the same colours as the original Sixt app.
If you want to run the map, please create your own GoogleMap key or use the keystore from this repository.

The signed apk file is [here](https://drive.google.com/file/d/1D3alrknUY8-D7gMMg0r-4MMVSQ4RHgS-/view).
