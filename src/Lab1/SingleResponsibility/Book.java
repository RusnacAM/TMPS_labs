package Lab1.SingleResponsibility;

public class Book {
    private String name;
    private String author;
    private String genre;
    private int isbn;

    public Book(String name, String author, String genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        isbn = (int)(Math.random()*(99999-10000+1)+10000);
    }

    public String getBookName() {
        return name;
    }

    public String getBookAuthor(){
        return author;
    }

    public String getBookGenre(){
        return genre;
    }

    public int getBookISBN(){
        return isbn;
    }
}
