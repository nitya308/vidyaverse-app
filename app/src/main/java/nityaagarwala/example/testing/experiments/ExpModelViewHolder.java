package nityaagarwala.example.testing.experiments;

import nityaagarwala.example.testing.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

//ViewHolder class for ExpModel

public class ExpModelViewHolder extends RecyclerView.ViewHolder{
    public ImageView image;
    public TextView expTitle;
    public TextView intro;

    public ExpModelViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageView_expImage);
        expTitle = itemView.findViewById(R.id.textView_experimentTitle);
        intro= itemView.findViewById(R.id.textView_intro);
    }
}
