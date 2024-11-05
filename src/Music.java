import java.util.ArrayList;

public class Music extends Media {
    private String artist;

    public Music(String title, String artist, String ISBN, double price) {
        super(title, artist, ISBN, price);
        this.artist = artist;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void listen(User user) {
        user.addToPurchased(this);
    }

    public void generatePlaylist(ArrayList<Music> musicCatalog) {
        System.out.println("Playlist with songs by " + artist + ":");
        for (Music music : musicCatalog) {
            if (music.artist.equals(this.artist)) {
                System.out.println(music.getTitle());
            }
        }
    }

    public String getMediaType() {
        return getPrice() >= 10 ? "Premium Music" : "general Music";
    }

    public String toString() {
        return super.toString() + " \n    Artist=" + artist + "";
    }
}
