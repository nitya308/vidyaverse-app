package nityaagarwala.example.testing.experiments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import nityaagarwala.example.testing.R;

//Adapter for ExpModelViewHolder Class

public class ExpModelAdapter extends RecyclerView.Adapter<ExpModelViewHolder> {
    private static final String TAG = ExpModelAdapter.class.getSimpleName();
    private Context context;
    private ArrayList<ExpModel> expModelArrayList;


    //Constructor to retrieve context and ArrayList
    public ExpModelAdapter(Context context, ArrayList<ExpModel> expModelArrayList) {
        this.context = context;
        this.expModelArrayList = expModelArrayList;
    }

    // Inflating layout
    @Override
    public ExpModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.experiments_custom_layout, parent, false);
        return new ExpModelViewHolder(view);
    }

    // Setting items in layout
    @Override
    public void onBindViewHolder(ExpModelViewHolder holder, final int position) {

        final ExpModel expModel = expModelArrayList.get(position);
        holder.expTitle.setText(expModel.getTitle());
        holder.intro.setText(expModel.getIntro());
        holder.image.setImageResource(expModel.getimageId());
    }

    // To avoid null error: setting ArrayList to length 0
    @Override
    public int getItemCount() {
        return expModelArrayList != null ? expModelArrayList.size() : 0;
    }
}


