public class AcademicBook extends Book {
    private String subject;

    public AcademicBook(String title, String auteur, String ISBN, double price, int quantityInStock, String subject) {
        super(title, auteur, ISBN, price, quantityInStock);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMediaType() {
        return isBestseller() ? "Bestselling Academic Book" : "Academic Book";
    }


    public String toString() {
        return super.toString() + " \n    Subject=" + subject + "";
    }
}
