package Lab4.SecondProject.Strategy;

public class SmallDiscountStrategy implements DiscountStrategy{
    private double smallDiscount = 0.1;
    private double averageDiscount = 0.3;

    @Override
    public double discount(int amount) {
        if(amount <= 100) {
            return amount - (amount * smallDiscount);
        } else if(amount <=500) {
            return amount - (amount * averageDiscount);
        } else if(amount > 500) {
            return amount - (amount * averageDiscount);
        }
        return amount;
    }
}
