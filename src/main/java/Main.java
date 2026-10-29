import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {
    static final int MAX_BOOKS = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[MAX_BOOKS];
        int count = 0;
        int choice;

        do {
            System.out.println();
            System.out.println("1) Add a new book");
            System.out.println("2) List all books");
            System.out.println("3) Borrow a book");
            System.out.println("4) Return a book");
            System.out.println("5) Show library statistics");
            System.out.println("0) Exit program");
            choice = readNumber(sc, "Your choice: ");

            switch (choice) {
                case 1:
                    if (count >= MAX_BOOKS) {
                        System.out.println("The library is full, you cannot add more than " + MAX_BOOKS + " books.");
                        break;
                    }
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    int year = readNumber(sc, "Year published: ");
                    books[count] = new Book(title, author, year);
                    count++;
                    System.out.println("Book added.");
                    break;
                case 2:
                    if (count == 0) {
                        System.out.println("The library is empty");
                    }
                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ") ");
                        books[i].printInfo();
                    }
                    break;
                case 3:
                    int borrowNumber = readNumber(sc, "Book number : ");
                    if (borrowNumber < 1 || borrowNumber > count) {
                        System.out.println("Invalid book number.");
                    } else if (books[borrowNumber - 1].borrow()) {
                        System.out.println("Book borrowed.");
                    } else {
                        System.out.println("Book is already borrowed.");
                    }
                    break;
                case 4:
                    int returnNumber = readNumer(sc, "Book number: ");
                    if (returnNumber < 1 || returnNumber > count) {
                        System.out.println("Invalid book number.");
                    } else if (books[returnNumber - 1].giveBack()) {
                        System.out.println("Book returned.");
                    } else {
                        System.out.println("The book is not borrowed, so it can't be returned.");
                    }
                    break;
                case 5:
                    int borrowedCount = 0;
                    for (int i = 0; i < count; i++) {
                        if (books[i].isBorrowed()) {
                            borrowedCount++;
                        }
                    }
                    System.out.println("Total books: " + count);
                    System.out.println("Borrowed books: " + borrowedCount);
                    System.out.println("Available books: " + (count - borrowedCount));
                    break;
                case 0:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
    static int readNumber(Scanner sc, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter whole number.");
            }
        }
    }
}