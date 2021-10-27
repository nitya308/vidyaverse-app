# STEM_Resources_App
We're a community service club that mentors elementary and middle school students in STEM in Bangalore. This is our App for distributing educational resources.

## Structure
The structure of the app is as follows:
 ```
 -- src
    | -- main
    |   |-- MainActivity.java // contains the main resources in the app
    |   |-- InfoAbout.java //information about the app & our service project
    |   |-- Links.java //external links to our project
    |
    |-- resources-experiments // resources for practical STEM labs called in MainActivity
    |
    |-- resources-youtubevideos // plays curated and update-able YouTube STEM resources playlist called in MainActivity
 ```
## Navigation Drawer
The app has a left side toggle navigation drawer that uses:
```
import androidx.drawerlayout.widget.DrawerLayout;
private DrawerLayout drawer;
```

This drawer is initalized in each class when ```onCreate()``` is called. It's structure is:
```
 -- navigation drawer
    | -- App logo
    | -- switch (item.getItemId()) {
    |   |-- case R.id.home: calls to MainActivity.class
    |   |-- case R.id.About: calls to InfoAbout.class
    |   |-- case R.id.links: calls to Links.class
 ```  
 
 Drawer state is toggled using:
  ```
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
 ```
## MainActivity.java
MainActivity.java places calls to two main classes depending on which option is selected:
```
 -- MainActivity.java
    | -- ExperimentsActivity.java (https://github.com/nitya308/STEM_Resources_App/tree/master/app/src/main/java/nityaagarwala/example/testing/experiments)
    | -- VideosPlayingActivity.java (https://github.com/nitya308/STEM_Resources_App/blob/master/app/src/main/java/nityaagarwala/example/testing/youtubevideos/VideosPlayingActivity.java)
 ```  
