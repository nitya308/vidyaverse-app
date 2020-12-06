package nityaagarwala.example.testing.experiments;

import nityaagarwala.example.testing.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

//Class to display full experiment
public class ExpShowActivity extends AppCompatActivity {

    private String materials;
    private String steps;
    private String expl;
    private String title;
    private int imageid;
    private String TAG="ShowActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "Show Called");
        //Setting layout
        setContentView(R.layout.experiment_show);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar4);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //Retrieving values from message
        Intent intent = getIntent();
        materials = intent.getStringExtra("materials");
        steps=intent.getStringExtra("steps");
        expl=intent.getStringExtra("expl");
        title= intent.getStringExtra("title");
        imageid= intent.getExtras().getInt("image");
        populateview();
    }

    //Displaying full experiment
    protected void populateview()
    {
        TextView titleTV= findViewById(R.id.exp_title);
        titleTV.setText(title);
        ImageView imgV= findViewById(R.id.imageView2);
        imgV.setImageResource(imageid);
        TextView materialsTV= findViewById(R.id.materials);
        materialsTV.setText(materials);
        TextView stepsTV= findViewById(R.id.steps);
        stepsTV.setText(steps);
        TextView explTV= findViewById(R.id.explanation);
        explTV.setText(expl);

    }
}
