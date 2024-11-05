import java.util.ArrayList;

public class Movie extends Media {
    private int duration;

    public Movie(String title, String auteur, String ISBN, double price, int duration) {
        super(title, auteur, ISBN, price);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void watch(User user) {
        user.addToPurchased(this);
    }

    public void recommendSimilarMovies(ArrayList<Movie> movieCatalog) {
        System.out.println("Recommended movies by " + getAuteur() + ":");
        for (Movie movie : movieCatalog) {
            if (movie.getAuteur().equals(this.getAuteur()) && !movie.equals(this)) {
                System.out.println(movie.getTitle());
            }
        }
    }

    public String getMediaType() {
        return duration >= 120 ? "Long Movie" : "Short Movie";
    }

    public String toString() {
        return super.toString() + " Duration=" + duration + " minutes ";
    }
}
