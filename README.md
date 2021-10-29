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
MainActivity.java places calls to two main classes depending on which option is selected. This two-fold division splits the **resources** in the app into two main components:  
```
 -- MainActivity.java
    | -- ExperimentsActivity.java //resources for practical STEM labs 
    | -- VideosPlayingActivity.java // plays curated and update-able YouTube STEM resources playlist
 ```  

Both sub-activity classes use a **RecyclerView** (``` import androidx.recyclerview.widget.RecyclerView```) to display a list of resources that is loaded as the user scrolls.  


## ExperimentsActivity.java - Recycler View
The Recycler view widget has two methods which are called in ``` onCreate()```   
1. ``` setUpRecyclerView();``` 
This method displays boxes with available lab practical notes. It sets a fixed size for the widget (= the number of resources available) and creates and assigns it a new LinearLayoutManager.
``` 
private void setUpRecyclerView() {
        recyclerView = findViewById(R.id.exprecycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
``` 

2. ``` populateRecyclerView();```  
This method populates each card in the Recycler view by setting an adapter for it. 
 
``` 
    private void populateRecyclerView() {
        final ArrayList<ExpModel> expModelArrayList = generateDummyExpList();
        ExpModelAdapter adapter = new ExpModelAdapter(this, expModelArrayList);

        //Setting adapter for Recycle View
        recyclerView.setAdapter(adapter);
```   
 ```ExpModelAdapter.java```   then gets the experiment title, introduction and intro image for each box in the Recycler View from ```  ExpModel.java```   which stores these fields. These are displayed in the Recycler View boxes  
 ```  
    public void onBindViewHolder(ExpModelViewHolder holder, final int position) {

        final ExpModel expModel = expModelArrayList.get(position);
        holder.expTitle.setText(expModel.getTitle());
        holder.intro.setText(expModel.getIntro());
        holder.image.setImageResource(expModel.getimageId());
    }
    ```   
  
``` populateRecyclerView();```  also overrides ```onItemClick()``` which is called when an item in the Recycler view is clicked. It displays the full notes for a particular lab practical box clicked.  
```
        //Setting click event to display full experiment when clicked
        recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(this, new RecyclerViewOnClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(ExperimentsActivity.this, ExpShowActivity.class);
                intent.putExtra("image", ExpImageArray[position]);
                intent.putExtra("title", expTitleArray[position]);
                intent.putExtra("materials", materialsArray[position]);
                intent.putExtra("steps", stepsArray[position]);
                intent.putExtra("expl", explanationArray[position]);
                startActivity(intent);
            }
        }));
    ``` 
