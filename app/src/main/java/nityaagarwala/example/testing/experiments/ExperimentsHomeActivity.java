package nityaagarwala.example.testing.experiments;
import nityaagarwala.example.testing.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//Class to introduce experiments
public class ExperimentsHomeActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "ExpHomeMESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting layout that shows categories for experiments
        setContentView(R.layout.activity_experimentshome);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    //Starting ExperimentsActivity by passing selected category as message
    public void loadC1Exp(View view) {
        Intent intent = new Intent(this, ExperimentsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "C1");
        startActivity(intent);
    }

    public void loadC2Exp(View view) {
        Intent intent = new Intent(this, ExperimentsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "C2");
        startActivity(intent);
    }
    public void loadC3Exp(View view) {
        Intent intent = new Intent(this, ExperimentsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "C3");
        startActivity(intent);
    }
}
