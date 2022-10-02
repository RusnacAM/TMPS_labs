package Lab1.SingleResponsibility;

import Lab1.SingleResponsibility.Book;

import java.util.ArrayList;

public class Purchase {
    private static ArrayList<String> purchaseList = new ArrayList<>();

    public static String purchaseBook(Book currBook){
        String response;
        if(purchaseList.contains(currBook.getBookName())){
            response = "The book \"" + currBook.getBookName() + "\" has already been purchased.";
        } else {
            purchaseList.add(currBook.getBookName());
            response =  "Successful book purchase: \n" +
                        "Name: " + currBook.getBookName() + "\n" +
                        "Author: " + currBook.getBookAuthor() + "\n" +
                        "Genre: " + currBook.getBookGenre() + "\n" +
                        "ISBN: " + currBook.getBookISBN() + "\n";
        }
        return response;
    }
}
