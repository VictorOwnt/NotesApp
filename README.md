<p align="center"><img src="./app/src/main/ic_launcher-playstore.png?raw=true" width="200px"/></p>

<h1 align="center">Notes Android application</h1>

The 'Notes' Android application is an application made to facilitate the process of keeping notes.<br/>
This app uses the [NotesBackend](https://github.com/VictorOwnt/NotesBackend).

This project is part of the [Native Apps I](https://bamaflexweb.hogent.be/BMFUIDetailxOLOD.aspx?a=113418&b=1&c=1) course for the Bachelor of Applied Informatics at the Ghent University College [HoGent](https://www.hogent.be/en/) (Academic year 2019-2020).

## Screenshots

<p align="center">
    <img src="screenshots/overview.jpg?raw=true" width="256px">
    <img src="screenshots/create.jpg?raw=true" width="256px">
    <img src="screenshots/edit.jpg?raw=true" width="256px">
    <img src="screenshots/delete.jpg?raw=true" width="256px">
    <img src="screenshots/copy.jpg?raw=true" width="256px">
</p>

---

## Documentation
To see the documentation of this app, click [here](dokka/app/index.md). <br/>
This application was documented with
* [Dokka](https://github.com/Kotlin/dokka)

## Getting Started

You can't download the application on the Google Play store yet.

### Installation

1. Clone this repo

    ```bash
    git clone https://github.com/VictorOwnt/NotesApp
    ```

2. Open the project in Android Studio

    ```bash
    studio NotesApp-VictorOwnt
    ```

3. Run the project on an emulator or physical device

### Generating signed APK

From Android Studio:

1. ***Build*** menu
2. ***Generate Signed APK...***
3. Fill in the keystore information *(you only need to do this once manually and then let Android Studio remember it)* OPTIONAL

### REST backend

This application relies on a REST backend server.

1. Open the `Constants.kt` file located in the `util` package.
2. Change the value for `API_URL` to your own link.

The sourcecode for this server is located [here](https://github.com/VictorOwnt/NotesBackend). The server is currently hosted by [Google Cloud](https://cloud.google.com) [![Website](https://img.shields.io/website?label=backend&logo=google%20cloud&url=https%3A%2F%2Fnotes-api-p4tlzt4yxq-ew.a.run.app)](https://notes-api-p4tlzt4yxq-ew.a.run.app).

## Built With

* [Retrofit](https://square.github.io/retrofit/)
* [Koin](https://insert-koin.io)
* [ReactiveX](http://reactivex.io/)

## Creator

| <a href="https://github.com/VictorOwnt" target="_blank">**Victor Van Hulle**</a> |
| --- |
| [![Victor](https://avatars2.githubusercontent.com/u/17174095?s=200)](https://github.com/VictorOwnt) |
