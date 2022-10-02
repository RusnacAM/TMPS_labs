package Lab1.SingleResponsibility;

import Lab1.SingleResponsibility.Book;

public class Review {

    public static String reviewBook(Book book, String comment, int rating) {
        String response;
        if(rating > 5 || rating < 1){
            response = "The rating should be between 1 and 5.";
        } else {
            response =  "Review: \n" +
                        "Name: " + book.getBookName() + "\n" +
                        "Rating: " + rating + "\n" +
                        "Comment: " + book.getBookGenre() + "\n";
        }

        return response;
    }
}
