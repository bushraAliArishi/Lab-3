public class Review {
    private String username;
    private int rating;
    private String comments;

    public Review(String username, int rating, String comments) {
        this.username = username;
        this.rating = rating;
        this.comments = comments;
    }
 public Review() {
        this.username = username;
        this.rating = rating;
        this.comments = comments;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "\n    Review from=" + username + "\n    Rating=" + rating + "\n    Comments=" + comments + "";
    }
}
