import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Media> mediaList;
    private ArrayList<User> users;

    public Store() {
        mediaList = new ArrayList<>();
        users = new ArrayList<>();
    }

    public ArrayList<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(ArrayList<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void addMedia() {
        String tital;
        String auteur;
        String ISBN;
        double price;
        Scanner scanner=new Scanner(System.in);
        System.out.print("witch media will you  add");
        System.out.println("\n:");
        System.out.println("1. Music");
        System.out.println("2. Book");
        System.out.println("3. Movie");
        System.out.println("6. Exit");
        int mediaChoos = scanner.nextInt();
        switch (mediaChoos) {
            case 1:
                System.out.println("pleas enter the music details");
                System.out.println("tital");
                tital = scanner.nextLine();
                System.out.println("auteur");
                auteur = scanner.nextLine();
                System.out.println("ISBN");
                ISBN = scanner.nextLine();
                System.out.println("price");
                price = scanner.nextDouble();
                Music music = new Music(tital, auteur, ISBN, price);
                mediaList.add(music);
                break;
            case 2:
                System.out.println("what type of book do you want Noval or Academy");
                String type = scanner.nextLine();
                if (type == "Noval") {
                    System.out.println("tital");
                    tital = scanner.nextLine();
                    System.out.println("auteur");
                    auteur = scanner.nextLine();
                    System.out.println("ISBN");
                    ISBN = scanner.nextLine();
                    System.out.println("price");
                    price = scanner.nextDouble();
                    System.out.println("quantity In Stock");
                    int quantity = scanner.nextInt();
                    Novel noval = new Novel(tital, auteur, ISBN, price, quantity, "Noval");
                    mediaList.add(noval);
                    break;
                } else {
                    System.out.println("tital");
                    tital = scanner.nextLine();
                    System.out.println("auteur");
                    auteur = scanner.nextLine();
                    System.out.println("ISBN");
                    ISBN = scanner.nextLine();
                    System.out.println("price");
                    price = scanner.nextDouble();
                    System.out.println("quantity In Stock");
                    int quantity = scanner.nextInt();
                    AcademicBook academy = new AcademicBook(tital, auteur, ISBN, price, quantity, "Academic");
                    mediaList.add(academy);
                    break;
                }
            case 3:
                System.out.println("pleas enter the Movie details");
                System.out.println("tital");
                tital = scanner.nextLine();
                System.out.println("auteur");
                auteur = scanner.nextLine();
                System.out.println("ISBN");
                ISBN = scanner.nextLine();
                System.out.println("price");
                price = scanner.nextDouble();
                System.out.println("price");
                int duration = scanner.nextInt();
                Movie movie = new Movie(tital, auteur, ISBN, price, duration);
                mediaList.add(movie);
                break;
        }



    }

    public void displayMedias() {
        for (int i = 0; i < getMediaList().size(); i++) {
            System.out.println((i+1)+" :"+getMediaList().get(i).toString());
        }
    }

    public Media searchBook(String title) {

        for (int i = 0; i < mediaList.size(); i++) {
            if (mediaList.get(i).getTitle()== title)
            {
               return mediaList.get(i);
            }
        }
        return null;
    }

}
