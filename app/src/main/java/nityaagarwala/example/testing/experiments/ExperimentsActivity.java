package nityaagarwala.example.testing.experiments;

import nityaagarwala.example.testing.R;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//Class to initiate experiments display

public class ExperimentsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String type;
    String[] materialsArray=null;
    String[] stepsArray = null;
    String[] explanationArray = null;
    String[] expTitleArray= null;
    int[] ExpImageArray= null;
    String[] introArray = null;
    private String TAG= "EA";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiments);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar3);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        //Getting type string from ExperimentsHomeActivity
        Intent intent = getIntent();
        type = intent.getStringExtra(ExperimentsHomeActivity.EXTRA_MESSAGE);
        setUpRecyclerView();
        populateRecyclerView();
    }

    // Recycler View to display list of experiments
    private void setUpRecyclerView() {
        recyclerView = findViewById(R.id.exprecycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    // Populating Recycler View
    private void populateRecyclerView() {
        final ArrayList<ExpModel> expModelArrayList = generateDummyExpList();
        ExpModelAdapter adapter = new ExpModelAdapter(this, expModelArrayList);

        //Setting adapter for Recycle View
        recyclerView.setAdapter(adapter);

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
    }

    //Storing arrays based on category selected: physics(C1), chemistry(C2) or biology(C3)
    private ArrayList<ExpModel> generateDummyExpList() {
        ArrayList<ExpModel> expModelArrayList = new ArrayList<>();
        if(type!=null) {
            if (type.equals("C1")) {
                expTitleArray = getResources().getStringArray(R.array.C1_title_array);
                int[] expImageArray = {R.drawable.c1image1, R.drawable.c1image2};
                ExpImageArray = expImageArray;
                introArray = getResources().getStringArray(R.array.C1_intro_array);
                materialsArray = getResources().getStringArray(R.array.C1_materials_array);
                stepsArray = getResources().getStringArray(R.array.C1_steps_array);
                explanationArray = getResources().getStringArray(R.array.C1_expl_array);
            } else if (type.equals("C2")) {
                expTitleArray = getResources().getStringArray(R.array.C2_title_array);
                int[] expImageArray = {R.drawable.c2image1, R.drawable.c2image2, R.drawable.c2image3, R.drawable.c2image4, R.drawable.c2image5};
                ExpImageArray = expImageArray;
                introArray = getResources().getStringArray(R.array.C2_intro_array);
                materialsArray = getResources().getStringArray(R.array.C2_materials_array);
                stepsArray = getResources().getStringArray(R.array.C2_steps_array);
                explanationArray = getResources().getStringArray(R.array.C2_expl_array);
            } else if (type.equals("C3")) {
                expTitleArray = getResources().getStringArray(R.array.C3_title_array);
                int[] expImageArray = {R.drawable.c3image1, R.drawable.c3image2, R.drawable.c3image3};
                ExpImageArray = expImageArray;
                introArray = getResources().getStringArray(R.array.C3_intro_array);
                materialsArray = getResources().getStringArray(R.array.C3_materials_array);
                stepsArray = getResources().getStringArray(R.array.C3_steps_array);
                explanationArray = getResources().getStringArray(R.array.C3_expl_array);
            }
        }

        //Looping through all items to add to ArrayList
        if (expTitleArray != null) {
            for (int i = 0; i < expTitleArray.length; i++) {

                ExpModel expModel = new ExpModel();
                expModel.setTitle(expTitleArray[i]);
                expModel.setimageId(ExpImageArray[i]);
                expModel.setIntro(introArray[i]);
                expModelArrayList.add(expModel);
            }
        }

        return expModelArrayList;
    }

}
