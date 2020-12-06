package nityaagarwala.example.testing.experiments;

// Class to create ExpModel objects
// ExpModel objects will be used to display list of experiments
public class ExpModel {
    private int imageId;
    public String title, intro;

    //Function to retrieve variable
    public int getimageId() {
        return imageId;
    }

    //Storing value in object variable
    public void setimageId(int imageId) {
        this.imageId = imageId;
    }

    //Function to retrieve variable
    public String getTitle() {
        return title;
    }

    //Storing value in object variable
    public void setTitle(String title) {
        this.title = title;
    }

    //Function to retrieve variable
    public String getIntro() {
        return intro;
    }

    //Storing value in object variable
    public void setIntro(String intro) {
        this.intro = intro;
    }

   //Returning string values of all attributes
    @Override
    public String toString() {
        return "YoutubeVideoModel{" +
                "imageId='" + imageId + '\'' +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
