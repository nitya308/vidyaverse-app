package nityaagarwala.example.testing.youtubevideos;

// Class to create YoutubeVideoModel objects
// YoutubeVideoModel objects will be used to display YouTube videos
public class YoutubeVideoModel {
    private String videoId, title;

    //Function to retrieve variable
    public String getVideoId() {
        return videoId;
    }

    //Storing value in object variable
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    //Function to retrieve variable
    public String getTitle() {
        return title;
    }

    //Storing value in object variable
    public void setTitle(String title) {
        this.title = title;
    }

    //Returning string values of all attributes
    @Override
    public String toString() {
        return "YoutubeVideoModel{" +
                "videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}