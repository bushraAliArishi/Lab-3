import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Media Store!");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);


        ArrayList<Media> addMediaList = new ArrayList<>();
        Novel novel1 = new Novel("The Fantasy Journey", "Author X", "ISBN789", 19.99, 5, "Fantasy");
        Novel novel2 = new Novel("Sci-Fi Odyssey", "Author Y", "ISBN012", 25.99, 3, "Science Fiction");
        Novel novel3 = new Novel("Mystery at Midnight", "Author Z", "ISBN345", 15.99, 8, "Mystery");
        Novel novel4 = new Novel("Romantic Getaway", "Author W", "ISBN678", 18.99, 4, "Romance");
        Novel novel5 = new Novel("Horror Nights", "Author V", "ISBN901", 22.99, 2, "Horror");

        AcademicBook academicBook1 = new AcademicBook("Introduction to JAVA", "Author A", "ISBN101", 29.99, 10, "Programming");
        AcademicBook academicBook2 = new AcademicBook("Data Structures", "Author B", "ISBN202", 35.99, 5, "Computer Science");
        AcademicBook academicBook3 = new AcademicBook("Linear Algebra", "Author C", "ISBN303", 27.99, 7, "Mathematics");
        AcademicBook academicBook4 = new AcademicBook("Quantum Physics", "Author D", "ISBN404", 39.99, 3, "Physics");
        AcademicBook academicBook5 = new AcademicBook("World History", "Author E", "ISBN505", 24.99, 6, "History");

        Music music1 = new Music("Top Hits", "Artist A", "ISBN234", 9.99);
        Music music2 = new Music("Classical Favorites", "Artist B", "ISBN345", 12.99);
        Music music3 = new Music("Rock Legends", "Artist C", "ISBN456", 11.99);
        Music music4 = new Music("Jazz Essentials", "Artist D", "ISBN567", 13.99);
        Music music5 = new Music("Pop Hits", "Artist E", "ISBN678", 10.99);


        Movie movie1 = new Movie("Epic Adventure", "Director A", "ISBN567", 14.99, 150);
        Movie movie2 = new Movie("Comedy Night", "Director B", "ISBN678", 12.99, 120);
        Movie movie3 = new Movie("Horror Marathon", "Director C", "ISBN789", 16.99, 140);
        Movie movie4 = new Movie("Sci-Fi Thriller", "Director D", "ISBN890", 18.99, 160);
        Movie movie5 = new Movie("Drama Classics", "Director E", "ISBN901", 15.99, 130);

        Store store = new Store();

        store.addUser(user);
        store.getMediaList().add(novel1);
        store.getMediaList().add(novel2);
        store.getMediaList().add(novel3);
        store.getMediaList().add(novel4);
        store.getMediaList().add(novel5);
        store.getMediaList().add(academicBook1);
        store.getMediaList().add(academicBook2);
        store.getMediaList().add(academicBook3);
        store.getMediaList().add(academicBook4);
        store.getMediaList().add(academicBook5);
        store.getMediaList().add(music1);
        store.getMediaList().add(music2);
        store.getMediaList().add(music3);
        store.getMediaList().add(music4);
        store.getMediaList().add(music5);
        store.getMediaList().add(movie1);
        store.getMediaList().add(movie2);
        store.getMediaList().add(movie3);
        store.getMediaList().add(movie4);
        store.getMediaList().add(movie5);

        store.addUser(user);


        boolean display = true;
        while (display) {
            System.out.println("\nWelcome to the Media Store, " + user.getUsername() + "!");
            System.out.println("1. View Media");//printMedia
            System.out.println("2. Add Media to Store");
            System.out.println("3. Checkout");
            System.out.println("4. Search for a Book");
            System.out.println("5. View Purchased Media");//printMedia
            System.out.println("6. Add Media to Cart");
            System.out.println("7. Remove from Media to Cart");
            System.out.println("8. Exit");

            System.out.print("Select ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:store.displayMedias();
                    break;
                case 2:
                    store.addMedia();
                    break;
                case 3:
                    if (user.getShoppingCart().size() > 0) {

                        user.checkout();
                    } else System.out.println("your cart is empty ");
                    break;
                case 4:
                    System.out.println("enter search key ");
                    String search = scanner.next();
                    if(store.searchBook(search)==null){
                        System.out.println("didn't find the book");
                    }else store.searchBook(search).toString();
                    break;
                case 5:if (user.getPurchasedMedia().size()>0){
                    user.getPurchasedMedia().toString();

                }else System.out.println("you didn't Purchased any item");

                    break;
                case 6:
                    System.out.println("enter the item number to add to the cart or -1 to exit");
                    while (true) {
                        int itmeAdd = scanner.nextInt();
                        if (itmeAdd > 0) {
                            user.addToCart(store.getMediaList().get(itmeAdd-1));
                            System.out.println("the item added ");
                        } else
                            break;
                    }
                    break;
                case 7:
                    for (int i = 0; i < user.getShoppingCart().size(); i++) {
                                System.out.println((i+1)+" :"+user.getShoppingCart().get(i).toString());
                            }
                    System.out.println("enter the item number to remove to the cart or -1 to exit");
                    while (true) {
                                int itmeAdd = scanner.nextInt();
                                if (itmeAdd > 0) {
                                    user.removeFromCart(user.getShoppingCart().get(itmeAdd-1));
                                    System.out.println("the item added ");
                                } else break;
                            }
                    break;
                        case 8:
                            System.out.println("Exiting the Media Store. \nThank you for visiting!");
                            display=false;
                            break;



            }
        }
    }

}

