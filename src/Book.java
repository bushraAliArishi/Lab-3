import java.util.ArrayList;

public class Book extends Media {
    private int quantityInStock;
    private ArrayList<Review> reviews;

    public Book(String title, String auteur, String ISBN, double price, int quantityInStock) {
        super(title, auteur, ISBN, price);
        this.quantityInStock = quantityInStock;
        this.reviews = new ArrayList<>();
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) return 0; // Avoid division by zero
        int totalRating = 0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }
        return (double) totalRating / reviews.size();
    }

    public void purchase(User user) {
        if (quantityInStock > 0) {
            user.addToPurchased(this);

            quantityInStock--;
        } else {
            System.out.println("Out of stock.");
        }
    }

    public boolean isBestseller() {
        return getAverageRating() >= 4.5;
    }

    public void restock(int quantity) {
        quantityInStock += quantity;
        System.out.println("Restocked " + quantity + " units.");
    }


    public String getMediaType() {
        return isBestseller() ? "Bestselling Book" : "Book";
    }


    public String toString() {
        return super.toString() + " Quantity in stock=" + quantityInStock + " ";
    }
}
