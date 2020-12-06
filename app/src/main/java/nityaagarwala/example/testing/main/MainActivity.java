package nityaagarwala.example.testing.main;

import nityaagarwala.example.testing.R;
import nityaagarwala.example.testing.experiments.ExperimentsHomeActivity;
import nityaagarwala.example.testing.youtubevideos.VideosPlayingActivity;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private String TAG="Main";

    //Setting layout, initializing Toolbar and drawer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "Oncreatecalled");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar1);
        setSupportActionBar(myToolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    //Options for navigation drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent= new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.About:
                Intent intent2= new Intent(this, InfoAbout.class);
                Log.e(TAG, "called");
                startActivity(intent2);
                break;
            case R.id.links:
                Intent intent3 = new Intent(this, Links.class);
                startActivity(intent3);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Toggle drawer state
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //To load YouTube Activity if corresponding button clicked
    public void loadYTActivity(View view) {
        Intent intent = new Intent(this, VideosPlayingActivity.class);
        startActivity(intent);
    }

    //To load ExperimentsActivity if corresponding button clicked
    public void loadExpActivity(View view) {
        Intent intent = new Intent(this, ExperimentsHomeActivity.class);
        startActivity(intent);
    }
}

