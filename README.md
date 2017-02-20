# ALTestApp
AL coding challenge

## Goals
Display a scrollable list of r/funny images with a title. <a href="https://api.imgur.com" target="_blank">Imgur Api Doc</a>

Implement the following features:
* Filter out NSFW images.
* Implement pagination. (Infinite scrolling is better)
* Implement pull to refresh.
* Persist imgur data so that you do not fetch new data on orientation change.
* Create a detail view when the user clicks on an image.
* Implement a response cache.
* Implement an image cache.
* Create a custom view for the list item showing a rounded image, title, number of views, and number of upvotes.
* Create separate portrait and landscape layouts.
* Implement unit tests.
* Implement UI tests.
* Prepare release to market version


### Solution ###

* Project Type: *Android Studio*
* Platform: *Android*
* Min SDK: *16*
* Target SDK: *22*

### Third party libs ###

Using the following dependencies:


* **Android Support Libs**
    * Appcompat-v7
* **Square Libs**
    * Retrofit 1.9.0
    * OkHttp 2.4.0
    * OkHttpUrlConnection 2.2.0
    * Picasso 2.5.2

### Tested Devices ###

The project has been tested on the following devices:

* **Genymotion**
    * *Android v4.2.2/SDK 17*
* **LG Nexus 5**
    * *Android v5.1/SDK 22*

### Things to improve / missing ###

* Better UI/UX designs
* Missings Dialogs
* No Android tests