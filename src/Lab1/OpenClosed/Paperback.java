package Lab1.OpenClosed;

public class Paperback implements BookPrice {
    private String name;
    private int initPrice;
    private Boolean cupon;
    private int finalPrice;

    public Paperback(String name, int price, Boolean cupon){
        this.name = name;
        initPrice = price;
        this.cupon = cupon;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        finalPrice = initPrice*2;
        return finalPrice;
    }

    public int applyCupon(){
        if(cupon){
            finalPrice /= 10;
        } else {
            System.out.println("There is no discount for this book.");
        }
        return finalPrice;
    }
}
