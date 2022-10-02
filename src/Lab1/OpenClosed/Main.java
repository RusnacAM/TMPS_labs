package Lab1.OpenClosed;

public class Main {
    public static void main(String[] args) {
        HardCover book1 = new HardCover("Pride and Prejudice", 15, true);
        Paperback book2 = new Paperback("Little Women", 10, false);

        System.out.println(book1.getName() + " has initial price: " + book1.getPrice() + "\nAfter applied discount: " + book1.applyCupon());
        System.out.println(book2.getName() + " has initial price: " + book2.getPrice() + "\nAfter applied discount: " + book2.applyCupon());

        //Fix the discount thing
    }
}
