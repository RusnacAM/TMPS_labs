package Lab4.SecondProject.Strategy;

public class BigDiscountStrategy implements DiscountStrategy{
    private double halfOff = 0.5;
    private double bigDiscount = 0.75;

    @Override
    public double discount(int amount) {
        if(amount <= 1000 && amount >= 500) {
            return amount - (amount * halfOff);
        } else if(amount > 1000) {
            return amount - (amount * bigDiscount);
        }
        return amount;
    }
}
