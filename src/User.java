import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String username;
    private String email;
    private ArrayList<Media> purchasedMedia;
    private ArrayList<Media> shoppingCart;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.purchasedMedia = new ArrayList<>();
        this.shoppingCart = new ArrayList<>();
    }
    public User() {
        this.username = username;
        this.email = email;
        this.purchasedMedia = new ArrayList<>();
        this.shoppingCart = new ArrayList<>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPurchasedMedia(ArrayList<Media> purchasedMedia) {
        this.purchasedMedia = purchasedMedia;
    }

    public void setShoppingCart(ArrayList<Media> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Media> getPurchasedMedia() {
        return purchasedMedia;
    }

    public ArrayList<Media> getShoppingCart() {
        return shoppingCart;
    }

    public void addToCart(Media media) {
        shoppingCart.add(media);
    }

    public void removeFromCart(Media media) {
        shoppingCart.remove(media);
    }

    public void checkout() {
        Scanner scanner=new Scanner(System.in);
        Review myReview=new Review();

        for (Media media : shoppingCart) {
            addToPurchased(media);
        }
        shoppingCart.clear();

        for(Media m:getPurchasedMedia() ){
            if (m.getMediaType().contains("Noval")||m.getMediaType().contains("Book")){
                System.out.println("add your review for "+m.getTitle());
                System.out.println("rating");
                int rating=scanner.nextInt();
                System.out.println("comment");
                String comment=scanner.nextLine();scanner.next();
                myReview.setUsername(getUsername());
                myReview.setRating(rating) ;
                myReview.setComments(comment) ;

                ((Book) m).addReview(myReview);
            }else continue;
        }

    }

    public void addToPurchased(Media media) {
        purchasedMedia.add(media);
    }

    @Override
    public String toString() {
        return "\nclient name=" + username + " Email=" + email + "";
    }
}
