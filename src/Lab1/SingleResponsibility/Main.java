package Lab1.SingleResponsibility;

public class Main {
    public static void main(String[] args) {

        // Create the books
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Romance");
        Book book2 = new Book("Little Women", "Louisa May Alcott", "Romance, Drama");

        // Purchase books
        System.out.println(Purchase.purchaseBook(book1) + "\n");
        System.out.println(Purchase.purchaseBook(book2) + "\n");
        System.out.println(Purchase.purchaseBook(book1) + "\n");

        // Add books to shelf
        System.out.println(BookShelf.addToBookShelf(book1) + "\n");
        System.out.println(BookShelf.addToBookShelf(book2) + "\n");
        System.out.println(BookShelf.addToBookShelf(book2) + "\n");

        // View book shelf
        System.out.println("BookShelf: \n" + BookShelf.viewBookShelf() + "\n");

        // Remove books from book shelf
        System.out.println(BookShelf.removeFromBookShelf(book1) + "\n");
        System.out.println(BookShelf.removeFromBookShelf(book1) + "\n");
        System.out.println("BookShelf: \n" + BookShelf.viewBookShelf() + "\n");

        //Review books
        System.out.println(Review.reviewBook(book1, "Great book.", 4) + "\n");
        System.out.println(Review.reviewBook(book2, "Compelling story and characters.", 5) + "\n");

    }
}
