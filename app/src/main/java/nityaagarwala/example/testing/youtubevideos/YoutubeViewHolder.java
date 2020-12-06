package nityaagarwala.example.testing.youtubevideos;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.youtube.player.YouTubeThumbnailView;

import nityaagarwala.example.testing.R;

//ViewHolder class for YouTube videos

public class YoutubeViewHolder extends RecyclerView.ViewHolder {

    public YouTubeThumbnailView videoThumbnailImageView;
    public TextView videoTitle;

    public YoutubeViewHolder(View itemView) {
        super(itemView);
        videoThumbnailImageView = itemView.findViewById(R.id.video_thumbnail_image_view);
        videoTitle = itemView.findViewById(R.id.video_title_label);
    }
}
