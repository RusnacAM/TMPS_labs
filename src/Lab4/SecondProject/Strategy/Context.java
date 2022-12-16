package Lab4.SecondProject.Strategy;

public class Context {
    private DiscountStrategy strategy;

    public Context(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(int amount) {
        return strategy.discount(amount);
    }
}
