package streaming;

import java.util.List;

public class Series implements Content{
    private String title;
    private List<Video> videos;
    private Genre genre;
    private double rating;

    public Series(String title, List<Video> videos, Genre genre, double rating) {
        validateVideos(videos);
        this.title = title;
        this.videos = videos;
        this.genre = genre;
        this.rating = rating;
    }

    private void validateVideos(List<Video> videos) {
        if(videos==null || videos.size()==0){
            throw new IllegalArgumentException("Cannot create Series with empty or null list!");
        }
    }

    @Override
    public int getLength() {
        return videos.stream().mapToInt(v->v.getLength()).sum();
    }

    @Override
    public String getTitle() {
        return title;
    }

    public List<Video> getVideos() {
        return videos;
    }

    @Override
    public Genre getGenre() {
        return genre;
    }

    @Override
    public double getRating() {
        return rating;
    }
}
