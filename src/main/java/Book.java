public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private boolean borrowed;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.borrowed = false; //New books are always available
    }

    public boolean borrow() {
        if (borrowed) {
            return false;
        }
        borrowed = true;
        return true;
    }
    public boolean giveBack() {
        if (!borrowed) {
            return false;
        }
        borrowed = false;
        return true;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void printInfo() {
        System.out.println("Title: " + title + ", author: " + author + ", year: " + yearPublished
                + ", " + (borrowed ? "borrowed" : "available"));
    }
}