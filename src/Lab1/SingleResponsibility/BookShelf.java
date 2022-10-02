package Lab1.SingleResponsibility;

import java.util.ArrayList;

public class BookShelf {
    private static ArrayList<String> bookShelf = new ArrayList<>();

    public static String addToBookShelf(Book newBook) {
        String response;
        if(bookShelf.contains(newBook.getBookName())){
            response = "The book \"" + newBook.getBookName() + "\" is already on the book shelf.";
        } else {
            bookShelf.add(newBook.getBookName());
            response = "The book \"" + newBook.getBookName() + "\" has been place on the book shelf.";
        }
        return response;
    }

    public static ArrayList<String> viewBookShelf() {
        return bookShelf;
    }

    public static String removeFromBookShelf(Book book) {
        String response;
        if(bookShelf.contains(book.getBookName())){
            bookShelf.remove(book.getBookName());
            response = "The book \"" + book.getBookName() + "\" has been removed from the bookshelf.";
        } else {
            response = "The book \"" + book.getBookName() + "\" can't be removed. It is not on the book shelf.";
        }
        return response;
    }
}
